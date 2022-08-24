package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавление пользователя, если он отсутствует
     * @param user
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Поиск user по паспорту
     * Если не найден, добавляется account с номером паспорта
     * @param passport
     * @param account
     */
    public void addAccount(String passport, Account account) {
        User temp = findByPassport(passport);
        if (temp != null && !users.get(temp).contains(account)) {
            users.get(temp).add(account);
        }
    }

    /**
     * Поиск user по паспорту
     * @param passport
     * @return user, если найден, иначе null
     */
    public User findByPassport(String passport) {
        for (User temp : users.keySet()) {
            if (temp.getPassport().equals(passport)) {
                return temp;
            }
        }
        return null;
    }

    /**
     * Поиск user по паспорту
     * Если найденный user имеет  входящих реквизитов, выводится account
     * @param passport
     * @param requisite
     * @return
     */
    public Account findByRequisite(String passport, String requisite) {
        User temp = findByPassport(passport);
        if (temp != null) {
            for (Account accounts : users.get(temp)) {
                if (accounts.getRequisite().equals(requisite)) {
                    return accounts;
                }
            }
        }
        return null;
    }

    /**
     * Проверка возможности осуществить перевод
     * Если баланс исходящего счета > входящего, перевод осуществим
     * @param srcPassport
     * @param srcRequisite
     * @param destPassport
     * @param destRequisite
     * @param amount
     * @return true/false
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
     * Получение в коллекцию List данных user
     * @param user
     * @return
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}


