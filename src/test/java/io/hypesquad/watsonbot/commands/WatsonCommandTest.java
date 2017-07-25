package io.hypesquad.watsonbot.commands;

import io.hypesquad.watsonbot.WatsonBot;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WatsonCommandTest {

    @Test
    public void testCommandExistence() {
        String key = "help";
        WatsonHelpCommand value = new WatsonHelpCommand();
        WatsonBot.commands.put(key, value);

        assertEquals(String.format("Tests if key %s equals %s", key, value.toString()), WatsonBot.commands.get(key), value);
    }
}
