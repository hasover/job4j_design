package ru.job4j.collection;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Iterable<T> {
    private SimpleArray<T> container = new SimpleArray();

    public boolean add(T item) {
        if (contains(item)) {
            return false;
        }
        container.add(item);
        return true;
    }

    public boolean contains (T item) {
        for(T element : container) {
            if (Objects.equals(element, item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return container.iterator();
    }
}
