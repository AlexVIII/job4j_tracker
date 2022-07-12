package ru.job4j.ooa;

public class Airbus extends Aircraft {
    private static final int COUNT_ENGINE = 2;

    private String name;

    public Airbus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printModel() {
        System.out.print("Модель самолета: " + name);
    }

    public void printCountEngine() {
        System.out.println(name.equals("A320") ? ", Количество двигателей равно: " + COUNT_ENGINE
                : ", Количество двигателей равно: 4");
    }

    @Override
    public String toString() {
        return "Airbus{"
                + "name='" + name + '\''
                + '}';
    }
}