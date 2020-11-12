package ru.job4j.io.fileSearch;

import java.io.File;
import java.util.regex.Pattern;

public class Arguments {
    private String directory;
    private String outFile;
    private Pattern pattern;

    public Arguments (String[] args) {
        if (args.length != 7) {
            throw new IllegalArgumentException("7 Arguments required :" +
                    " -d directoryName -n filePattern -key(-m or -r or -f) -o outPutFile");
        }
        directory = args[1];
        outFile = args[6];
        initPattern(args[4], args[3]);
    }
    private void initPattern(String key, String fileMask) {
        if (key.equals("-r") || key.equals("-f")) {
            pattern = Pattern.compile(fileMask);
        } else if (key.equals("-m")) {
            String regex = "";
            for (int i = 0; i < fileMask.length(); i++) {
                char symbol = fileMask.charAt(i);
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
            pattern = Pattern.compile(regex);
        }
        else {
            throw new IllegalArgumentException(" Use -r, -f or -m");
        }
    }

    public String getDirectory() {
        return directory;
    }

    public String getOutFile() {
        return outFile;
    }

    public Pattern getPattern() {
        return pattern;
    }
}
