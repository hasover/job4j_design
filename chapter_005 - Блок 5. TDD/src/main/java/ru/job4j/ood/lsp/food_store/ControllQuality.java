package ru.job4j.ood.lsp.food_store;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class ControllQuality {

    private Storage storage;
    private Warehouse warehouse;
    private Shop shop;
    private Trash trash;

    public ControllQuality(Warehouse warehouse, Shop shop, Trash trash) {
        this.warehouse = warehouse;
        this.shop = shop;
        this.trash = trash;
        storage = new Storage();
    }

    public static double timeToExpire (Food item) {
       if (item.getExpireDate().before(Calendar.getInstance())) {
           return 0;
       }

       long lifeTime = item.getExpireDate().getTimeInMillis() - item.getCreateDate().getTimeInMillis();
       long timeLeft = item.getExpireDate().getTimeInMillis() - Calendar.getInstance().getTimeInMillis();

       return (double) timeLeft/lifeTime;
    }

    public void sortFood(List<Food> items) {
        for (Food item : items) {

           double percentage = timeToExpire(item);

           if (percentage == 0) {
               storage.setStorage(trash);
           } else if (percentage < 0.25) {
                    item.setDiscount(0.3);
                   storage.setStorage(shop);
               }
            else if (percentage >= 0.25 && percentage < 0.75) {
                storage.setStorage(shop);
           } else {
                storage.setStorage(warehouse);
           }
            storage.storeItem(item);
        }
    }

    public static void main(String[] args) {

        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        ControllQuality controllQuality = new ControllQuality(warehouse, shop, trash);

        List<Food> items = new ArrayList<>();
        items.add(new Food("milk", Calendar.getInstance(),
                new GregorianCalendar(2021, Calendar.MARCH, 1),56.78, 0));

        items.add(new Food("Bread", new GregorianCalendar(2021, Calendar.FEBRUARY, 20),
                new GregorianCalendar(2021, Calendar.MARCH, 4), 56.78, 0));

        items.add(new Food("Meat",Calendar.getInstance(),
                new GregorianCalendar(2021, Calendar.MARCH, 7), 56.78, 0));

        items.add(new Food("Cheese", Calendar.getInstance(),
                new GregorianCalendar(2021, Calendar.MARCH, 11), 56.78, 0));

        items.add(new Food("Cake", Calendar.getInstance(),
                new GregorianCalendar(2021, Calendar.MARCH, 30), 56.78, 0));

        items.add(new Food("Cornflakes", Calendar.getInstance(),
                new GregorianCalendar(2021, Calendar.APRIL, 20), 56.78, 0));

        items.add(new Food("Apples", Calendar.getInstance(),
                new GregorianCalendar(2021, Calendar.MARCH, 26), 56.78, 0));

        controllQuality.sortFood(items);


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
