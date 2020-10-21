package ru.job4j.generics;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {
    private SimpleArray<Integer> simpleArray;

    @Before
    public void setUp() {
        simpleArray = new SimpleArray<>(5);
        simpleArray.add(0);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
    }

    @Test
    public void whenCanAdd() {
        simpleArray.add(4);
        assertThat(simpleArray.get(4), is (4));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenCannotAdd() {
        simpleArray.add(4);
        simpleArray.add(5);
    }

    @Test
    public void removeFirst() {
        simpleArray.remove(0);
        Iterator<Integer> iterator = simpleArray.iterator();
        assertThat(iterator.next(), is (1));
        assertThat(iterator.next(), is (2));
        assertThat(iterator.next(), is (3));
        assertThat(iterator.hasNext(), is (false));
    }

    @Test
    public void removeAll() {
        simpleArray.remove(3);
        simpleArray.remove(2);
        simpleArray.remove(1);
        simpleArray.remove(0);
        Iterator<Integer> iterator = simpleArray.iterator();
        assertThat(iterator.hasNext(), is (false));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenArrayIsEmpty() {
        SimpleArray<Integer> array = new SimpleArray(5);
        Iterator<Integer> iterator = array.iterator();
        iterator.next();
    }

    @Test
    public void whenCanSet() {
        simpleArray.set(3, 10);
        assertThat(simpleArray.get(3), is(10));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenCannotSet() {
        simpleArray.set(4, 10);
    }

}