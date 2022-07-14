package ru.job4j.seach;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> person = new ArrayList<>();

    public void add(Person person) {
       this.person.add(person);
    }
    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person rsl : person) {
            if (rsl.getName().contains(key)
                    || rsl.getSurname().contains(key)
                    || rsl.getPhone().contains(key)
                    || rsl.getAddress().contains(key)) {
                result.add(rsl);
            }
        }
        return result;
    }
}
