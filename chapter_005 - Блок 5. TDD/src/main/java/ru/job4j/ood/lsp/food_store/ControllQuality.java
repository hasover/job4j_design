package ru.job4j.ood.lsp.food_store;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class ControllQuality {

    private Storage storage;
    List<Store> stores;

    public ControllQuality(List<Store> stores) {
        this.stores = stores;
        storage = new Storage();
    }

    public void sortFood(List<Food> items) {
        for (Food item : items) {
            sortFood(item);

        }
    }

    public void sortFood(Food item) {
        for (Store store : stores) {
            storage.setStorage(store);
            if (storage.storeItem(item)) {
                break;
            }
        }
    }

    public void resort() {
        List<Food> foodList = new ArrayList<>();
        for (Store store: stores) {
            foodList.addAll(store.clear());
        }
        sortFood(foodList);
    }

    public static void main (String[] args) {

        Warehouse warehouse = new Warehouse(x -> x.timeToExpire() >= 0.75);
        Shop shop = new Shop(x-> x.timeToExpire() >0 && x.timeToExpire() < 0.75);
        Trash trash = new Trash(x -> x.timeToExpire() == 0);

        List<Store> stores = List.of(warehouse, shop, trash);

        ControllQuality controllQuality = new ControllQuality(stores);

        List<Food> items = new ArrayList<>();
        items.add(new Food("milk", Calendar.getInstance(),
                new GregorianCalendar(2021, Calendar.MARCH, 1),56.78, 0));

        items.add(new Food("Bread", new GregorianCalendar(2021, Calendar.FEBRUARY, 20),
                new GregorianCalendar(2021, Calendar.MARCH, 4), 56.78, 0));

        items.add(new Food("Meat",new GregorianCalendar(2021, Calendar.FEBRUARY, 25),
                new GregorianCalendar(2021, Calendar.MARCH, 5), 56.78, 0));

        items.add(new Food("Cheese", Calendar.getInstance(),
                new GregorianCalendar(2021, Calendar.MARCH, 11), 56.78, 0));

        items.add(new Food("Cake", Calendar.getInstance(),
                new GregorianCalendar(2021, Calendar.MARCH, 30), 56.78, 0));

        items.add(new Food("Cornflakes", Calendar.getInstance(),
                new GregorianCalendar(2021, Calendar.APRIL, 20), 56.78, 0));

        items.add(new Food("Apples", Calendar.getInstance(),
                new GregorianCalendar(2021, Calendar.MARCH, 26), 56.78, 0));

        controllQuality.sortFood(items);
        controllQuality.resort();

        for (Food item : trash) {
            System.out.println(item);
        }
        System.out.println("---------");
        for (Food item : shop) {
            System.out.println(item);

        }
        System.out.println("---------");
        for (Food item : warehouse) {
            System.out.println(item);
        }

    }
}
