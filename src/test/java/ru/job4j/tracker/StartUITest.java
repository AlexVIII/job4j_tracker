package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;

public class StartUITest {

    @Test
    public void createItem() {
        String[] answers = {"Fg"};
        Input input = new StubInput(answers);
        Tracker tracker =  new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fg");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void editItem() {
        Tracker tracker = new Tracker();
        Item item =  new Item("new Item");
        tracker.add(item);
        String[] answers = {String.valueOf(item.getId()), "edited item"};
        StartUI.replaceItem(new StubInput(answers), tracker);
        Item edited = tracker.findById(item.getId());
        assertThat(edited.getName(), is("edited item"));
    }

    @Test
    public void deleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new Item");
        tracker.add(item);
        String[] answers = {String.valueOf(item.getId()), "Данной заявки нет"};
        StartUI.delete(new StubInput(answers), tracker);
        Item deleted = tracker.findById(item.getId());
        assertNull(deleted.getName());
    }

}