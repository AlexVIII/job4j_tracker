package ru.job4j.stream;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ListToMapTest {
    @Test
    public void whenInputListNotHaveDuplicate() {
        List<Student> students = Arrays.asList(
                new Student("Ivanov", 40),
                new Student("Petrov", 60),
                new Student("Ivanova", 50)
        );
        Map<String, Student> result = ListToMap.convert(students);
        Map<String, Student> expect =  new LinkedHashMap<>();
        expect.put("Ivanov", new Student("Ivanov", 40));
        expect.put("Petrov", new Student("Petrov", 60));
        expect.put("Ivanova", new Student("Ivanova", 50));
        assertThat(result).containsAllEntriesOf(expect);
    }

    @Test
    public void whenInputListHaveDuplicate() {
        List<Student> students = Arrays.asList(
                new Student("Ivanov", 40),
                new Student("Petrov", 60),
                new Student("Ivanov", 50),
                new Student("Petrov", 70),
                new Student("Ivanova", 66),
                new Student("Ivanova", 61)
        );
        Map<String, Student> result = ListToMap.convert(students);
        Map<String, Student> expect =  new LinkedHashMap<>();
        expect.put("Ivanov", new Student("Ivanov", 40));
        expect.put("Petrov", new Student("Petrov", 60));
        expect.put("Ivanova", new Student("Ivanova", 66));
        assertThat(result).containsAllEntriesOf(expect);
    }
}