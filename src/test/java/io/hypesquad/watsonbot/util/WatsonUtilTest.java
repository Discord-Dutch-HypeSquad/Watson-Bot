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

package io.hypesquad.watsonbot.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests WatsonUtil class
 *
 * @author Kevin
 */
public class WatsonUtilTest {

    @Test
    public void testResourceBundle() {
        String key = "prefix";
        String value = "!";

        assertEquals(String.format("Tests if key %s equals %s", key, value), WatsonUtil.getProperty(key), value);
    }
}
