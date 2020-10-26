package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleHashMap<K,V> implements Iterable<K> {
    private final static double LOAD_FACTOR = 0.75;
    private Node<K,V>[] container = new Node[16];
    private int items;

    private class Node<K,V> {
        K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int hash(K key) {
        return (key.hashCode() ^ (key.hashCode() >>> 16)) & (container.length - 1);
    }

    private void grow() {
        if ((double)items / container.length < LOAD_FACTOR) {
            return;
        }
        Node<K, V>[] newContainer = new Node[container.length * 2];
        System.arraycopy(container, 0, newContainer, 0, container.length);
        container = newContainer;
    }

    public boolean insert(K key, V value) {
        int hash = hash(key);
        if (container[hash] != null) {
            return false;
        }
        container[hash] = new Node<>(key, value);
        items++;
        grow();
        return true;
    }

    public V get(K key) {
        int hash = hash(key);
        return container[hash] == null ? null : container[hash].value;
    }

    public boolean delete(K key) {
        int hash = hash(key);
        if (container[hash] == null) {
            return false;
        }
        container[hash] = null;
        items--;
        return true;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                while (index < container.length && container[index] == null) {
                    index++;
                }
                return index < container.length;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[index++].key;
            }
        };
    }
}
