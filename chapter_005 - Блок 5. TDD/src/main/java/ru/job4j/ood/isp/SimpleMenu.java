package ru.job4j.ood.isp;

public interface SimpleMenu<T> {
    void addMenuItem(T item);
    void addSubMenuItem(String parent, T item);
}
