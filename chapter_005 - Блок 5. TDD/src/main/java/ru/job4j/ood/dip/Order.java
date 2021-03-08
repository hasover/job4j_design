package ru.job4j.ood.dip;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Order {

    private int id;

    private boolean isPaid;

    private Map<Integer, Product> products = new HashMap<>();

    public boolean add(Product product) {
        if (products.containsKey(product.getId())) {
            return false;
        }
        return products.put(product.getId(), product) != null;
    }

    public boolean remove(int id) {
        return products.remove(id) != null;
    }

    public void clear() {
        products.clear();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
