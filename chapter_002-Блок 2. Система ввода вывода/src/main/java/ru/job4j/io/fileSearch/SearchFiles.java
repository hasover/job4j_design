package ru.job4j.io.fileSearch;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchFiles {
    private Arguments arguments;
    private List<String> fileList;
    private Predicate<File> predicate;
    public SearchFiles(Arguments arguments) {
        this.arguments = arguments;
        fileList = new ArrayList<>();
        predicate = createPredicate(arguments.getKey(), arguments.getFilePattern());
    }
    public static Predicate<File> createPredicate(String key, String filePattern ) {
        if (key.equals("-m")) {
            return new SearchPatternKeyM(filePattern);
        } else if (key.equals("-f")) {
            return new SearchPatternKeyF(filePattern);
        } else {
            return new SearchPatternKeyR(filePattern);
        }
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
        Files.walkFileTree(Paths.get(arguments.getDirectory()), new SimpleFileVisitor<>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (predicate.test(file.toFile())) {
                    fileList.add(file.toFile().getAbsolutePath());
                }
                return FileVisitResult.CONTINUE;
            }
        });
        writeSearchResults();
    }

    public static void main(String[] args) throws IOException {
        new SearchFiles(new Arguments(args)).findFiles();
    }
}
