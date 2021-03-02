package ru.job4j.ood.isp;

//не все птицы умеют и летать, и плавать
public interface Bird {
    void fly();
    void swim();
}

class Duck implements Bird {

    @Override
    public void fly() {
        System.out.println("Duck flying");
    }

    @Override
    public void swim() {
        System.out.println("duck swimming");
    }
}

class Pigeon implements Bird {

    @Override
    public void fly() {
        System.out.println("Pigeon flying");
    }

    @Override
    public void swim() {
        throw new UnsupportedOperationException("Pigeons can't swim");
    }
}
