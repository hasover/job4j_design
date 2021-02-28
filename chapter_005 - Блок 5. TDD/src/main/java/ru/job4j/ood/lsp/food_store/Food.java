package ru.job4j.ood.lsp.food_store;


import java.util.Calendar;

public class Food {

    private String name;
    private Calendar createDate;
    private Calendar expireDate;
    private double price;
    private double discount;

    public Food(String name, Calendar createDate, Calendar expireDate, double price, float discount) {
        this.name = name;
        this.createDate = createDate;
        this.expireDate = expireDate;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Calendar createDate) {
        this.createDate = createDate;
    }

    public Calendar getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Calendar expireDate) {
        this.expireDate = expireDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", createDate=" + createDate +
                ", expireDate=" + expireDate +
                ", price=" + price +
                ", discount=" + discount +
                '}';
    }
}
