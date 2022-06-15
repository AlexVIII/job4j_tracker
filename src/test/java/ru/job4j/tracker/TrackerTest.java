package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenFindById() {
        Tracker tracker = new Tracker();
        Item bug =  new Item();
        bug.setName("Bug");
        Item item = tracker.add(bug);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenFindAll() {
        Tracker tracker = new Tracker();
        Item first = new Item();
        Item second = new Item();
        first.setName("First");
        second.setName("Second");
        tracker.add(first);
        tracker.add(second);
        Item result =  tracker.findAll()[0];
        assertThat(result.getName(), is(first.getName()));
    }
}