package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {

        if (value.isEmpty()) {
            return null;
        }

        T maxItem = value.get(0);

        for(T item : value) {
            if (comparator.compare(item, maxItem) > 0) {
                maxItem = item;
            }
        }
        return maxItem;
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return max(value, comparator.reversed());
    }
}
