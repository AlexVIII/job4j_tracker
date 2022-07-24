package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;
  //  private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
 //       items.set(size++, item);
        items.add(item);
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        for (Item it : items) {
            if (it.getName().equals(key)) {
                rsl.add(it);

            }
        }
        return rsl;
    }

    public List<Item> findAll() {
        return List.copyOf(items);
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl =  index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index =  indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);
            items.set(index, item);
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
          /*  items.set(index, null);
            System.arraycopy(items, index + 1, items, index, size - index - 1);
            items.set(size - 1, null);
            size--;*/
            items.remove(index);
        }
        return rsl;
    }
}
