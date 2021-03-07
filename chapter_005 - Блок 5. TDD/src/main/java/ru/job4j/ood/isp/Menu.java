package ru.job4j.ood.isp;

import java.util.*;

public class Menu implements SimpleMenu<MenuItem>, Printable {
    private MenuItem root = new MenuItem("Root");

    @Override
    public void addMenuItem(MenuItem item) {
        root.addSubItem(item);
    }

    @Override
    public void addSubMenuItem(String parent, MenuItem item) {
        MenuItem parentItem = searchMenuItem(root, parent);
        if (parentItem != null) {
            parentItem.addSubItem(item);
        }
    }

    @Override
    public String toStringFormat() {
        StringBuilder builder = new StringBuilder();
        for(MenuItem item : root.getSubItems()) {
            builder.append(printMenu(item, 0));
        }
        return builder.toString();
    }

    private MenuItem searchMenuItem(MenuItem menuItem, String name) {
        Queue<MenuItem> menuItemQueue = new LinkedList<>();
        menuItemQueue.add(menuItem);

        while (!menuItemQueue.isEmpty()) {
            MenuItem item = menuItemQueue.poll();
            if (item.getItemName().equals(name)) {
                return item;
            } else if (item.getSubItems().size() != 0) {
                menuItemQueue.addAll(item.getSubItems());
            }
        }
        return null;
    }

    private String printMenu(MenuItem item, int depth) {
        StringBuilder builder = new StringBuilder();
        String tab = "---".repeat(depth);
        builder.append(tab + item.getItemName()).append(System.lineSeparator());

        if (item.getSubItems().size() > 0) {
            for (MenuItem menuItem : item.getSubItems()) {
                builder.append(printMenu(menuItem, depth + 1));
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Menu menu = new Menu();

        menu.addMenuItem(new MenuItem("Task 1."));
        menu.addMenuItem(new MenuItem("Task 2."));

        menu.addSubMenuItem("Task 1.", new MenuItem("Task 1.1"));

        menu.addSubMenuItem("Task 1.1", new MenuItem("Task 1.1.1") );

        menu.addSubMenuItem("Task 1.1", new MenuItem("Task 1.1.2") );

        menu.addSubMenuItem("Task 1.1", new MenuItem("Task 1.1.3") );

        menu.addSubMenuItem("Task 1.", new MenuItem("Task 1.2"));

        System.out.println(menu.toStringFormat());
    }
}
