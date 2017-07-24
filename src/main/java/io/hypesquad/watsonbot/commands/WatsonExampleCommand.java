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

import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

/**
 * Represents the example command
 *
 * @author Duncan
 */

public class WatsonExampleCommand implements WatsonCommand {

    // Do any checks here because this get's ran first
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return true;
    }

    // The action of the command.
    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        event.getChannel().sendMessage("This is a example command.");
    }

    // How to use the command
    @Override
    public String help() {
        return "A command that shows how commands are structured.";
    }

}
