package ru.job4j.io.fileSearch;

import java.io.File;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class SearchPatternKeyM implements Predicate<File> {
    private String regex;

    public SearchPatternKeyM(String filePattern) {
        this.regex = getRegex(filePattern);
    }

    private String getRegex(String filePattern) {
        String regex = "";
        for (int i = 0; i < filePattern.length(); i++) {
            char symbol = filePattern.charAt(i);
            if (symbol == '*') {
                regex += ".*";
            } else if (symbol == '?') {
                regex += ".";
            } else if (symbol == '.') {
                regex += "\\.";
            } else {
                regex += symbol;
            }
        }
        return regex;
    }
    @Override
    public boolean test(File fileToTest) {
        return Pattern.compile(regex).matcher(fileToTest.getName()).matches();
    }
}
