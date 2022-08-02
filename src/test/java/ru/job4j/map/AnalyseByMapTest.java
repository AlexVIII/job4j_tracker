package ru.job4j.map;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class AnalyseByMapTest {

    @Test
    public void averageScore() {
        double average = AnalyseByMap.averageScore(
                List.of(
                    new Pupil("Ivanov",
                            List.of(new Subject("Math", 100),
                                    new Subject("Lang", 70),
                                    new Subject("Philosofy", 50)
                            )
                    ),
                    new Pupil("Petrov",
                            List.of(new Subject("Math", 50),
                            new Subject("Lang", 60),
                            new Subject("Philosofy", 80)
                            )
                    ),
                    new Pupil("Sidorov",
                            List.of(new Subject("Math", 90),
                                    new Subject("Lang", 90),
                                    new Subject("Philosofy", 90)
                            )
                    )
                )
        );
        assertThat(average).isCloseTo(75.55, offset(0.01D));
    }

    @Test
    public void averageScoreByPupil() {
        List<Label> average = AnalyseByMap.averageScoreByPupil(
                List.of(
                        new Pupil("Ivanov",
                                List.of(new Subject("Math", 100),
                                        new Subject("Lang", 70),
                                        new Subject("Philosofy", 40)
                                )
                        ),
                        new Pupil("Petrov",
                                List.of(new Subject("Math", 50),
                                        new Subject("Lang", 60),
                                        new Subject("Philosofy", 70)
                                )
                        ),
                        new Pupil("Sidorov",
                                List.of(new Subject("Math", 90),
                                        new Subject("Lang", 90),
                                        new Subject("Philosofy", 90)
                                )
                        )
                )
        );
        assertThat(average).hasSameElementsAs(List.of(
                new Label("Ivanov", 70.00D),
                new Label("Petrov", 60.00D),
                new Label("Sidorov", 90.0D)
        ));
    }

    @Test
    public void averageScoreBySubject() {
        List<Label> average = AnalyseByMap.averageScoreBySubject(
                List.of(
                        new Pupil("Ivanov",
                                List.of(new Subject("Math", 100),
                                        new Subject("Lang", 60),
                                        new Subject("Philosofy", 50)
                                )
                        ),
                        new Pupil("Petrov",
                                List.of(new Subject("Math", 50),
                                        new Subject("Lang", 60),
                                        new Subject("Philosofy", 70)
                                )
                        ),
                        new Pupil("Sidorov",
                                List.of(new Subject("Math", 90),
                                        new Subject("Lang", 90),
                                        new Subject("Philosofy", 90)
                                )
                        )
                )
        );

        assertThat(average).hasSameElementsAs(List.of(
                new Label("Math", 80D),
                new Label("Lang", 70D),
                new Label("Philosofy", 70D)
        ));
    }

    @Test
    public void bestStudent() {
        Label best = AnalyseByMap.bestStudent(
                List.of(
                        new Pupil("Ivanov",
                                List.of(new Subject("Math", 100),
                                        new Subject("Lang", 60),
                                        new Subject("Philosofy", 50)
                                )
                        ),
                        new Pupil("Petrov",
                                List.of(new Subject("Math", 50),
                                        new Subject("Lang", 60),
                                        new Subject("Philosofy", 70)
                                )
                        ),
                        new Pupil("Sidorov",
                                List.of(new Subject("Math", 90),
                                        new Subject("Lang", 90),
                                        new Subject("Philosofy", 90)
                                )
                        )
                )
        );
        assertThat(best).isEqualTo(new Label("Sidorov", 270D));
    }

    @Test
    public void whenBestSubject() {
        Label best = AnalyseByMap.bestSubject(
                List.of(
                        new Pupil("Ivanov",
                                List.of(new Subject("Math", 100),
                                        new Subject("Lang", 60),
                                        new Subject("Philosofy", 50)
                                )
                        ),
                        new Pupil("Petrov",
                                List.of(new Subject("Math", 50),
                                        new Subject("Lang", 60),
                                        new Subject("Philosofy", 70)
                                )
                        ),
                        new Pupil("Sidorov",
                                List.of(new Subject("Math", 90),
                                        new Subject("Lang", 90),
                                        new Subject("Philosofy", 90)
                                )
                        )
                )
        );
        assertThat(best).isEqualTo(new Label("Math", 240D));
    }

}