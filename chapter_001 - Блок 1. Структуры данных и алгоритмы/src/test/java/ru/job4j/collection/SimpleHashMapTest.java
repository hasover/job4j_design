package ru.job4j.collection;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

public class SimpleHashMapTest {
    SimpleHashMap<Integer, String> simpleHashMap = new SimpleHashMap<>();

    @Before
    public void setUp()  {
        simpleHashMap.insert(1, "one");
        simpleHashMap.insert(2, "two");
        simpleHashMap.insert(3, "three");
        simpleHashMap.insert(4, "four");
    }

    @Test
    public void whenInsert() {
        simpleHashMap.insert(5, "five");
        assertThat(simpleHashMap.get(2), is("two"));
        assertThat(simpleHashMap.get(5), is("five"));
    }

    @Test
    public void whenDelete() {
        assertThat(simpleHashMap.get(1), is("one"));
        simpleHashMap.delete(1);
        assertThat(simpleHashMap.get(1), is(nullValue()));
    }

    @Test
    public void whenCannotDelete() {
        assertThat(simpleHashMap.delete(5), is(false));
    }

    @Test
    public void whenIterate() {
        simpleHashMap.delete(2);
        simpleHashMap.delete(3);
        simpleHashMap.delete(1);
        Iterator<Integer> iterator = simpleHashMap.iterator();
        assertThat(iterator.next(), is(4));
        assertThat(iterator.hasNext(), is(false));
    }
}