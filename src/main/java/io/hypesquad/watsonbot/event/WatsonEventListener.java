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
import io.hypesquad.watsonbot.commands.WatsonCommand;
import io.hypesquad.watsonbot.util.WatsonUtil;
import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Represents the global EventListener
 *
 * @author Kevin
 */
public class WatsonEventListener {

    //Easy access to our commands
    TreeMap<String, WatsonCommand> commands = WatsonBot.commands;

    @EventSubscriber
    public void onMessageReceivedEvent(MessageReceivedEvent event) {
        final String message = event.getMessage().getContent();
        final String prefix = WatsonUtil.getProperty("prefix"); //change to constant if it's used multiple times

        if (!message.startsWith(prefix))
            return;

        //Handle command
        ArrayList<String> split = new ArrayList<>();
        String raw = message;
        String beheaded = raw.replaceFirst(prefix, "");
        String[] SplitBeheaded = beheaded.split(" ");
        for(String s : SplitBeheaded){split.add(s);}
        String calledCommand = split.get(0).toLowerCase();
        String[] args = new String[split.size() - 1];
        split.subList(1, split.size()).toArray(args);

        // Check if the command exist and if it does, run it
        if(commands.containsKey(calledCommand)){
            boolean safe = commands.get(calledCommand).called(args, event);
            if(safe) commands.get(calledCommand).action(args, event);
        }
    }
}