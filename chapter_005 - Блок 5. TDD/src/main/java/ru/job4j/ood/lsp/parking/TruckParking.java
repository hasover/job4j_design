package ru.job4j.ood.lsp.parking;

public class TruckParking implements Parking {

    public TruckParking(int parkingLots) {

    }

    @Override
    public boolean park(Car car) {
        return false;
    }
}
