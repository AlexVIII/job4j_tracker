package ru.job4j.stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

class AnalyzeTest {

    @Test
    void averageScore() {
        double average = Analyze.averageScore(
                List.of(
                        new Pupil("Ivanov",
                                List.of(
                                        new Subject("Math", 99),
                                        new Subject("English", 76),
                                        new Subject("Russian", 80)
                                )),

                        new Pupil("Petrov",
                                List.of(
                                        new Subject("Math", 80),
                                        new Subject("English", 99),
                                        new Subject("Russian", 100)
                                )),
                        new Pupil("Sidorov",
                                List.of(
                                        new Subject("Math", 94),
                                        new Subject("English", 92),
                                        new Subject("Russian", 99)
                                ))
                ).stream()
        );
        assertThat(average).isCloseTo(91, offset(0.01D));
    }

    @Test
    void averageScoreByPupil() {
        List<Tuple> average = Analyze.averageScoreByPupil(
                List.of(
                        new Pupil("Ivanov",
                                List.of(
                                        new Subject("Math", 99),
                                        new Subject("English", 76),
                                        new Subject("Russian", 80)
                                )),

                        new Pupil("Petrov",
                                List.of(
                                        new Subject("Math", 80),
                                        new Subject("English", 99),
                                        new Subject("Russian", 100)
                                )),
                        new Pupil("Sidorov",
                                List.of(
                                        new Subject("Math", 94),
                                        new Subject("English", 92),
                                        new Subject("Russian", 90)
                                ))
                ).stream()
        );
        assertThat(average).hasSameElementsAs(List.of(
                new Tuple("Ivanov", 85D),
                new Tuple("Petrov", 93D),
                new Tuple("Sidorov", 92D)
        ));
    }

    @Test
    void averageScoreBySubject() {
        List<Tuple> average = Analyze.averageScoreBySubject(
                List.of(
                        new Pupil("Ivanov",
                                List.of(
                                        new Subject("Math", 99),
                                        new Subject("English", 76),
                                        new Subject("Russian", 80)
                                )),

                        new Pupil("Petrov",
                                List.of(
                                        new Subject("Math", 80),
                                        new Subject("English", 99),
                                        new Subject("Russian", 100)
                                )),
                        new Pupil("Sidorov",
                                List.of(
                                        new Subject("Math", 94),
                                        new Subject("English", 92),
                                        new Subject("Russian", 90)
                                ))
                ).stream()
        );
        assertThat(average).hasSameElementsAs(List.of(
                new Tuple("Math", 91D),
                new Tuple("English", 89D),
                new Tuple("Russian", 90D)
        ));

    }

    @Test
    void bestStudent() {
        Tuple best = Analyze.bestStudent(
                List.of(
                        new Pupil("Ivanov",
                                List.of(
                                        new Subject("Math", 99),
                                        new Subject("English", 76),
                                        new Subject("Russian", 80)
                                )),

                        new Pupil("Petrov",
                                List.of(
                                        new Subject("Math", 80),
                                        new Subject("English", 99),
                                        new Subject("Russian", 100)
                                )),
                        new Pupil("Sidorov",
                                List.of(
                                        new Subject("Math", 95),
                                        new Subject("English", 95),
                                        new Subject("Russian", 89)
                                ))
                ).stream()
        );
        assertThat(best).isEqualTo(new Tuple("Petrov", 279D));
    }

    @Test
    void bestSubject() {
        Tuple best = Analyze.bestSubject(
                List.of(
                        new Pupil("Ivanov",
                                List.of(
                                        new Subject("Math", 99),
                                        new Subject("English", 76),
                                        new Subject("Russian", 80)
                                )),

                        new Pupil("Petrov",
                                List.of(
                                        new Subject("Math", 80),
                                        new Subject("English", 99),
                                        new Subject("Russian", 100)
                                )),
                        new Pupil("Sidorov",
                                List.of(
                                        new Subject("Math", 95),
                                        new Subject("English", 95),
                                        new Subject("Russian", 89)
                                ))
                ).stream()
        );
        assertThat(best).isEqualTo(new Tuple("Math", 274D));
    }
}