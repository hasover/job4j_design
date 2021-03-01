package ru.job4j.ood.lsp.food_store;

public interface Store {
    void store(Food item);
    boolean accept(Food item);
}
