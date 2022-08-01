package ru.job4j.bank;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BankServiceTest {

    @Test
    public void addUser() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        assertThat(bank.findByPassport("3434")).isEqualTo(user);

    }

    @Test
    public void whenEnterInvalidPassport() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5656", 150D));
        assertThat(bank.findByRequisite("34", "5656")).isNull();
    }

    @Test
    public void addAccount() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5656", 150D));
        assertThat(bank.findByRequisite("3434", "5656").getBalance()).isEqualTo(150D);
    }

    @Test
    public void transferMoneySourceNull() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5656", 150D));
        bank.addAccount(user.getPassport(), new Account("4825", 10D));
        bank.transferMoney(user.getPassport(), "565", user.getPassport(), "4825", 150D);
        assertThat(bank.findByRequisite(user.getPassport(), "5656").getBalance()).isEqualTo(150D);
    }

    @Test
    public void transferMoneyDontHaveEnoughMoney() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5656", 150D));
        bank.addAccount(user.getPassport(), new Account("4825", 10D));
        bank.transferMoney(user.getPassport(), "4825", user.getPassport(), "5656", 150D);
        assertThat(bank.findByRequisite(user.getPassport(), "5656").getBalance()).isEqualTo(150D);
    }

    @Test
    public void transferMoneyDestinationIsNull() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5656", 150D));
        bank.addAccount(user.getPassport(), new Account("4825", 10D));
        bank.transferMoney(user.getPassport(), "5656", user.getPassport(), "48251", 150D);
        assertThat(bank.findByRequisite(user.getPassport(), "5656").getBalance()).isEqualTo(150D);
    }
}
