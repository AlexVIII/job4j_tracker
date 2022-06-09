package ru.job4j.oop;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static org.hamcrest.Matchers.closeTo;

public class TriangleTest {

    @Test
    public void when00and40and04Then8() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(0, 4);
        Triangle triangle =  new Triangle(a, b, c);
        double rsl = triangle.area();
        MatcherAssert.assertThat(rsl, closeTo(8, 0.001));

    }

    @Test
    public void when00And01And02ThenMinus1() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 1);
        Point c = new Point(0, 2);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        MatcherAssert.assertThat(rsl, closeTo(-1, 0.001));

    }
}