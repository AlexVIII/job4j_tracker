package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public boolean run() {
        int ps = 11;
        if (passengers(ps)) {
            return run();
        }
        return false;
    }

    @Override
    public boolean passengers(int count) {
        if (count > 10) {
            System.out.println("Маршрутка заполнена, начинаем движение");
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int gasStation(int litres, int tank) {
        int price = 0;
        if (tank - litres == 0) {
            System.out.println("Бак заполнен");
            price = 50;
        }
        return price;
    }
}
