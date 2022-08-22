package ru.job4j.collection;


import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class StringCompareTest {

    @Test
    public void whenStringAreEqualThenZero() {
        StringCompare compare = new StringCompare();
        int rst =  compare.compare(
                "Ivanov",
                "Ivanov"
        );
        assertThat(rst).isEqualTo(0);
    }

    @Test
    public void whenStringAreNotEqualThenMinusOne() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "IvAnov",
                "Ivanova"
        );
        assertThat(rst).isLessThan(0);
    }

    @Test
    public void whenLeftGreaterThanRightResultShouldBePositive() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Petrov",
                "Ivanov"
        );
        assertThat(rst).isGreaterThan(0);
    }

    @Test
    public void whenSecondCharGreaterThanRightResultShouldBePositive() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Petrov",
                "Patrov"
        );
        assertThat(rst).isGreaterThan(0);
    }

    @Test
    public void whenFirstCharGreaterThanRightResultShouldBePositive() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Patrov",
                "Petrov"
        );
        assertThat(rst).isLessThan(0);
    }
}






