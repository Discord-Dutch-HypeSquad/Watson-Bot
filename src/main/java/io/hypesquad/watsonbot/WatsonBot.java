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

package io.hypesquad.watsonbot;

import io.hypesquad.watsonbot.commands.AbstractWatsonCommand;
import io.hypesquad.watsonbot.commands.AbstractWatsonExampleCommand;
import io.hypesquad.watsonbot.commands.AbstractWatsonHelpCommand;
import io.hypesquad.watsonbot.event.WatsonEventListener;
import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Represents the main class
 *
 * @author Kevin
 */
public class WatsonBot {

    /**
     * This stores all the commands.
     */
    public static Map<String, AbstractWatsonCommand> commands = new ConcurrentHashMap<>();

    public static void main(final String... args) {
        if (args.length < 1)
            throw new IllegalArgumentException("WatsonBot requires a token!");

        IDiscordClient client = new ClientBuilder().withToken(args[0]).login();

        client.getDispatcher().registerListener(new WatsonEventListener());

        //Register the commands
        registerCommands();
    }

    /**
     * This method will register our commands.
     */
    public static void registerCommands() {
        // Add the commands
        commands.put("help", new AbstractWatsonHelpCommand());
        commands.put("example", new AbstractWatsonExampleCommand());
    }
}