package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ItemAscByNameTest {

    @Test
    public void sortAscName() {
        List<Item> items = new ArrayList<>() {{
            add(new Item("1"));
            add(new Item("6"));
            add(new Item("3"));
            add(new Item("0"));
        }};
        Collections.sort(items, new ItemAscByName());
        List<Item> expect = new ArrayList<>() {{
            add(new Item("0"));
            add(new Item("1"));
            add(new Item("3"));
            add(new Item("6"));
        }};
        assertThat(items, is(expect));
    }
}