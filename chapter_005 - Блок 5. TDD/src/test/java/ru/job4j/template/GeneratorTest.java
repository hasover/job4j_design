package ru.job4j.template;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class GeneratorTest {
    private Generator generator = (template, args) -> null;

    @Test
    public void testGeneratedString() {
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Petr Arsentev");
        map.put("subject", "you");
        assertThat(generator.produce(template, map),
                is("I am a Petr Arsentev, Who are you?"));
    }

    @Test(expected = Exception.class)
    public void testMissingKeys() {
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Petr Arsentev");
        generator.produce(template, map);
    }

    @Test(expected = Exception.class)
    public void testExtraKeys() {
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Petr Arsentev");
        map.put("subject", "you");
        map.put("extra", "extra");
        generator.produce(template, map);
    }
}