package ru.job4j.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MultiplicationTable {
    public static void main(String[] args) {
        try (FileOutputStream outFile = new FileOutputStream("result.txt")) {
            for (int i = 0; i <= 9; i++) {
                String result = "" + i + " * " + "9" + " = " + i * 9 + System.lineSeparator();
                outFile.write(result.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
