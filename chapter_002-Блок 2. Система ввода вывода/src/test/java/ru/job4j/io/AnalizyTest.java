package ru.job4j.io;

import org.junit.Test;

import java.io.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AnalizyTest {
    @Test
    public void whenCheckUnavailable() {
        String target = "./data/target.txt";
        new Analizy().unavailable("./data/server.log", target);
        try (BufferedReader reader = new BufferedReader(new FileReader(target))) {
            assertThat(reader.readLine(), is ("10:58:01;10:59:01"));
            assertThat(reader.readLine(), is ("11:01:02;11:02:02"));
            assertThat(reader.readLine(), is ("11:05:34;11:09:00"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}