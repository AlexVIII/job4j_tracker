package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает различные операции, возможные провести со счетом пользователя
 * @author Aleksandr Vasyanin
 * @version 1.0
 */

public class BankService {
    /**
     * Хранение данных пользователя:
     * Счет, реквизиты счет, баланс
     * в коллекции HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавление пользователя, если он отсутствует
     * @param user пользователь
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Поиск user по паспорту
     * Если не найден, добавляется account с номером паспорта
     * @param passport реквизиты паспорта
     * @param account новый счет
     */
    public void addAccount(String passport, Account account) {
        User temp = findByPassport(passport);
        if (temp != null && !users.get(temp).contains(account)) {
            users.get(temp).add(account);
        }
    }

    /**
     * Поиск user по паспорту
     * @param passport номер паспорта пользователя
     * @return user, если найден, иначе null
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Поиск user по паспорту
     * Если найденный user имеет  входящих реквизитов, выводится account
     * @param passport номер паспорта пользователя
     * @param requisite реквизиты счета пользователя
     * @return возвращает счет пользователя, либо null(если не найден)
     */
    public Account findByRequisite(String passport, String requisite) {
        User temp = findByPassport(passport);
        if (temp != null) {
            return users.get(temp)
                    .stream()
                    .filter(s -> s.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
            }
        return null;
    }

    /**
     * Проверка возможности осуществить перевод
     * Если баланс исходящего счета > входящего, перевод осуществим
     * @param srcPassport номер паспорт пользователя, отпраляющего перевод
     * @param srcRequisite реквизиты счета пользователя, отпраляющего перевод
     * @param destPassport реквизиты паспорта пользователя, получающего перевод
     * @param destRequisite реквизиты счета пользователя, получающего перевод
     * @param amount денежная сумма
     * @return true/false если операция прошла успешна - true, иначе -  false
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite,
                                 double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && srcAccount.getBalance() >= amount && destAccount != null) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    /**
     * Получение в коллекцию List данных пользователя
     * @param user пользователь
     * @return получение данных пользователя
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}


