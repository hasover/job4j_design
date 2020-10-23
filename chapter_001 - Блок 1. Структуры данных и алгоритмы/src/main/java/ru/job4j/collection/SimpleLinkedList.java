package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<T> implements Iterable<T> {

    private class Node<T> {
        public T data;
        public Node<T> next;
        public Node<T> previous;

    }
    private Node<T> first;
    private Node<T> last;
    private int size;
    private int modCount;

    public void add (T item) {
        size++;
        modCount++;
        Node<T> node = new Node<>();
        node.data = item;
        node.next = null;
        if (first == null) {
            first = node;
            last = node;
            node.previous = null;
            return;
        }
        node.previous = last;
        last.next = node;
        last = node;
    }

    public T get (int index) {
        Objects.checkIndex(index, size);
        Node<T> nodeIndex = first;
        for (int i = 0; i < index; i++) {
            nodeIndex = nodeIndex.next;
        }
        return nodeIndex.data;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int expectedModCount = modCount;
            private int iterationIndex = 0;
            private Node<T> node = first;
            @Override
            public boolean hasNext() {
                return iterationIndex < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                T data = node.data;
                node = node.next;
                iterationIndex++;
                return data;
            }
        };
    }
}
