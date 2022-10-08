package ru.job4j.early;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PasswordValidatorTest {

    @Test
    void whenPasswordNotHaveDigital() {
        String result = PasswordValidator.validate("hJ*ggggI");
        String expect = "the password must contain at least one digit,"
                + "a lowercase or uppercase character, and special characters.";
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void whenPasswordNotHaveUpperCharacter() {
        String result = PasswordValidator.validate("h1*ggggI");
        String expect = "the password must contain at least one digit,"
                + "a lowercase or uppercase character, and special characters.";
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void whenPasswordNotHaveLowerCharacter() {
        String result = PasswordValidator.validate("1J*GGGGI");
        String expect = "the password must contain at least one digit,"
                + "a lowercase or uppercase character, and special characters.";
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void whenPasswordIsShort() {
        String result = PasswordValidator.validate("1hJ*I");
        String expect = "Password is short or long";
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void whenPasswordIsLong() {
        String result = PasswordValidator.validate("1hhhhhhhhhhhhhhhhhhhhhhhhhhhhhJ*I");
        String expect = "Password is short or long";
        assertThat(result).isEqualTo(expect);
    }

    @Test
    void whenPasswordHaveUsed() {
        String result = PasswordValidator.validate("admin1J*GGhGI");
        String expect = "Password is used in base";
        assertThat(result).isEqualTo(expect);
    }

    @Test
    public void whenEmpty() {
        String result = PasswordValidator.validate("");
        String expect = "Password is used";
        assertThat(result).isEqualTo(expect);
    }
}