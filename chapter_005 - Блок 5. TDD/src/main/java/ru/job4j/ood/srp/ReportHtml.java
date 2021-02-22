package ru.job4j.ood.srp;

import java.util.function.Predicate;

public class ReportHtml implements Report {

    private Store store;

    public ReportHtml(Store store) {
        this.store = store;
    }
    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder builder = new StringBuilder();
        for(Employee em : store.findBy(filter)) {
            builder.append("<worker>").append(System.lineSeparator())
                    .append("<name>").append(em.getName()).append("/name").append(System.lineSeparator())
                    .append("<hired>").append(em.getHired()).append("/hired").append(System.lineSeparator())
                    .append("<fired>").append(em.getFired()).append("/fired").append(System.lineSeparator())
                    .append("<salary>").append(em.getSalary()).append("/salary").append(System.lineSeparator())
                    .append("</worker>").append(System.lineSeparator());
        }
        return builder.toString();
    }
}
