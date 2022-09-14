package ru.job4j.function;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FunctionCalculatorTest {

    @Test
    void whenLinearFunctionThenLinearResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expect = Arrays.asList(11D, 13D, 15D);
        assertThat(result).containsAll(expect);
    }

    @Test
    void whenQuadraticFunctionThenQuadraticResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(5, 9, x -> 2 * Math.pow(x, 2) + x + 1);
        List<Double> expected = Arrays.asList(56D, 79D, 106D, 137D);
        assertThat(result).containsAll(expected);
    }

    @Test
    void whenIndicativeFunctionThenIndicativeResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(5, 9, x -> Math.pow(2, x) + x + 1);
        List<Double> expected = Arrays.asList(38D, 71D, 136D, 265D);
        assertThat(result).containsAll(expected);
    }
}