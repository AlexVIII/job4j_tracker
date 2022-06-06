package ru.job4j.oop;

public class Cat {
    public String name;
    public String food;

    public static void main(String[] args) {
        Cat gav = new Cat();
        gav.giveNick("Черныш");
        gav.eat("курицу");
        gav.show();
    }

    public void giveNick(String nick) {
        this.name = nick;
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public void show() {
        System.out.println(this.name + " обожает " + this.food);
    }
}