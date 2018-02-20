package io.hypesquad.watsonbot.objects.command;

import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

/**
 * This is the base class for all the commands on the bot
 *
 * @author Duncan
 */
public interface ICommand {

    /**
     * This is the part of the command that gets run when the command is executed
     * @param invoke The thing that the user typed after the prefix, example: {@code !hello world}. In this case hello is the invoke
     * @param args Everything that comes after the invoke
     * @param event The {@link MessageReceivedEvent Event} that got fired when the command for the message
     */
    void execute(final String invoke, final String[] args, final MessageReceivedEvent event);

    /**
     * Returns the name of the command
     * @return the name of the command
     */
    String getName();

    /**
     * Returns any optional aliases of the command
     * @return any optional aliases of the command
     */
    default String[] getAliases() { return new String[0]; }

    /**
     * Returns A helpful description of the command with any usage instructions
     * @return A helpful description of the command with any usage instructions
     */
    String getHelp();

}
