package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicatesFinder {
    public Map<String, List<String>> findDuplicates(Path directory) throws IOException {
        DuplicatesVisitor visitor = new DuplicatesVisitor();
        Files.walkFileTree(directory, visitor);
        Map<FileProperty, List<String>> filesInfo = visitor.getFilesInfo();
        Map<String, List<String>> duplicates = new HashMap<>();
        for (Map.Entry<FileProperty, List<String>> entry : filesInfo.entrySet()) {
            if (entry.getValue().size() > 1) {
                duplicates.put(entry.getKey().getName(), entry.getValue());
            }
        }
        return duplicates;
    }

    public static void main(String[] args) throws IOException {
        DuplicatesFinder finder = new DuplicatesFinder();
        Map<String, List<String>> map = finder.findDuplicates(Path.of("C:/test"));

        for (String name : map.keySet()) {
            System.out.println("File name:" + name);
            List<String> files = map.get(name);
            files.forEach(System.out::println);
            System.out.println("---------------");
        }
    }
}
