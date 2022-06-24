package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void run() {
        System.out.println("Добрый день. Вас приветствует такси 'Вояж'");
        System.out.println("Стоимость поездки 20 руб.");
    }

    @Override
    public void passengers(int count) {
        if (count > 10) {
            System.out.println("Маршрутка заполнена, начинаем движение");
        } else {
            System.out.println("Ждем пассажиров");
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
