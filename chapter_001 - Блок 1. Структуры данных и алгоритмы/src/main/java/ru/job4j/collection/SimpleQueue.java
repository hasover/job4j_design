package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    int inSize = 0;
    int outSize = 0;

    public T poll() {
        if (inSize == 0 && outSize == 0) {
            throw new NoSuchElementException();
        }
        int elements = inSize;
        while (elements > 0) {
            out.push(in.pop());
            elements--;
        }
        if (inSize == 0) {
            outSize--;
        } else {
            outSize = inSize - 1;
        }
        inSize = 0;
        return out.pop();
    }

    public void push(T value) {
        int elements = outSize;
        while (elements > 0) {
            in.push(out.pop());
            elements--;
        }
        in.push(value);
        if (outSize == 0) {
            inSize++;
        } else {
            inSize = outSize + 1;
        }
        outSize = 0;
    }
}