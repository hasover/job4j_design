package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    private Map<String, List<String>> duplicates = new HashMap<>();
    private Set<FileProperty> filesSet = new HashSet<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(file.toFile().length(), file.getFileName().toString());
        if (filesSet.contains(fileProperty)) {
            duplicates.computeIfAbsent(fileProperty.getName(), k -> new ArrayList<>()).add(file.toAbsolutePath().toString());
        } else {
            filesSet.add(fileProperty);
        }
        return super.visitFile(file, attrs);
    }

    public Map<String, List<String>> getDuplicates() {
        return duplicates;
    }
}
