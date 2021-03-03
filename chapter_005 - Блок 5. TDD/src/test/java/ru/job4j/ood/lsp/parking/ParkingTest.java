package ru.job4j.ood.lsp.parking;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ParkingTest {

    @Test
    public void whenCanParkPassengerCarOnPassengerParking() {

        Parking parking = new PassengerCarParking(2);
        parking.park(new PassengerCar());
        assertThat(parking.park(new PassengerCar()), is(true));
    }

    @Test
    public void whenCannotParkTruckOnPassengerParking() {
        Parking parking = new PassengerCarParking(3);
        parking.park(new PassengerCar());
        assertThat(parking.park(new Truck(3)), is(false));
    }

    @Test
    public void whenCanParkTruckOnPassengerParking() {
        Parking parking = new PassengerCarParking(4);
        parking.park(new PassengerCar());
        assertThat(parking.park(new Truck(3)), is(true));
    }

    @Test
    public void whenParkSameCarTwice() {
        Parking parking = new PassengerCarParking(3);
        Car car = new PassengerCar();
        parking.park(car);
        assertThat(parking.park(car), is(false));
    }

    @Test
    public void whenCannotParkPassengerCarOnTruckParking() {
        Parking parking = new TruckParking(3);
        assertThat(parking.park(new PassengerCar()), is(false));
    }





}