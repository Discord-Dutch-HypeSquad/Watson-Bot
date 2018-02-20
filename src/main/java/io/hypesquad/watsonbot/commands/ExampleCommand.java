package io.hypesquad.watsonbot.commands;

import io.hypesquad.watsonbot.objects.command.ICommand;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

/**
 * This is a command to display how commands should be made
 *
 * @author Duncan
 */
public class ExampleCommand implements ICommand {
    @Override
    public void execute(String invoke, String[] args, MessageReceivedEvent event) {
        event.getChannel().sendMessage("This is an example");
    }

    @Override
    public String getName() {
        return "example";
    }

    @Override
    public String getHelp() {
        return "This is an example command\n" +
                "Usage: `!" + getName() + "`";
    }
}
