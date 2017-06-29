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

import io.hypesquad.watsonbot.util.WatsonUtil;
import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

/**
 * Represents the global EventListener
 *
 * @author Kevin
 */
public class WatsonEventListener {

    @EventSubscriber
    public void onMessageReceivedEvent(MessageReceivedEvent event) {
        final String message = event.getMessage().getContent();

        if (!message.startsWith(WatsonUtil.getProperty("prefix"))) //change to constant if it's used multiple times
            return;

        //TODO handle command
    }
}