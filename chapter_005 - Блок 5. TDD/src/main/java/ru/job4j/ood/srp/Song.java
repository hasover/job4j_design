package ru.job4j.ood.srp;
/*
  Класс помимо хранения информации о песне занимается ее воспроизведением.
  2 причины для изменения (нарушение SRP)
 */
public class Song {
    private String name;
    private String singer;

    public String getName() {
        return name;
    }

    public String getSinger() {
        return singer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public void play() {

    }
}
