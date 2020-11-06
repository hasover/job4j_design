package ru.job4j.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    private String[] getBotAnswers() {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(botAnswers, StandardCharsets.UTF_8))) {
            int data;
            while ((data = br.read()) > 0) {
                builder.append((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString().split("[\\s.,:?-]+");
    }

    public void run() {
        String userAnswer = "";
        StringBuilder chatRecord = new StringBuilder();
        String[] listOfBotAnswers = getBotAnswers();
        boolean giveAnswers = true;
        Scanner scanner = new Scanner(System.in);
        while (!userAnswer.equals(OUT)) {
            userAnswer = scanner.nextLine();
            chatRecord.append(userAnswer).append(System.lineSeparator());
            if (userAnswer.equals(OUT)) {
                break;
            }
            if (userAnswer.equals(STOP)) {
                giveAnswers = false;
            }
            if (userAnswer.equals(CONTINUE)) {
                giveAnswers = true;
            }
            if (giveAnswers) {
                String randomAnswer = listOfBotAnswers[(int) (Math.random() * listOfBotAnswers.length)];
                System.out.println(randomAnswer);
                chatRecord.append(randomAnswer).append(System.lineSeparator());
            }
        }
        try (BufferedWriter br = new BufferedWriter(new FileWriter(path, StandardCharsets.UTF_8))) {
            br.write(chatRecord.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        ConsoleChat cc = new ConsoleChat("./chapter_002-Блок 2. Система ввода вывода/data/chatRecord.txt",
                "./chapter_002-Блок 2. Система ввода вывода/data/botAnswers.txt");
        cc.run();
    }
}