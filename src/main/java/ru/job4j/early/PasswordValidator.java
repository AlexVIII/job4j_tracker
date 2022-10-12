package ru.job4j.early;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Character.*;

public class PasswordValidator {

    public static String validate(String password) {
        List<String> word = new ArrayList<>(Arrays.asList("qwerty", "12345", "password", "admin", "user"));
        if (password.isEmpty()) {
            throw new IllegalArgumentException("Password is empty");
        }
        for (String s : word) {
            if (password.contains(s)) {
                throw new IllegalArgumentException("Password is used in base");
            }
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password is short or long");
        }
        char[] pass = password.toCharArray();
        for (char p : pass) {
            if (!(isDigit(p) || isLetter(p) || isUpperCase(p) || isLowerCase(p))) {
                throw new IllegalArgumentException("the password must contain at least one digit,"
                        + "a lowercase or uppercase character, and special characters.");
            }
        }
        return password;
    }
}