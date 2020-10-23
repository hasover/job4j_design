package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        T data = head.value;
        head = head.next;
        return data;
    }

    public T deleteLast() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        if (head.next == null) {
            return deleteFirst();
        }
        Node<T> tail = head;
        Node<T> beforeTail = tail;
        while (tail.next != null) {
            beforeTail = tail;
            tail = tail.next;
        }
        T data = tail.value;
        beforeTail.next = null;
        return data;
    }

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}