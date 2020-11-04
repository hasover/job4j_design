package ru.job4j.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class Dir {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            throw new IllegalArgumentException("Root folder is null. Usage java -jar dir.jar ROOT_FOLDER.");
        }
        File file = new File(args[0]);
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        List<File> projectFiles = new ArrayList<>();
        projectFiles.add(file);
        long totalSize = 0;
        while (!projectFiles.isEmpty()) {
            File currentFile = projectFiles.remove(projectFiles.size() - 1);
            if (currentFile.isDirectory()) {
                projectFiles.addAll(List.of(currentFile.listFiles()));
            } else {
                totalSize += currentFile.length();
            }
        }
        String formattedDouble = String.format("%.2f", (double)totalSize/(1024 * 1024));
        System.out.println("File name:" + file.getName());
        System.out.println("File size:" + formattedDouble+ "MB");
    }
}
