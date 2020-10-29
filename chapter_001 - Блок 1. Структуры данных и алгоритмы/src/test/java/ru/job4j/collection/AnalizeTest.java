package ru.job4j.collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class AnalizeTest {

    private List<Analize.User> userList = new ArrayList<>();
    private List<Analize.User> newUserList = new ArrayList<>();

    @Before
    public void setUp() {
        userList.add(new Analize.User(1, "one"));
        userList.add(new Analize.User(2, "two"));
        userList.add(new Analize.User(3, "three"));
        userList.add(new Analize.User(4, "four"));
        userList.add(new Analize.User(5, "five"));
        userList.add(new Analize.User(6, "six"));
        userList.add(new Analize.User(7, "seven"));
        userList.add(new Analize.User(8, "eight"));
    }

    @Test
    public void testAddTwoRemoveThreeChange4() {
        newUserList.add(new Analize.User(1, "ONE"));
        newUserList.add(new Analize.User(2, "TWO"));
        newUserList.add(new Analize.User(3, "THREE"));
        newUserList.add(new Analize.User(4, "FOUR"));
        newUserList.add(new Analize.User(8, "eight"));
        newUserList.add(new Analize.User(9, "nine"));
        newUserList.add(new Analize.User(10, "ten"));
        Analize.Info info = Analize.diff(userList, newUserList);
        assertThat(info.added, is(2));
        assertThat(info.changed, is(4));
        assertThat(info.deleted, is(3));
    }

    @Test
    public void testRemoveAll() {
        Analize.Info info = Analize.diff(userList, newUserList);
        assertThat(info.added, is(0));
        assertThat(info.changed, is(0));
        assertThat(info.deleted, is(8));
    }

}