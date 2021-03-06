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

package io.hypesquad.watsonbot.event;

import io.hypesquad.watsonbot.WatsonBot;
import io.hypesquad.watsonbot.commands.AbstractWatsonCommand;
import io.hypesquad.watsonbot.util.WatsonUtil;
import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

import java.util.Arrays;
import java.util.Map;

/**
 * Represents the global EventListener
 *
 * @author Kevin
 */
public class WatsonEventListener {

    /**
     * This is for easy access to your commands.
     */
    private final transient Map<String, AbstractWatsonCommand> commands = WatsonBot.commands;

    @EventSubscriber
    public void onMessageReceivedEvent(MessageReceivedEvent event) {
        final String message = event.getMessage().getContent();
        //change to constant if it's used multiple times
        final String prefix = WatsonUtil.getProperty("prefix");

        if (!message.startsWith(prefix)) {
            return;
        }

        //Handle command
        final String[] split = message.substring(message.indexOf(prefix) + 1, message.length()).split(" ");
        final String calledCommand = split[0];
        final String[] args = Arrays.copyOfRange(split, 1, split.length);

        // Check if the command exist and if it does, run it
        if (commands.containsKey(calledCommand)) {
            final boolean safe = commands.get(calledCommand).checkCommand(args, event);
            if (safe) {
                commands.get(calledCommand).executeCommand(args, event);
            }
        }
    }
}