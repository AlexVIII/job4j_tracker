package ru.job4j.poly;

public class Buses implements Vechile {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " ездиет  по дороге");
    }
}
