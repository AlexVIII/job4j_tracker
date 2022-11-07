package ru.job4j.early;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Character.*;

public class PasswordValidator {

    public static String validate(String password) {
        List<String> word = new ArrayList<>(Arrays.asList("qwerty", "12345", "password", "admin", "user"));
        String specialSymbol = "!@#$%^&*(){}][|?/><";
        int specialCount = 0;
        int symbolDigital = 0;
        int symbolLetter = 0;
        int symbolUpper = 0;
        int symbolLower = 0;
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

            if (!isLetterOrDigit(p)) {
                specialCount++;
            }

            if (isLetter(p)) {
                symbolLetter++;
            }
            if (isDigit(p)) {
                symbolDigital++;
            }
            if (isUpperCase(p)) {
                symbolUpper++;
            }
            if (isLowerCase(p)) {
                symbolLower++;
            }
        }

        if ((symbolLetter == 0) || (symbolDigital == 0) || (symbolLower == 0) || (symbolUpper == 0) || (specialCount == 0)) {

            throw new IllegalArgumentException("the password must contain at least one digit,"
                    + "a lowercase or uppercase character, and special characters.");
        }
            return password;
    }

}