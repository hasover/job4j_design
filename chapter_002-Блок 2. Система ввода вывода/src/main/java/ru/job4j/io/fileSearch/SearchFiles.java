package ru.job4j.io.fileSearch;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFiles {
    private Arguments arguments;
    private List<String> fileList;
    public SearchFiles(Arguments arguments) {
        this.arguments = arguments;
        fileList = new ArrayList<>();
    }
    private void writeSearchResults() {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(new File(arguments.getOutFile())))) {
            for (String str : fileList) {
                out.write(str + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void findFiles() throws IOException {
        Files.walkFileTree(Paths.get(arguments.getDirectory()), new FileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (arguments.getPattern().matcher(file.toFile().getName()).matches()) {
                    fileList.add(file.toFile().getAbsolutePath());
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                return FileVisitResult.CONTINUE;
            }
        });
        writeSearchResults();
    }

    public static void main(String[] args) throws IOException {
        new SearchFiles(new Arguments(args)).findFiles();
    }
}
