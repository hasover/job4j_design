package ru.job4j.ood.ocp;

/*
  Нарушение OCP. При добавлении нового формата придется писать еще один метод.
  лучше будет playSong(MusicFormat song), где MusicFormat - абстр. класс для MP3, avi и т.д
 */
public class MusicPlayer {

    private static class MP3 {

    }

    public void playSong(MP3 song) {

    }

}
