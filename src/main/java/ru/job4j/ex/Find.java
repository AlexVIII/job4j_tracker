package ru.job4j.ex;

public class Find {
    public static String get(String[] data, int index) {
        if (index >= data.length || index < 0) {
            throw   new IllegalArgumentException("Index out of bound of Array");
        }
        return data[index];
    }

    public static void main(String[] args) {
        String[] data = {"one", "two", "three"};
        String rsl = Find.get(data, -5);
        System.out.println(rsl);
    }
}