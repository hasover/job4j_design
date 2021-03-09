package ru.job4j.ood.lsp.food_store;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class Shop implements Store, Iterable<Food> {

    private List<Food> list = new ArrayList<>();
    private Predicate<Food> predicate;

    public Shop(Predicate<Food> predicate) {
        this.predicate = predicate;
    }

    @Override
    public boolean accept(Food item) {
        return predicate.test(item);
    }

    @Override
    public List<Food> clear() {
        List<Food> foodList = new ArrayList<>();
        for(Food item: list) {
            if (item.timeToExpire() <= 0.25) {
                item.setDiscount(0);
            }
            foodList.add(item);
        }
        list.clear();
        return foodList;
    }

    @Override
    public void store(Food item) {
        if (item.timeToExpire() <= 0.25) {
            item.setDiscount(0.3);
        }

        list.add(item);
    }


    @Override
    public Iterator<Food> iterator() {
        return list.iterator();
    }
}
