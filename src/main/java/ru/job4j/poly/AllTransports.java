package ru.job4j.poly;

public class AllTransports {
    public static void main(String[] args) {
        Vechile plane = new Plane();
        Vechile buses = new Buses();
        Vechile train = new Train();

        Vechile[] all = new Vechile[]{buses, plane, train};
        for (Vechile a : all) {
            a.move();
        }
    }
}
