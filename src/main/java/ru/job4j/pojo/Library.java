package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book first = new Book("Clean code", 122);
        Book second = new Book("Empty", 0);
        Book third = new Book("Empty", 0);
        Book forth = new Book("Empty", 0);
        Book[] books = new Book[4];
        books[0] = first;
        books[1] = second;
        books[2] = third;
        books[3] = forth;

        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            System.out.println(bk.getName() + ", стр." + bk.getCount());
        }

        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        System.out.println("______Change list_________");
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            System.out.println(bk.getName() + ", стр." + bk.getCount());
        }
        System.out.println("______Not empty list_________");
        for (int i = 0; i < books.length; i++) {
            Book bk =  books[i];
            if ("Clean code".equals(bk.getName())) {
                System.out.println(bk.getName() + ", стр." + bk.getCount());
            }
        }
    }
}

