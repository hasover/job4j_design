package ru.job4j.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream inFile = new FileInputStream("even.txt")) {
            int read;
            StringBuilder builder = new StringBuilder();
            while ((read = inFile.read()) != -1) {
                builder.append((char)read);
            }
            String[] stringNumbers = builder.toString().split(System.lineSeparator());
            for (String stringNumber : stringNumbers) {
                int number = Integer.parseInt(stringNumber);
                if (number % 2 == 0) {
                    System.out.println(number);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
