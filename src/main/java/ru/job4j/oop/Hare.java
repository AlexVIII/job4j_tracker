package ru.job4j.oop;

public class Hare {

    public void tryEat(Ball ball) {
        System.out.print("Я от медведя ");
        ball.tryRun(false);
    }
}
