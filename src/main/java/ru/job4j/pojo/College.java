package ru.job4j.pojo;

import java.util.Date;
import java.time.format.DateTimeFormatter;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setNameSurname("Иванов И.И.");
        student.setCode("1");
        student.setGroup("1А-2022");
        student.setCreated(new Date());

        System.out.println("|code|" + "     ФИО    |" + "Группа | " + "    Дата Поступления");
        System.out.println("| " + student.getCode() + "  | " + student.getNameSurname()  + "|"+ student.getGroup() + "|" + student.getCreated());
    }

}
//. Создайте класс ru.job4j.pojo.College с методом main. В методе main создайте объект
// Student и заполните поля через set. Добавьте вывод на консоль объекта student через методы get.