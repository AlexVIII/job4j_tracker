package ru.job4j.tracker.oop;

public class Rabbit {
    public void tryEat(Ball ball) {
        System.out.print("Я от зайца ");
        ball.tryRun(false);
    }
}