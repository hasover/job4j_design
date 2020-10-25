package ru.job4j.collection;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SimpleSetTest {

    @Test
    public void whenTestAdd() {
        SimpleSet<String> simpleSet = new SimpleSet<>();
        simpleSet.add("one");
        simpleSet.add("two");
        simpleSet.add("one");
        simpleSet.add("three");
        simpleSet.add("one");
        simpleSet.add("three");
        Iterator<String> iterator = simpleSet.iterator();
        assertThat(iterator.next(), is("one"));
        assertThat(iterator.next(), is("two"));
        assertThat(iterator.next(), is("three"));
        assertThat(iterator.hasNext(), is(false));
    }

}