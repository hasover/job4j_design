package ru.job4j.serialization;

public class Cinema {
    private boolean is3D;
    private int numSeats;
    private String name;
    private Address address;
    private String[] films;

    public Cinema(boolean is3D, int numSeats, String name, Address address, String[] films) {
        this.is3D = is3D;
        this.numSeats = numSeats;
        this.name = name;
        this.address = address;
        this.films = films;
    }

    public boolean isIs3D() {
        return is3D;
    }

    public int getNumSeats() {
        return numSeats;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public String[] getFilms() {
        return films;
    }

    public static void main(String[] args) {
        Cinema cinema = new Cinema(true, 50, "Cinema1",
                new Address("Street1", 1), new String[]{"Film1", "Film2"});

    }
}
