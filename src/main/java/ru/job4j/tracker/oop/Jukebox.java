package ru.job4j.tracker.oop;

public class Jukebox {
    public String music(int position) {
        String song;
        if (position == 1) {
            song = "Пусть  бегут неуклюже";
        } else if (position == 2) {
            song = "Медведица";
        } else {
            song = "Всем спасибо.Концерт закончен";
        }
        return song;
    }

    public static void main(String[] args) {
        Jukebox vasya = new Jukebox();
        Jukebox max =  new Jukebox();
        System.out.println("Сейчас выступит Василий и споет песню " + vasya.music(1));
        System.out.println("Поприветствуем");
        System.out.println("Браво. Еще одна песня. Исполнит Макс - " + max.music(2));
        System.out.println(max.music(0));
    }
}