package ru.job4j.ood.lsp.parking;

public class PassengerCarParking implements Parking {

    public PassengerCarParking(int ParkingLots) {

    }

    @Override
    public boolean park(Car car) {
        return false;
    }
}
