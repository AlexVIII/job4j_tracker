package ru.job4j.pojo;

import static org.hamcrest.Matchers.is;
import org.hamcrest.MatcherAssert;

import org.junit.Test;

public class LicenseTest {
    @Test
    public void eqName() {
        License first = new License();
        License second = new License();
        first.setCode("audio");
        second.setCode("audio");
        MatcherAssert.assertThat(first, is(second));
    }
}