package ru.job4j.ood.lsp.food_store;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Shop implements Store, Iterable<Food> {

    private List<Food> list = new ArrayList<>();

    @Override
    public void store(Food item) {
        list.add(item);
    }


    @Override
    public Iterator<Food> iterator() {
        return list.iterator();
    }
}
