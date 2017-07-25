/*
 * This file is part of WatsonBot.
 *
 * WatsonBot is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * WatsonBot is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with WatsonBot. If not, see <http://www.gnu.org/licenses/>.
 */

package io.hypesquad.watsonbot.commands;

import io.hypesquad.watsonbot.WatsonBot;
import io.hypesquad.watsonbot.util.WatsonUtil;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

/**
 * Represents the help command
 *
 * @author Duncan
 */

public final class WatsonHelpCommand extends WatsonCommand {

    @Override
    public boolean checkCommand(final String[] args, final MessageReceivedEvent event) {
        return true;
    }

    @Override
    public void executeCommand(final String[] args, final MessageReceivedEvent event) {

        final StringBuilder stringBuilder = new StringBuilder(80).append("```\n");

        for (final String cmd : WatsonBot.commands.keySet()) {
            stringBuilder.append(WatsonUtil.getProperty("prefix"))
                    .append(cmd)
                    .append(" > ")
                    .append(WatsonBot.commands.get(cmd).commandHelp())
                    .append('\n');
        }
        stringBuilder.append("```");
        event.getChannel().sendMessage(stringBuilder.toString());

    }

    @Override
    public String commandHelp() {
        return "Shows a list of all the commands";
    }
}
