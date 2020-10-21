package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> {
    private T[] data;
    private int index = -1;

    public SimpleArray(int size) {
        data = (T[]) new Object[size];
    }

    public void add(T item) {
        data[Objects.checkIndex(++index, data.length)] = item;
    }

    public void set(int index, T model) {
        data[Objects.checkIndex(index, this.index + 1)] = model;
    }

    public T get(int index) {
        return data[Objects.checkIndex(index, this.index + 1)];
    }
    public void remove(int index) {
        System.arraycopy(data,
                  index + 1,
                        data,
                        Objects.checkIndex(index, this.index + 1),
                  data.length - index - 1);
        this.index--;
    }
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int indexIterator = 0;
            @Override
            public boolean hasNext() {
                return indexIterator <= index;
            }

            @Override
            public T next() {
                if(!hasNext()) {
                    throw new NoSuchElementException();
                }
                return data[indexIterator++];
            }
        };
    }
}

