package ru.job4j.pattern.decorator;

public class Task {
    public static void main(String[] args) {
        Developer developer = new SeniorJavaDeveloper(new JavaDeveloper());
        System.out.println(developer.makeJob());
    }
}
