package ru.job4j.ood.srp;

import java.util.List;
/*
Методом saveItemsData()-сохранение данных - должен заниматься другой класс.
Нарушение SRP
 */
public class Store1 {

    public void addItem() {

    }

    public void removeItem() {

    }

    public List allItems() {
        return null;
    }

    public void saveItemsData() {

    }

}
