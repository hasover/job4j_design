package ru.job4j.ood.dip;

import java.util.HashSet;
import java.util.Set;

// Поле accounts не должно использовать только Set. Нужно выделить интефейс Store c методом add
// Различные реализации Store будут использовать разные объекты для хранения
class Account {}
public class BankService {
    private Set<Account> accounts = new HashSet<>();
    public void addNewAccount(Account account) {
        accounts.add(account);
    }
}

