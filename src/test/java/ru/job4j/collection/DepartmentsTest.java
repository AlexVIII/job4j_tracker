package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DepartmentsTest {
    @Test
    public void whenMissed() {
        List<String> input = Arrays.asList("k1/sk1", "k2/sk1");
        List<String> expect = List.of("k1", "k1/sk1", "k2", "k2/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result).containsAll(expect);
    }

    @Test
    public void whenNonChanga() {
        List<String> input = Arrays.asList("k1", "k1/sk1");
        List<String> expect = List.of("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result).containsAll(expect);
    }

    @Test
    public void whenSortAscWithoutMissedDepartments() {
        List<String> input = Arrays.asList(
                "k1/sk1",
                "k1/sk1/ssk1",
                "k1/sk1/ssk2",
                "k2",
                "k2/sk1",
                "k1/sk2",
                "k1",
                "k2/sk1/ssk2",
                "k2/sk1/ssk1"
        );
        List<String> expect = List.of(
                "k1",
                "k1/sk1",
                "k1/sk1/ssk1",
                "k1/sk1/ssk2",
                "k1/sk2",
                "k2",
                "k2/sk1",
                "k2/sk1/ssk1",
                "k2/sk1/ssk2"
        );
        Departments.sortAsc(input);
        assertThat(input).containsAll(expect);
    }

    @Test
    public void whenSortAscWithMissedDepartments() {
        List<String> input = Arrays.asList(
                "k1/sk1",
                "k1/sk1/ssk1",
                "k1/sk1/ssk2",
                "k2/sk1",
                "k1/sk2",
                "k2/sk1/ssk2",
                "k2/sk1/ssk1"
        );
        List<String> expect = List.of(
                "k1/sk1",
                "k1/sk1/ssk1",
                "k1/sk1/ssk2",
                "k1/sk2",
                "k2/sk1",
                "k2/sk1/ssk1",
                "k2/sk1/ssk2"
        );
        Departments.sortAsc(input);
        assertThat(input).containsAll(expect);
    }

    @Test
    public void whenSortDescWithoutMissedDepartments() {
        List<String> input = Arrays.asList(
                "k1/sk1",
                "k1/sk1/ssk1",
                "k1/sk1/ssk2",
                "k2",
                "k2/sk1",
                "k1/sk2",
                "k1",
                "k2/sk1/ssk2",
                "k2/sk1/ssk1"
        );
        List<String> expect = List.of(
                "k1",
                "k1/sk1",
                "k1/sk1/ssk1",
                "k1/sk1/ssk2",
                "k1/sk2",
                "k2",
                "k2/sk1",
                "k2/sk1/ssk1",
                "k2/sk1/ssk2"
        );
        Departments.sortDesc(input);
        assertThat(input).containsAll(expect);
    }

    @Test
    public void whenSortDescWithMissedDepartments() {
        List<String> input = Arrays.asList(
                "k1/sk1",
                "k1/sk1/ssk1",
                "k1/sk1/ssk2",
                "k2/sk1",
                "k1/sk2",
                "k2/sk1/ssk2",
                "k2/sk1/ssk1"
        );
        List<String> expect = List.of(
                "k1/sk1",
                "k1/sk1/ssk1",
                "k1/sk1/ssk2",
                "k1/sk2",
                "k2/sk1",
                "k2/sk1/ssk1",
                "k2/sk1/ssk2"
        );
        Departments.sortDesc(input);
        assertThat(input).containsAll(expect);
    }
}