package ru.job4j.ood.lsp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/*
Нарушение LSP : ослабление постусловия в классе CashBoxNoBonus
 */
public class ProductsList implements Iterable<Double>  {

    private Map<String, Double> map = new HashMap<>();

    public void add(String name, double price) {
        map.put(name, price);
    }

    @Override
    public Iterator<Double> iterator() {
        return map.values().iterator();
    }
}

class CashBox {
    protected double priceReduction = 0.1;

    public double total(ProductsList list) {
        double sum = 0;
        for( double d : list) {
            sum += d;
        }
        if (sum >= 2000) {
            sum *= priceReduction;
        }
        return sum;
    }
}

class CashBoxNoBonus extends CashBox {

    @Override
    public double total(ProductsList list) {
        double sum = 0;
        for( double d : list) {
            sum += d;
        }
        return sum;
    }
}
