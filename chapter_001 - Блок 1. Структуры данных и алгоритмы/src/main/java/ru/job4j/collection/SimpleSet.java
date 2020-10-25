package ru.job4j.collection;

import java.util.Iterator;

public class SimpleSet<T> implements Iterable<T> {
    private SimpleArray<T> container = new SimpleArray();
    private int size;

    public boolean add(T item) {
        int i;
        for (i = 0; i < size; i++) {
            if (container.get(i).equals(item)) {
                break;
            }
        }
        if (i == size) {
            container.add(item);
            size++;
            return true;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return container.iterator();
    }
}
