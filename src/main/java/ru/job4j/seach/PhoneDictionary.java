package ru.job4j.seach;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
       this.persons.add(person);
    }
    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */

    public ArrayList<Person> find(String key) {
        Predicate<Person> byName = person -> person.getName().contains(key);
        Predicate<Person> bySurname = person -> person.getSurname().contains(key);
        Predicate<Person> byPhone =  person -> person.getPhone().contains(key);
        Predicate<Person> byAddress = person -> person.getAddress().contains(key);

        Predicate<Person> combine = byName.or(bySurname).or(byPhone).or(byAddress);
        ArrayList<Person> result =  new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
