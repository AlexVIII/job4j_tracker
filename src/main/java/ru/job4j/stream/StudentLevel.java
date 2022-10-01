package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Objects;

public class StudentLevel {
    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .filter(Objects::nonNull)
                .sorted((left, right) -> Integer.compare(right.getScore(), left.getScore()))
                //.sorted((left, right) -> right.getSurname().compareTo(left.getSurname()))
                //     .sorted(Comparator.comparingInt(Student::getScore).reversed())
                .takeWhile(st -> st.getScore() > bound)
                .collect(Collectors.toList());
    }
}