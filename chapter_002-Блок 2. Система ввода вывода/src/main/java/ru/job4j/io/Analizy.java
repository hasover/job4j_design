package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Analizy {
    public void unavailable(String source, String target) {
        String startTime = "";
        String endTime = "";
        List<String> timePeriods = new ArrayList<>();
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
                        timePeriods.add(startTime + ";" + endTime + System.lineSeparator());
                        startTime = "";
                        endTime = "";
                    }
                }
            }
            if (!startTime.equals("")) {
                timePeriods.add(startTime + ";" + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (PrintWriter writer = new PrintWriter(
                                  new BufferedOutputStream(
                                  new FileOutputStream(target)))) {
            timePeriods.forEach(writer::write);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}