package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AnalizyTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenCheckUnavailable() throws IOException {
        String source = "./data/server.log";
        File target = folder.newFile("target.txt");
        new Analizy().unavailable("./data/server.log", target.getAbsolutePath());
        try (BufferedReader reader = new BufferedReader(new FileReader(target))) {
            assertThat(reader.readLine(), is("10:58:01;10:59:01"));
            assertThat(reader.readLine(), is("11:01:02;11:02:02"));
            assertThat(reader.readLine(), is("11:05:34;11:09:00"));
        }
    }

    @Test
    public void whenCheckUnavailable2() throws IOException {
        String source = "./data/server.log";
        File target = folder.newFile("target.txt");
        new Analizy().unavailable("./data/server2.log", target.getAbsolutePath());
        try (BufferedReader reader = new BufferedReader(new FileReader(target))) {
            assertThat(reader.readLine(), is ("10:58:01;10:59:01"));
            assertThat(reader.readLine(), is ("11:01:02;"));
        }
    }
}