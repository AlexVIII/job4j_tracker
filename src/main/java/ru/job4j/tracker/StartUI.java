package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item timeFormat = new Item();
        System.out.println(timeFormat.getTime().
                format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
        System.out.println(timeFormat);
    }
}
