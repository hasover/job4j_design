package ru.job4j.ood.isp;

import java.util.ArrayList;
import java.util.List;

public class Menu implements SimpleMenu<MenuItem>, Printable {
    private List<MenuItem> menuItems = new ArrayList<>();

    @Override
    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
    }

    @Override
    public String toStringFormat() {
        StringBuilder builder = new StringBuilder();
        for(MenuItem item : menuItems) {
            builder.append(printMenu(item, 0));
        }
        return builder.toString();
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
        MenuItem menuItem1 = new MenuItem("Task 1.");
        menu.addMenuItem(menuItem1);

        MenuItem menuItem1_1 = new MenuItem("Task 1.1");
        menuItem1.addSubItem(menuItem1_1);

        MenuItem menuItem1_1_1 = new MenuItem("Task 1.1.1");
        menuItem1_1.addSubItem(menuItem1_1_1);

        MenuItem menuItem1_1_2 = new MenuItem("Task 1.1.2");
        menuItem1_1.addSubItem(menuItem1_1_2);

        MenuItem menuItem1_1_3 = new MenuItem("Task 1.1.3");
        menuItem1_1.addSubItem(menuItem1_1_3);

        MenuItem menuItem1_2 = new MenuItem("Task 1.2");
        menuItem1.addSubItem(menuItem1_2);

        MenuItem menuItem2 = new MenuItem("Task 2.");
        menu.addMenuItem(menuItem2);

        System.out.println(menu.toStringFormat());
    }
}
