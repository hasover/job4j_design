package ru.job4j.ref;

import java.io.*;
import java.lang.ref.SoftReference;

public class FileCache extends Cache<String, String> {

    public void addObject(String filePath) {
        map.put(filePath, new SoftReference<String>(loadFileInfo(filePath)));
    }

    private String loadFileInfo(String filePath) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            reader.lines().forEach(line -> {
                builder.append(line).append(System.lineSeparator());
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}
