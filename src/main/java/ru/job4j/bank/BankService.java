package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        User temp = findByPassport(passport);
        if (temp != null && !users.get(temp).contains(account)) {
            users.get(temp).add(account);
        }
    }

    public User findByPassport(String passport) {
        for (User temp : users.keySet()) {
            if (temp.getPassport().equals(passport)) {
                return temp;
            }
        }
        return null;
    }

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

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite,
                                 double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && srcAccount.getBalance() >= amount && destRequisite != null) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}


