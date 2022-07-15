package ru.job4j.seach;

import org.junit.Test;

import java.util.ArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {

    @Test
    public void find() {
       PhoneDictionary phoneDictionary = new PhoneDictionary();
       phoneDictionary.add(
               new Person("Petr", "Arsentev", "534872", "Bryansk")
       );
       ArrayList<Person> person = phoneDictionary.find("Petr");
       assertThat(person.get(0).getSurname(), is("Arsentev"));
    }

    @Test
    public void notFind() {
        PhoneDictionary phoneDictionary = new PhoneDictionary();
        phoneDictionary.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> person = phoneDictionary.find("Alex");
        assertThat(person.size(), is(0));
    }
}