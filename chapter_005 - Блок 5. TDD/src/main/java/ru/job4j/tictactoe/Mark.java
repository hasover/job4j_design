package ru.job4j.tictactoe;

public enum Mark {
    X("X"),O("0"),EMPTY("_");
    private final String str;
    Mark(String str) {
        this.str = str;
    }
    @Override
    public String toString() {
        return str;
    }
}
