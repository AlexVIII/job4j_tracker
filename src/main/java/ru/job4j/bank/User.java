package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает данные пользователя
 * @author Aleksandr Vasyanin
 * @version 1.0
 */
public class User {

    /**
     * Данные паспорта пользователя
     */
    private String passport;

    /**
     * Имя пользователя
     */
    private String user;

    /**
     * Конструктор класс
     * @param passport данные паспорта
     * @param user имя пользователя
     */
    public User(String passport, String user) {
        this.passport = passport;
        this.user = user;
    }

    /**
     * Геттер для номера паспорта
     * @return возвращает номер паспорта
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Сеттер для номера паспорт
     * @param passport номер паспорта
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Геттер имени пользователя
     * @return - возвращает имя пользователя
     */
    public String getUser() {
        return user;
    }

    /**
     * Сеттер имени пользователя
     * @param user -  имя пользователя
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Переопределение метода equals
     * @param o - имя пользователя
     * @return Метод возвращет true, если номера паспорта совпадают
     * если разные - false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Переопределение метода hashCode.
     * @return метод возвращает hashCode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
