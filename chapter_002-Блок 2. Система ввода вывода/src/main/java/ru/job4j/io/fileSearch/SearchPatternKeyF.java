package ru.job4j.io.fileSearch;

import java.io.File;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class SearchPatternKeyF implements Predicate<File> {
    private String regex;

    public SearchPatternKeyF(String filePattern) {
        this.regex = getRegex(filePattern);
    }
    private String getRegex(String filePattern) {
        String[] withoutDots = filePattern.split("\\.");
        String regex = withoutDots[0];
        for (int i = 1; i < withoutDots.length; i++) {
            regex += "\\." + withoutDots[i];
        }
        return regex;
    }
    @Override
    public boolean test(File fileToTest) {
        return Pattern.compile(regex).matcher(fileToTest.getName()).matches();
    }
}