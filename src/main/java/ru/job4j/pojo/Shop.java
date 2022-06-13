package ru.job4j.pojo;

public class Shop {
    public static int indexOfNull(Product[] products) {
        int i = -1;
        for (int index = 0; index < products.length; index++) {
            Product prd = products[index];
            if (prd == null) {
                i = index;
                break;
            }
        }
        return i;
    }
}
