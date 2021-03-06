package ru.job4j.ood.lsp.parking;

public class PassengerCarParking implements Parking {

    private int parkingPlaces;
    private int placesTaken;

    public PassengerCarParking(int parkingLots) {
        this.parkingPlaces = parkingLots;
    }

    @Override
    public boolean park(Car car) {
        int carSize = car.size();
        if (placesTaken + carSize <= parkingPlaces) {
            placesTaken += carSize;
            return true;
        }
        return false;
    }
}
