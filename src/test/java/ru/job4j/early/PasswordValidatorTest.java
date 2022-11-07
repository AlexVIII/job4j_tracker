package ru.job4j.early;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.Assertions.assertThat;

public class PasswordValidatorTest {

    @Test
    public void whenPasswordNotHaveDigital() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate("hJ*ggggI"));
        assertThat(exception.getMessage()).isEqualTo("the password must contain at least one digit,"
                + "a lowercase or uppercase character, and special characters.");
    }

    @Test
    public void whenPasswordNotHaveUpperCharacter() {
       IllegalArgumentException exception = assertThrows(
               IllegalArgumentException.class,
               () -> PasswordValidator.validate("h1*ggggi"));
       assertThat(exception.getMessage()).isEqualTo("the password must contain at least one digit,"
               + "a lowercase or uppercase character, and special characters.");
    }

    @Test
    public void whenPasswordNotHaveLowerCharacter() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate("1J*GGGGI"));
        assertThat(exception.getMessage()).isEqualTo("the password must contain at least one digit,"
                + "a lowercase or uppercase character, and special characters.");
    }

    @Test
    public void whenPasswordIsShort() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate("1hJ*I"));
        assertThat(exception.getMessage()).isEqualTo("Password is short or long");
        }

    @Test
    public void whenPasswordIsLong() {
       IllegalArgumentException exception = assertThrows(
               IllegalArgumentException.class,
               () -> PasswordValidator.validate("1hhhhhhhhhhhhhhhhhhhhhhhhhhhhhJ*I"));
       assertThat(exception.getMessage()).isEqualTo("Password is short or long");
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPasswordHaveUsed() {
       PasswordValidator.validate("admin1J*GGhGI");
    }

    @Test
    public void whenEmpty() {
       IllegalArgumentException exception = assertThrows(
               IllegalArgumentException.class,
               () -> PasswordValidator.validate(""));
       assertThat(exception.getMessage()).isEqualTo("Password is empty");
    }

    @Test
    public void whenPasswordValid() {
        String result = PasswordValidator.validate("admfffi1J*G10");
        String expect = "admfffi1J*G10";
        assertThat(result).isEqualTo(expect);
    }
}
