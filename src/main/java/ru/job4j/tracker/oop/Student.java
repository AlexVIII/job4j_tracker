package ru.job4j.tracker.oop;

public class Student {
    public static void main(String[] args) {
        Student petya = new Student();

        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 2; j++) {
                petya.playForward();
                petya.songForward();
            }
            petya.playBack();
            petya.songBack();
        }
    }

    public void songForward() {
        System.out.println("I believe I can fly");
    }

    public void songBack() {
        System.out.println("Fly can I believe I");
    }

    public void playForward() {
        System.out.println("Do Re Mi Fa Sol Lya Ci Do");
    }

    public void playBack() {
        System.out.println("Do Ci Lya Sol Fa Mi Re Do");
    }
}