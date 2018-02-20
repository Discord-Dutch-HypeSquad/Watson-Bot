package io.hypesquad.watsonbot.managers;

import io.hypesquad.watsonbot.commands.ExampleCommand;
import io.hypesquad.watsonbot.objects.command.ICommand;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * This is a manager that handles adding commands and running commands
 */
public class WatsonCommandManager {

    private final Set<ICommand> commands = ConcurrentHashMap.newKeySet();

    /**
     * This is the constructor where all the commands are registered
     */
    public WatsonCommandManager() {
        this.addCommand(new ExampleCommand());
    }

    /**
     * Returns an unmodifiableSet that contains the commands
     * @return an unmodifiableSet that contains the commands
     */
    public Set<ICommand> getCommands() {
        return Collections.unmodifiableSet(commands);
    }

    /**
     * This attempts to add a command to the commands
     * @param command The command to add
     * @return {@code true} if the command was added
     */
    private boolean addCommand(final ICommand command) {

        if(command.getName().contains(" ")) {
            throw new IllegalArgumentException("Names can't have spaces");
        }
        if(getCommand(command.getName()) != null) {
            return false;
        }
        commands.add(command);
        return true;
    }

    /**
     * @param invoke The command that we are looking for
     * @return A possible null command that matches the invoke or alias
     */
    public ICommand getCommand(final String invoke) {

        //Return nothing if there are no commands
        if(commands.size() == 0) {
            return null;
        }

        Optional<ICommand> foundInvoke = commands.stream().filter(command -> command.getName().equals(invoke)).findFirst();

        if(foundInvoke.isPresent()) {
            return foundInvoke.get();
        } else {
            Optional<ICommand> foundAlias = commands.stream().filter(command -> Arrays.asList(command.getAliases()).contains(invoke)).findFirst();
            //noinspection ConstantConditions
            return foundAlias.get();
        }
    }

    /**
     * This handles a command when a message is received
     * @param prefix The prefix to replace in the message
     * @param event the event that was called with this message
     */
    public void dispatchCommand(final String prefix, final MessageReceivedEvent event) {
        String[] messageContent = event.getMessage().getContent().replaceFirst(prefix, "").split("\\s+");
        String invoke = messageContent[0];

        ICommand cmd = getCommand(invoke);
        if(cmd != null) {
            cmd.execute(invoke, Arrays.copyOfRange(messageContent, 1, messageContent.length), event);
        }
    }

}
