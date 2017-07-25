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
 * along with WatsonBot.  If not, see <http://www.gnu.org/licenses/>.
 */
package io.hypesquad.watsonbot.commands;

import io.hypesquad.watsonbot.WatsonBot;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WatsonCommandTest {

    @Test
    public void testCommandExistence() {
        WatsonBot.registerCommands();
        String key = "help";
        WatsonHelpCommand value = new WatsonHelpCommand();

        assertEquals("Retrieved command does not match stored command for same key",
                WatsonBot.commands.get(key), value);
    }
}
