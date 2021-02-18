package ru.job4j.ref;

import java.io.File;

public class FileCacheEmulator {
    private Cache<String, String> fileCache;

    public FileCacheEmulator() {
        fileCache = new FileCache();
    }

    public void saveFilesDataFromDirectory(String directory) {
        File fileDirectory = new File(directory);
        if(!fileDirectory.isDirectory()) {
            return;
        }

        for (File file: fileDirectory.listFiles()) {
            fileCache.addObject(file.getAbsolutePath());
        }
    }

    public String getFileData(String filePath) {
        return fileCache.getObject(filePath);
    }

    public static void main(String[] args) {
        FileCacheEmulator fileCacheEmulator = new FileCacheEmulator();
        String directory = "C:/test";
        fileCacheEmulator.saveFilesDataFromDirectory(directory);

        for(File file : new File(directory).listFiles()) {
            System.out.println(fileCacheEmulator.getFileData(file.getAbsolutePath()));
        }
    }
}
