package ru.job4j.iterator;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(Arrays.asList(1, 2, 3), Is.is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfter() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2));
        ListUtils.addAfter(input, 1, 3);
        assertThat(Arrays.asList(1, 2, 3), is(input));
    }

    @Test
    public void whenRemoveNegative() {
        List<Integer> input = new ArrayList<>(Arrays.asList(-3, 2, -5, 3, -6, 6));
        ListUtils.removeIf(input, x -> x < 0);
        assertThat(Arrays.asList(2, 3, 6), is(input));
    }

    @Test
    public void whenReplaceNegative() {
        List<Integer> input = new ArrayList<>(Arrays.asList(-3, 2, -5, 3, -6, 6));
        ListUtils.replaceIf(input, x -> x < 0, 0);
        assertThat(Arrays.asList(0, 2, 0, 3, 0, 6), is(input));
    }

    @Test
    public void whenRemove0And1() {
        List<Integer> input = new ArrayList<>(Arrays.asList(5, 6, 0, 3, 1, 2, 0, 1, 1, 3));
        ListUtils.removeAll(input, Arrays.asList(1, 0));
        assertThat(Arrays.asList(5, 6, 3, 2, 3), is(input));
    }

    @Test
    public void whenRemove0And1Again() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 1, 1, 1));
        ListUtils.removeAll(input, Arrays.asList(1, 0));
        assertThat(Collections.EMPTY_LIST, is(input));
    }


}