package oop;

public class Jukebox {
    public void music(int position) {
        if (position == 1) {
            System.out.println("Сейчас выступит Василий и споет песню - Пусть  бегут неуклюже.");
        } else if (position == 2) {
            System.out.println("Браво. Еще одна песня - Медведица");
        } else {
            System.out.println("Всем спасибо.Концерт закончен");
        }
    }

    public static void main(String[] args) {
        Jukebox solo = new Jukebox();
        solo.music(1);
        System.out.println("Поприветствуем");
        solo.music(2);
        System.out.println("__________________");
        solo.music(0);
    }
}