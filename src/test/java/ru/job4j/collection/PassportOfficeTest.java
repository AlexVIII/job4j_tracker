package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PassportOfficeTest {

    @Test
    public void addNew() {
        Citizen citizen = new Citizen("2121A", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport()), is(citizen));
    }

    @Test
    public void addDublicated() {
        Citizen citizen = new Citizen("2121A", "Petr Arsentev");
        Citizen citizenDouble = new Citizen("2121A", "Petr Arsentev Double");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertFalse(office.add(citizenDouble));
    }
}