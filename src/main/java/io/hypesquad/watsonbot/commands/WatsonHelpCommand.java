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

public class WatsonHelpCommand implements WatsonCommand {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        StringBuilder s = new StringBuilder().append("```\n");

        for (String cmd : WatsonBot.commands.keySet()) {
            s.append(WatsonUtil.getProperty("prefix")).append(cmd).append(" > ").append(WatsonBot.commands.get(cmd).help()).append("\n");
        }
        s.append("```");
        event.getChannel().sendMessage(s.toString());

    }

    @Override
    public String help() {
        return "Shows a list of all the commands";
    }
}
