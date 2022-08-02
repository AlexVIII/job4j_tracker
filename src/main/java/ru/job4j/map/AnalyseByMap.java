package ru.job4j.map;

import java.util.*;

public class AnalyseByMap {

    public static double averageScore(List<Pupil> pupils) {
       double sum = 0;
       int amount = 0;
        for (Pupil tempPupil : pupils) {
            for (Subject tempSubject : tempPupil.subjects()) {
                sum += tempSubject.score();
                amount++;
            }
        }

        return sum / amount;
    }
    /*1. Метод averageScore() - в этом методе необходимо найти сумму баллов
    по всем предметам у всех учеников, при этом считая количество суммируемых
    элементов - после этих подсчетов мы просто делим общий балл на количество
    суммируемых элементов;*/

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> temp = new ArrayList<>();
        for (Pupil tempPupil : pupils) {
            double sum = 0;
            int amount = 0;
            for (Subject tempSubject : tempPupil.subjects()) {
                sum += tempSubject.score();
                amount++;
            }
            temp.add(new Label(tempPupil.name(), sum / amount));
        }
        return temp;
    }
    /*2. Метод averageScoreByPupil() - реализация этого метода будет отличаться
    от предыдущего тем, что мы считаем сумму баллов по всем предметам каждого ученика.
    Получив сумму баллов, мы создаем объект типа Label с именем ученика,
    а в качестве второго параметра в конструктор передаем сумму баллов по предметам,
    разделенную на количество предметов ученика.
    Полученный объект добавляем в список, который и возвращаем в конце метода;*/

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> temp = new HashMap<>();
        for (Pupil tempPupil : pupils) {
            for (Subject tempSubject : tempPupil.subjects()) {
                temp.computeIfPresent(tempSubject.name(), (key, value) -> value + tempSubject.score());
                temp.putIfAbsent(tempSubject.name(), tempSubject.score());
            }
        }
        List<Label> tempResult = new ArrayList<>();
        for (String key : temp.keySet()) {
            tempResult.add(new Label(key, temp.get(key) / pupils.size()));
        }

        return tempResult;
    }
    /*3. Метод averageScoreBySubject() - чтобы реализовать данный метод, нам необходимо
    будет собрать временную Map<String, Integer> (в качестве реализации используем
    LinkedHashMap) - в качестве ключа используем название предмета, в качестве значения
    - сумма баллов по этому предмету, которую мы получим у каждого ученика. Далее мы
    перебираем пары ключ-значение в цикле и на их основе создаем объекты типа Label -
    в качестве первого параметра передаем ключ карты, в качестве второго -
    значение карты разделенное на количество учеников. Созданный объект добавляем в
    результирующий список, его мы и вернем в конце метода.*/

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> temp = new ArrayList<>();
        for (Pupil tempPupil : pupils) {
            double sum = 0;
            for (Subject tempSubject : tempPupil.subjects()) {
                sum = sum + tempSubject.score();
            }
            temp.add(new Label(tempPupil.name(), sum));
        }
        temp.sort(Comparator.naturalOrder());
        return temp.get(temp.size() - 1);
    }
    /*4. Метод bestStudent() - в данном методе, также как и в методе averageScoreByPupil()
    , мы собираем список объектов Label за одним исключением - среднее значение баллов
    считать не нужно, мы оставляем подсчитанную сумму баллов как есть. Далее мы сортируем
    список с помощью Comparator.naturalOrder() (именно для этой цели у Label реализован
    интерфейс Comparable). Поскольку нам нужен в итоге лучший студент - то в качестве
    результата мы возвращаем последний элемент из списка.*/

        public static Label bestSubject(List<Pupil> pupils) {
            Map<String, Integer> temp = new HashMap<>();
            for (Pupil tempPupil : pupils) {
                for (Subject tempSubject : tempPupil.subjects()) {
                    temp.computeIfPresent(tempSubject.name(), (key, value) -> value + tempSubject.score());
                    temp.putIfAbsent(tempSubject.name(), tempSubject.score());
                }
            }
            List<Label> tempLabel = new ArrayList<>();
            for (String key : temp.keySet()) {
                tempLabel.add(new Label(key, temp.get(key)));
            }
            tempLabel.sort(Comparator.naturalOrder());
        return tempLabel.get(temp.size() - 1);
    }

    /*5. Метод bestSubject() - в этом методе, также как и в методе averageScoreBySubject() ,
    нам необходимо собрать временную карту. Далее эту карту перебираем в виде пар ключ-значение
    и создаем объекты типа Label - в качестве первого параметра используем ключ, для второго -
    значение карты. После этого мы сортируем список с помощью Comparator.naturalOrder() и в итоге
    возвращаем последний элемент из полученного списка.*/
}