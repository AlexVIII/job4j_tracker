package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ItemDescByNameTest {

    @Test
    public void compare() {
        List<Item> items = new ArrayList<>() {{
            add(new Item("aa"));
            add(new Item("cc"));
            add(new Item("hh"));
            add(new Item("zz"));
        }};
        Collections.sort(items, new ItemDescByName());
        List<Item> expect = new ArrayList<>() {{
            add(new Item("zz"));
            add(new Item("hh"));
            add(new Item("cc"));
            add(new Item("aa"));
        }};
        assertThat(items, is(expect));
    }
}