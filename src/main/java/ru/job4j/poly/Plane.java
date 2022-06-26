package ru.job4j.poly;

public class Plane implements Vechile {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " летает в воздухе");
    }
}
