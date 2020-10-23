package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {

    private Object[] container;
    private int elements = 0;
    private int modCount = 0;

    public SimpleArray() {
        container = new Object[1];
    }

    public SimpleArray(int capacity) {
        container = new Object[capacity];
    }

    public T get(int index) {
        return (T) container[Objects.checkIndex(index, elements)];
    }

    public void add(T model) {
        modCount++;
        if (elements == container.length) {
            Object[] newContainer = new Object[container.length * 2];
            System.arraycopy(container, 0, newContainer, 0, container.length);
            container = newContainer;
        }
        container[elements++] = model;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int expectedModCount = modCount;
            private int iterationIndex = 0;

            @Override
            public boolean hasNext() {
                return iterationIndex < elements;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return (T) container[iterationIndex++];
            }
        };
    }
}
