package ru.job4j.oop;

public class Ball {
    public void tryRun(boolean condition) {
        if (condition) {
            System.out.println("съела");
        } else {
            System.out.println("ушел,");
        }
    }
}