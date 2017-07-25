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
 * Represents a Command
 *
 * @author Duncan
 */

public abstract class AbstractWatsonCommand {

    /**
     * This method is ran before the command's action is executed
     *
     * @param args  the arguments from the command
     * @param event the MessageReceivedEvent from D4J
     * @return true or false depending on some checks that we run
     */
    public abstract boolean checkCommand(final String[] args, final MessageReceivedEvent event);

    /**
     * This is the action of the command
     *
     * @param args  the arguments from the command
     * @param event the MessageReceivedEvent from D4J
     */
    public abstract void executeCommand(final String[] args, final MessageReceivedEvent event);

    /**
     * The instructions of the command
     *
     * @return String
     */
    public abstract String commandHelp();

    /**
     * An equals method to compare two command objects
     *
     * @param object The command object
     * @return true if the commands are compared successfully
     */
    @Override
    public boolean equals(Object object) {

        if (object == null) {
            return false;
        }

        if (object.getClass() != this.getClass()) {
            return false;
        }

        AbstractWatsonCommand command = (AbstractWatsonCommand) object;

        return this.commandHelp().equals(command.commandHelp());
    }
}
