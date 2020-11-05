package ru.job4j.io;

public class ArgZip {

    private final String[] args;

    public ArgZip(String[] args) {
        this.args = args;
    }

    public boolean valid() {
        if (args.length != 6) {
            throw new IllegalArgumentException("6 params required: -d directory -e filetype -o zipfile");
        }
        return true;
    }

    public String directory() {
        return args[1];
    }

    public String exclude() {
        return args[3].split("\\.")[1];
    }

    public String output() {
        return args[5];
    }
}