package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LogFilter {
    public static List<String> filter(String file) {
        List<String> logs = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            logs =  reader.
                    lines().
                    map(line -> line.split(" ")).
                    filter(words -> words[words.length - 2].equals("404")).
                    map(words-> String.join(" ",words)).
                    collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return logs;
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        log.forEach(System.out::println);
    }
}