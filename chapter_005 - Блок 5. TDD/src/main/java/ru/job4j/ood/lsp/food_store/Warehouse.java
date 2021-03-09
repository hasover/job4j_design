package ru.job4j.ood.lsp.food_store;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class Warehouse implements Store, Iterable<Food> {
    private List<Food> list = new ArrayList<>();
    private Predicate<Food> predicate;

    public Warehouse(Predicate<Food> predicate) {
        this.predicate = predicate;
    }

    @Override
    public boolean accept(Food item) {
        return predicate.test(item);
    }

    @Override
    public List<Food> clear() {
        List<Food> foodList = new ArrayList<>();
        foodList.addAll(list);
        list.clear();
        return foodList;
    }

    @Override
    public void store(Food item) {
     list.add(item);
    }

    @Override
    public Iterator<Food> iterator() {
        return list.iterator();
    }
}
