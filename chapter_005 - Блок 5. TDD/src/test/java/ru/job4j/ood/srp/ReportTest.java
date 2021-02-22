package ru.job4j.ood.srp;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ReportTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenHtmlGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report report = new ReportHtml(store);
        StringBuilder expect = new StringBuilder()
                .append("<worker>").append(System.lineSeparator())
                .append("<name>").append(worker.getName()).append("/name").append(System.lineSeparator())
                .append("<hired>").append(worker.getHired()).append("/hired").append(System.lineSeparator())
                .append("<fired>").append(worker.getFired()).append("/fired").append(System.lineSeparator())
                .append("<salary>").append(worker.getSalary()).append("/salary").append(System.lineSeparator())
                .append("</worker>").append(System.lineSeparator());

        assertThat(report.generate(employee -> true), is(expect.toString()));
    }

    @Test
    public void whenNewSalaryFormat() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report report = new ReportFormattedSalary(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(" roubles").append(";")
                .append(System.lineSeparator());
        assertThat(report.generate(employee -> true), is(expect.toString()));
    }

    @Test
    public void whenOnlySalary() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Alex", now, now, 100);
        Employee worker2 = new Employee("Bob", now, now, 100);
        Employee worker3 = new Employee("Ivan", now, now, 100);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        Report report = new ReportSalaryOnly(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;").append(System.lineSeparator())
                .append(worker3.getName()).append(";").append(worker3.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(";").append(worker2.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(";").append(worker1.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(report.generate(x->true), is(expect.toString()));
    }
}