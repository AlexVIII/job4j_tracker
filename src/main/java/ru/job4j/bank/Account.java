package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает счет пользователя
 * @author Aleksandr Vasyanin
 * @version 1.0
 */

public class Account {

    /**
     * Реквизиты счета
     */
    private String requisite;

    /**
     * Баланс счета
     */
    private double balance;

    /**
     * Конструктор класса
     * @param requisite - реквизитьы счета
     * @param balance - балнс счета
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Геттер реквизитов счета
     * @return получение реквизитов счета
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Сеттер реквизитов счета
     * @param requisite - ввод реквизитов счета
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Геттер баланса
     * @return получение баланса
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Сеттер баланса счета
     * @param balance ввод баланса
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Переопределение метода equals
     * @param o - банковский счет пользователя
     * @return Метод возвращет true, если реквизиты совпадают
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
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * переопределение метода hashcode
     * @return возврашает метод hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
