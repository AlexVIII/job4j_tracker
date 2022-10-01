package ru.job4j.stream;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StudentLevelTest {

    @Test
    public void whenSorted() {
        List<Student> input = new ArrayList<>();
        input.add(new Student("Misha", 26));
        input.add(new Student("Masha", 78));
        List<Student> expect  = List.of(
                new Student("Masha", 78),
                new Student("Misha", 26)
        );
        assertThat(StudentLevel.levelOf(input, 20)).containsSequence(expect);
    }

    @Test
    public void whenOnlyNull() {
        List<Student> input = new ArrayList<>();
        input.add(null);
        List<Student> expect  = List.of();
        assertThat(StudentLevel.levelOf(input, 20)).containsSequence(expect);
    }

    @Test
    public void whenHasNull() {
        List<Student> input = new ArrayList<>();
        input.add(new Student("Misha", 26));
        input.add(new Student("Masha", 78));
        input.add(null);
        List<Student> expect  = List.of(
                new Student("Masha", 78),
                new Student("Misha", 26)
        );
        assertThat(StudentLevel.levelOf(input, 20)).containsSequence(expect);
    }
}