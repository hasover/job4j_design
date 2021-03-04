package ru.job4j.ood.isp;

import java.util.ArrayList;
import java.util.List;

public class MenuItem {
    private String itemName;
    private Action action;
    private List<MenuItem> subItems;

    public MenuItem(String itemName) {
        this.itemName = itemName;
        action = new NoAction();
        subItems = new ArrayList<>();
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    public void addSubItem(MenuItem item) {
        subItems.add(item);
    }

    public List<MenuItem> getSubItems() {
        return subItems;
    }
}
