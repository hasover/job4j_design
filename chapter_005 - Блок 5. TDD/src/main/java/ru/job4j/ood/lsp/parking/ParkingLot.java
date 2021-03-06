package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ParkingLot implements Parking {

    Set<Car> carsSet = new HashSet<>();
    List<Parking> parkingList = new ArrayList<>();

    public ParkingLot(int passengers, int trucks) {
        parkingList.add(new TruckParking(trucks));
        parkingList.add(new PassengerCarParking(passengers));
    }

    @Override
    public boolean park(Car car) {
        if (carsSet.contains(car)) {
            return false;
        }
        for (Parking parking : parkingList) {
            if (parking.park(car)) {
                carsSet.add(car);
                return true;
            }
        }
        return false;
    }
}