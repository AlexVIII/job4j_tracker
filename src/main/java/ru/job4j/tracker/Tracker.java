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
        return Arrays.copyOf(items, size);
    }

    private int indexof(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl =  index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index =  indexof(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);
            items[index] = item;
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexof(id);
        boolean rsl = index != -1;
        if (rsl) {
            items[index] = null;
            System.arraycopy(items, index + 1, items, index, size - index - 1);
            items[size - 1] = null;
            size--;
        }
        return rsl;
    }
}
