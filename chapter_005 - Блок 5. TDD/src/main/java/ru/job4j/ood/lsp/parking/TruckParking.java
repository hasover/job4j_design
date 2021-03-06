package ru.job4j.ood.lsp.parking;

public class TruckParking implements Parking {

    private int parkingPlaces;
    private int placesTaken;

    public TruckParking(int parkingLots) {
        this.parkingPlaces = parkingLots;
    }

    @Override
    public boolean park(Car car) {
        int carSize = car.size();
        if (carSize == 1 || placesTaken + carSize > parkingPlaces) {
            return false;
        }
        placesTaken += carSize;
        return true;
    }
}
