package ru.job4j.collection;

import java.util.*;

public class SimpleHashMap<K,V> implements Iterable<K> {
    private final static double LOAD_FACTOR = 0.75;
    private Node<K, V>[] container = new Node[16];
    private int items;
    private int modCount;

    private class Node<K, V> {
        K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int hash(K key, int buckets) {
        return (key.hashCode() ^ (key.hashCode() >>> 16)) & (buckets - 1);
    }

    private void grow() {
        if ((double) items / container.length < LOAD_FACTOR) {
            return;
        }
        Node<K, V>[] newContainer = new Node[container.length * 2];
        for (Node<K, V> kvNode : container) {
            if (kvNode != null) {
                int hash = hash(kvNode.key, newContainer.length);
                newContainer[hash] = kvNode;
            }
        }
        container = newContainer;
    }

    public boolean insert(K key, V value) {
        int hash = hash(key, container.length);
        if (container[hash] != null) {
            return false;
        }
        container[hash] = new Node<>(key, value);
        items++;
        modCount++;
        grow();
        return true;
    }

    public V get(K key) {
        int hash = hash(key, container.length);
        return (container[hash] == null ||
                !Objects.equals(container[hash].key, key)) ? null : container[hash].value;
    }

    public boolean delete(K key) {
        int hash = hash(key, container.length);
        if (container[hash] == null || !Objects.equals(container[hash].key, key)) {
            return false;
        }
        container[hash] = null;
        items--;
        modCount++;
        return true;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            private int index = 0;
            private final int mods = modCount;

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
                if (mods != modCount) {
                    throw new ConcurrentModificationException();
                }
                return container[index++].key;
            }
        };
    }
}