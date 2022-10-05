package ru.job4j.map;

import ru.job4j.collection.User;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class College {
    private final Map<Student, Set<SubjectNew>> students;

    public College(Map<Student, Set<SubjectNew>> students) {
        this.students = students;
    }

    public Optional<Student>  findByAccount(String account) {
        Optional<Student> rsl =  Optional.empty();
        for (Student s: students.keySet()) {
            if (account.equals(s.getAccount())) {
                rsl = Optional.of(s);
                break;
            }
        }
        return rsl;
    }

    public Optional<SubjectNew> findBySubjectName(String account, String name) {
        Optional<SubjectNew> rsl = Optional.empty();
        Optional<Student> s = findByAccount(account);
        if (s.isPresent()) {
            Set<SubjectNew> subjects = students.get(s.get());
            for (SubjectNew subj: subjects) {
                if (name.equals(subj.getName())) {
                    rsl = Optional.of(subj);
                    break;
                }
            }
        }
        return rsl;
    }
}