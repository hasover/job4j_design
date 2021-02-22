package ru.job4j.ood.srp;

import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReportSalaryOnly implements Report{

    private Store store;

    public ReportSalaryOnly(Store store) {
        this.store = store;
    }
    @Override
    public String generate(Predicate<Employee> filter) {

        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;").append(System.lineSeparator());
        for(Employee em : store.findBy(filter).stream().
                sorted(Comparator.comparing(Employee::getName).reversed()).
                collect(Collectors.toList())) {

            text.append(em.getName()).append(";")
                    .append(em.getSalary()).append(";").append(System.lineSeparator());

        }
        return text.toString();
    }
}
