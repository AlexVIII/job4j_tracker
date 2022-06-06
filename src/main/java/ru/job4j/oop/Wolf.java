package ru.job4j.oop;

public class Wolf {
    public void tryEat(Ball ball) {
        System.out.print("Я от волка ");
        ball.tryRun(false);
    }
}
