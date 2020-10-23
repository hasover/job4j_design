package ru.job4j.collection;

import org.junit.Before;
import org.junit.Test;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleLinkedListTest {
    SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList<>();

    @Before
    public void setUp() {
        simpleLinkedList.add(0);
        simpleLinkedList.add(1);
        simpleLinkedList.add(2);
        simpleLinkedList.add(3);
        simpleLinkedList.add(4);
    }

    @Test
    public void whenCanAdd() {
        simpleLinkedList.add(5);
        assertThat(simpleLinkedList.get(5), is(5));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenCannotGet() {
        simpleLinkedList.get(5);
    }

    @Test
    public void whenCanGet() {
        assertThat(simpleLinkedList.get(3), is(3));
    }

    @Test
    public void whenCanIterate() {
        Iterator<Integer> iterator = simpleLinkedList.iterator();
        assertThat(iterator.next(), is(0));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.next(), is(4));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenIterationFails() {
        Iterator<Integer> iterator = simpleLinkedList.iterator();
        iterator.next();
        simpleLinkedList.add(30);
        iterator.next();
    }
}