package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        int nextRow = 0;
        if (column == data[row].length) {
            nextRow = row + 1;
            while (nextRow < data.length && data[nextRow].length == 0) {
                nextRow++;
            }
        }
        return nextRow != data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int current = 0;
        if (column < data[row].length) {
            current = data[row][column];
            column++;
        } else {
            column = 0;
            row++;
            while (data[row].length == 0) {
                row++;
            }
            current = data[row][column];
            column++;
        }
        return current;
    }
}