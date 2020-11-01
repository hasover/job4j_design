package ru.job4j.io;

import java.io.*;
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

    public static void save(List<String> log, String file) {
        try (PrintWriter outFile = new PrintWriter(
                                   new BufferedOutputStream(
                                   new FileOutputStream(file)))) {
            log.forEach(string -> outFile.write(string + System.lineSeparator()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        save(log, "404.txt");
    }
}