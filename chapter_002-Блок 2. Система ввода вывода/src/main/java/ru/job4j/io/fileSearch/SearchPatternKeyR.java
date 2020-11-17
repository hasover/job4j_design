package ru.job4j.io.fileSearch;

import java.io.File;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class SearchPatternKeyR implements Predicate<File> {
    private String regex;

    public SearchPatternKeyR(String regex) {
        this.regex = regex;
    }
    @Override
    public boolean test(File fileToTest) {
        return Pattern.compile(regex).matcher(fileToTest.getName()).matches();
    }
}

