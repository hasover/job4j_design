package ru.job4j.tictactoe;

public interface Grid {
    public boolean placeMark(Mark mark, int x, int y);

    Mark getMark(int x, int y);

    int getWidth();

    int getHeight();
}