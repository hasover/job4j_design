package ru.job4j.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name=\"" + name + '\"' +
                ", age=" + age +
                '}';
    }
}

public class Shop {
    private boolean isOpen24;
    private int numOfWorkers;
    private String address;
    private Person owner;
    private String[] products;

    public Shop(boolean isOpen24, int numOfWorkers, String address, Person owner, String... products) {
        this.isOpen24 = isOpen24;
        this.numOfWorkers = numOfWorkers;
        this.address = address;
        this.owner = owner;
        this.products = products;
    }

    public boolean isOpen24() {
        return isOpen24;
    }

    public int getNumOfWorkers() {
        return numOfWorkers;
    }

    public String getAddress() {
        return address;
    }

    public Person getOwner() {
        return owner;
    }

    public String[] getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "isOpen24=" + isOpen24 +
                ", numOfWorkers=" + numOfWorkers +
                ", address=\"" + address + '\"' +
                ", owner=" + owner +
                ", products=" + Arrays.toString(products) +
                '}';
    }

    public static void main(String[] args) {
        Shop shop = new Shop(true, 5, "Address 1", new Person("Owner", 50), "bread", "Milk");
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(shop));
        final String shopJson = "{" +
                "\"isOpen24\":true," +
                "\"numOfWorkers\":5," +
                "\"address\":\"Address 1\"," +
                "\"owner\":{\"name\":\"Owner\",\"age\":50}," +
                "\"products\":[\"bread\",\"Milk\"]" +
                "}";
        final Shop shopMod = gson.fromJson(shopJson, Shop.class);
        System.out.println(shopMod);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("isOpen24", shop.isOpen24());
        jsonObject.put("numOfWorkers", shop.getNumOfWorkers());
        jsonObject.put("address", shop.getAddress());
        jsonObject.put("owner", new JSONObject("{\"name\":\"Owner\",\"age\":50}"));
        jsonObject.put("products", new JSONArray(List.of("bread", "Milk")));
        System.out.println(jsonObject.toString());

    }
}
