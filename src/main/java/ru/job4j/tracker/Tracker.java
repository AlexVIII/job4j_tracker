package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        int index = 0;
        while (index < items.length) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
            index++;
        }
        return rsl;
    }


    public Item[] findNyName(String key) {
        Item[] rsl = new Item[size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            Item item = items[i];
            if (key.equals(item.getName())) {
                rsl[count] = item;
                count++;
            }
        }
        return Arrays.copyOf(rsl, size);
    }

    public Item[] findAll() {
        Item[] rsl = new Item[size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            Item item = items[i];
            if (item.getName() != null) {
                rsl[count] = item;
                count++;
            }
        }
        return Arrays.copyOf(rsl, count);
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace1(int id, Item item) { //3.Входящие параметры - Имя класса Item,
        // которон надо поставить на место по ключу?
        /* Находим индекс */
        int index = indexOf(id); //1.Здесь по ключу находим расположение в массиве?
        String rsl = String.valueOf(findById(id)); //2.Здесь находим Имя по ключу?

        items[index].setName(rsl);
        return index = -1 ? items[index].getName() : null; //?
    }


}
