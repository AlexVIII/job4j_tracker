package ru.job4j.collection;

import java.util.HashSet;

public class UsageHashSet {
    public static void main(String[] args) {
        HashSet<String> autos = new HashSet<>();
        autos.add("Lada");
        autos.add("BMW");
        autos.add("Volvo");
        autos.add("Toyota");
        autos.add("Toyota");
        autos.add("Volvo");
        autos.add("Range Rover");
        autos.add("Lada");
        for (String marks : autos) {
            System.out.println(marks);
        }
    }
}