package ru.job4j.ood.isp;

import java.util.HashMap;
import java.util.Map;
public class Menu implements SimpleMenu<MenuItem>, Printable {
    private MenuItem root = new MenuItem("Root");
    private Map<String, MenuItem> menuItemMap = new HashMap<>();

    @Override
    public void addMenuItem(MenuItem item) {
        root.addSubItem(item);
        menuItemMap.put(item.getItemName(), item);
    }

    @Override
    public void addSubMenuItem(String parent, MenuItem item) {
        MenuItem parentItem = menuItemMap.get(parent);
        if (parentItem != null) {
            parentItem.addSubItem(item);
            menuItemMap.put(item.getItemName(), item);
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
