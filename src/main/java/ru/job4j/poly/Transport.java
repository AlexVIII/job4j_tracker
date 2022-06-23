package ru.job4j.poly;

public interface Transport {
    boolean run();

    boolean passengers(int count);

    int gasStation(int litres, int tank);
}

