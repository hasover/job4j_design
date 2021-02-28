package ru.job4j.ood.lsp.food_store;

public class Storage {
    private Store store;

    public void setStorage(Store store) {
        this.store = store;

    }
    public void storeItem(Food item) {
        store.store(item);
    }
}
