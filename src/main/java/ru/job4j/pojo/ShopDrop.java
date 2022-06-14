package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] delete(Product[] products, int index) {
        int i = index;
        while (i < products.length - 1) {
           products[i] = products[i + 1];
            i++;
        }
        products[products.length - 1] = null;
        return products;
    }
}