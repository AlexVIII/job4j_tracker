package ru.job4j.oop;

public class Error {
    private int status;
    private boolean active;
    private String message;

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public static void main(String[] args) {
        Error stroka1 = new Error(true, 1, "Hello");
        stroka1.printInfo();
    }

    public void printInfo() {
        System.out.println(active);
        System.out.println(status);
        System.out.println(message);
    }
}