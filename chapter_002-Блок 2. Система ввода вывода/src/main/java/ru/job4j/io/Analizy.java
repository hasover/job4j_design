package ru.job4j.io;

import java.io.*;

public class Analizy {
    public void unavailable(String source, String target) {
        String startTime = "";
        String endTime = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             PrintWriter writer = new PrintWriter(
                             new BufferedOutputStream(
                             new FileOutputStream(target))))
        {
            while (reader.ready()) {
                String line = reader.readLine();
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] dataLog = line.split(" ");
                if (dataLog[0].equals("400") || dataLog[0].equals("500")) {
                    if (startTime.equals("")) {
                        startTime = dataLog[1];
                    }
                } else {
                    if (!startTime.equals("")) {
                        endTime = dataLog[1];
                        writer.write(startTime + ";" + endTime + System.lineSeparator());
                        startTime = "";
                        endTime = "";
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}