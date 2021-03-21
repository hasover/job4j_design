package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    private Map<FileProperty, List<String>> filesInfo = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(file.toFile().length(), file.getFileName().toString());
        filesInfo.computeIfAbsent(fileProperty, k -> new ArrayList<>()).add(file.toAbsolutePath().toString());
        return super.visitFile(file, attrs);
    }

    public Map<FileProperty, List<String>> getFilesInfo() {
        return filesInfo;
    }
}
