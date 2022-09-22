package ru.job4j.stream;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

class SchoolTest {

    @Test
    public void whenCollectClassA() {
        List<Student> students = List.of(
                new Student("SurName1", 10),
                new Student("SurName2", 50),
                new Student("SurName3", 90),
                new Student("SurName4", 71),
                new Student("SurName5", 55),
                new Student("SurName6", 66)
        );
        School sc = new School();
        Predicate<Student> pr = student -> (student.getScore() >= 70 && student.getScore() <= 100);
        List<Student> rsl = sc.collect(students, pr);
        List<Student> expect =  new ArrayList<>();
        expect.add(new Student("SurName3", 90));
        expect.add(new Student("SurName4", 71));
        assertThat(rsl).containsAll(expect);
    }

    @Test
    public void whenCollectClassB() {
        List<Student> students = List.of(
                new Student("SurName1", 10),
                new Student("SurName2", 50),
                new Student("SurName3", 90),
                new Student("SurName4", 71),
                new Student("SurName5", 55),
                new Student("SurName6", 66)
        );
        School sc = new School();
        Predicate<Student> pr = student -> (student.getScore() >= 50  && student.getScore() < 70);
        List<Student> rsl = sc.collect(students, pr);
        List<Student> expect =  new ArrayList<>();
        expect.add(new Student("SurName2", 50));
        expect.add(new Student("SurName5", 55));
        expect.add(new Student("SurName6", 66));
        assertThat(rsl).containsAll(expect);
    }

    @Test
    public void whenCollectClassC() {
        List<Student> students = List.of(
                new Student("SurName1", 10),
                new Student("SurName2", 50),
                new Student("SurName3", 90),
                new Student("SurName4", 71),
                new Student("SurName5", 55),
                new Student("SurName6", 66)
        );
        School sc = new School();
        Predicate<Student> pr = student -> (student.getScore() < 50);
        List<Student> rsl = sc.collect(students, pr);
        List<Student> expect =  new ArrayList<>();
        expect.add(new Student("SurName1", 10));
        assertThat(rsl).containsAll(expect);
    }
}