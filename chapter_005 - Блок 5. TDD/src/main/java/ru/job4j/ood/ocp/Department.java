package ru.job4j.ood.ocp;

import java.util.List;
import java.util.function.Predicate;
/*
Вместо создания разных функция поиска, следует использовать одну searchBy и передавать туда предикат

 */
public class Department {

    public List searchByCriteria1() {
        return null;
    }

    public List searchByCriteria2() {
        return null;
    }

    public List searchBy(Predicate predicate) {
        return null;
    }
}
