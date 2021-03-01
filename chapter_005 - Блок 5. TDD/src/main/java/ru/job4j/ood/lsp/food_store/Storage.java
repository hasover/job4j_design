package ru.job4j.ood.lsp.food_store;

public class Storage {
    private Store store;

    public void setStorage(Store store) {
        this.store = store;

    }
    public boolean storeItem(Food item) {
        if (store.accept(item)) {
            store.store(item);
            return true;
        }
        return false;
    }
}
