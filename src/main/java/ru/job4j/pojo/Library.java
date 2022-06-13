package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book first = new Book("Clean code", 122);
        Book second = new Book("Empty", 0);
        Book third = new Book("Empty", 0);
        Book forth = new Book("Empty", 0);
        Book[] kniga = new Book[4];
        kniga[0] = first;
        kniga[1] = second;
        kniga[2] = third;
        kniga[3] = forth;

        for (int index = 0; index < kniga.length; index++) {
            Book bk = kniga[index];
            System.out.println(bk.getName() + ", стр." + bk.getCount());
        }

        Book temp = kniga[0];
        kniga[0] = kniga[3];
        kniga[3] = temp;
        System.out.println("______Change list_________");

        for (int index = 0; index < kniga.length; index++) {
            Book bk = kniga[index];
            System.out.println(bk.getName() + ", стр." + bk.getCount());
        }

    }
}

