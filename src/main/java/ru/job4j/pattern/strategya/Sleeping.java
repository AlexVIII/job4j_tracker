package ru.job4j.pattern.strategya;

public class Sleeping implements Activity{
    @Override
    public void justDoIt() {
        System.out.println("Sleeping....");
    }
}
