package ru.job4j.io.fileSearch;

public class Arguments {
    private String directory;
    private String outFile;
    private String key;
    private String filePattern;

    public Arguments (String[] args) {
        if (args.length != 7) {
            throw new IllegalArgumentException("7 Arguments required :" +
                    " -d directoryName -n filePattern -key(-m or -r or -f) -o outPutFile");
        }
        if (!args[4].equals("-m") && !args[4].equals("-r") && !args[4].equals("-f")) {
            throw new IllegalArgumentException("Possible key values: -m -r -f");
        }
        directory = args[1];
        filePattern = args[3];
        key = args[4];
        outFile = args[6];
    }

    public String getDirectory() {
        return directory;
    }

    public String getOutFile() {
        return outFile;
    }

    public String getKey() {
        return key;
    }

    public String getFilePattern() {
        return filePattern;
    }
}
