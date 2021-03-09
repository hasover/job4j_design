package ru.job4j.ood.lsp.food_store;

import java.util.List;

public interface Store {
    void store(Food item);
    boolean accept(Food item);
    List<Food> clear();
}
