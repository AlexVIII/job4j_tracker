package ru.job4j.early;

import org.junit.Test;

public class PasswordValidatorTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenPasswordNotHaveDigital() {
        PasswordValidator.validate("hJ*ggggI");
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPasswordNotHaveUpperCharacter() {
       PasswordValidator.validate("h1*ggggI");
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPasswordNotHaveLowerCharacter() {
        PasswordValidator.validate("1J*GGGGI");
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPasswordIsShort() {
        PasswordValidator.validate("1hJ*I");
        }

    @Test(expected = IllegalArgumentException.class)
    public void whenPasswordIsLong() {
       PasswordValidator.validate("1hhhhhhhhhhhhhhhhhhhhhhhhhhhhhJ*I");
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPasswordHaveUsed() {
       PasswordValidator.validate("admin1J*GGhGI");
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenEmpty() {
       PasswordValidator.validate("");
    }
}