package ru.job4j.encapsulation;

public class Config {
    public String name;//String name
    private int position;//protected int position;
    public String[] properties;

    public Config(String name) {
        this.name = name;
    }

    public void print() { //void print()
        System.out.println(position);
    }

    private String getProperty(String key) { //protected String getProperty(String key)
        return search(key);
    }

    private String search(String key) {
        return key;
    }
}