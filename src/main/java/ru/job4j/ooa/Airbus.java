package ru.job4j.ooa;

public class Airbus extends Aircraft {
    private static final int COUNT_ENGINE = 2;
    public int engine = 4;

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
        String str = ", Количество двигателей равно: ";
        System.out.println("A320".equals(name) ? str + COUNT_ENGINE
                : str + engine);
    }

    @Override
    public String toString() {
        return "Airbus{"
                + "name='" + name + '\''
                + '}';
    }
}