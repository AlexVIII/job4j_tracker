package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void when000AndO34Then5() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(0, 3, 4);
        double result = a.distance3d(b);
        double expected = 5;
        Assert.assertEquals(expected, result, 0.0);
    }
}