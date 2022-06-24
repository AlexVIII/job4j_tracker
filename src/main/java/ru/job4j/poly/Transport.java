package ru.job4j.poly;

public interface Transport {
    void run();

    void passengers(int count);

    int gasStation(int litres, int tank);
}

