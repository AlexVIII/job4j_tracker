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

    @Test
    public void when010And132Then5() {
        Point a = new Point(0, 1, 0);
        Point b = new Point(1, 3, 2);
        double result = a.distance3d(b);
        double expected = 3;
        Assert.assertEquals(expected, result, 0.0);
    }

    @Test
    public void when143And546Then5() {
        Point a = new Point(1, 4, 3);
        Point b = new Point(5, 4, 6);
        double result = a.distance3d(b);
        double expected = 5;
        Assert.assertEquals(expected, result, 0.0);
    }

    @Test
    public void when646And854Then3() {
        Point a = new Point(6, 4, 6);
        Point b = new Point(8, 5, 4);
        double result = a.distance3d(b);
        double expected = 3;
        Assert.assertEquals(expected, result, 0.0);
    }
}