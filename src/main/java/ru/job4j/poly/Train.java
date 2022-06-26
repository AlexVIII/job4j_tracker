package ru.job4j.poly;

public class Train implements Vechile {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " двигается по рельсам");
    }
}
