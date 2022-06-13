package ru.job4j.pojo;

import java.util.Date;

public class Student {
    private String nameSurname;
    private String group;
    private String code;
    private Date created;

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
//1. Создайте модель данных - Студент. ru.job4j.pojo.Student.
//
//2. В модели должны быть поля: ФИО, группа, дата поступления.
//
//3. Сгенерируйте аксессоры для этих полей.
//
//4. Создайте класс ru.job4j.pojo.College с методом main. В методе main создайте объект Student и заполните поля через set. Добавьте вывод на консоль объекта student через методы get.
//
//5. Залейте код в репозиторий.
//
//6. Добавьте ссылку на коммит и измените ответственного на Петра Арсентьева.