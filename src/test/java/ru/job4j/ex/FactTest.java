package ru.job4j.ex;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void calc() {
        int rsl = new Fact().calc(0);
        assertThat(rsl, is(1));
    }
}