package ru.job4j.ref;

import java.io.*;
import java.lang.ref.SoftReference;

public class FileCache extends Cache<String, String> {

    public String addObject(String filePath) {
        String fileData = loadFileInfo(filePath);
        map.put(filePath, new SoftReference<String>(fileData));
        return fileData;
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
