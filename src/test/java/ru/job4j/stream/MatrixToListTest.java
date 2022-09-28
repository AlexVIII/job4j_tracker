package ru.job4j.stream;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MatrixToListTest {

    @Test
    public void whenInputSquareMatrix() {
        Integer[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> result = MatrixToList.convert(matrix);
        List<Integer> expect = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertThat(result).containsAll(expect);
    }

    @Test
    public void whenInputNotSquareMatrix() {
        Integer[][] matrix = {
                {1},
                {4, 5},
                {7, 8, 9}
        };
        List<Integer> result = MatrixToList.convert(matrix);
        List<Integer> expect = Arrays.asList(1, 4, 5, 7, 8, 9);
        assertThat(result).containsAll(expect);
    }
}