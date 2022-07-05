package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertNull;
public class StartUITest {
    @Test
    public void whenReplaceItemSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced Item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                        "Menu:" + ln
                                + "0. - Add new Item -" + ln
                                + "2. - Edit item -" + ln
                                + "_____________" + ln
                                + "Item is changed" + ln
                                + "_____________" + ln
                                + "6. - Exit Program -" + ln
                )
        );
    }
/*
    @Test
    public void whenFindAllActionSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(
                new String[]{"0", String.valueOf(tracker.add(new Item("FindAll"))), "1", "2"}
        );
        UserAction[] actions = {
                new FindAllAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                        "Menu:" + ln
                                + "0. - Add new Item -" + ln
                                + "1. - Show all items -" + ln
                                + "2. - Edit item -" + ln
                                + "3. - Delete item -" + ln
                                + "4. - Find item by id -" + ln
                                + "5. - Find items by name -" + ln
                                + "6. - Exit Program -" + ln
                )
        );

    }

    @Test
    public void whenFindByNameActionSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("FindByName"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getName()), "1"}
        );
        UserAction[] actions = {
                new FindByNameAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                        "Menu:" + ln
                                + "0. - Add new Item -" + ln
                                + "1. - Show all items -" + ln
                                + "2. - Edit item -" + ln
                                + "3. - Delete item -" + ln
                                + "4. - Find item by id -" + ln
                                + "5. - Find items by name -" + ln
                                + "6. - Exit Program -" + ln
                )
        );
    }

    @Test
    public void whenFindByIdActionSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("FindById"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new FindByIdAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                        "Menu:" + ln
                                + "0. - Add new Item -" + ln
                                + "1. - Show all items -" + ln
                                + "2. - Edit item -" + ln
                                + "3. - Delete item -" + ln
                                + "4. - Find item by id -" + ln
                                + "5. - Find items by name -" + ln
                                + "6. - Exit Program -" + ln
                )
        );
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. - Add new Item -" + ln
                        + "1. - Show all items -" + ln
                        + "2. - Edit item -" + ln
                        + "3. - Delete item -" + ln
                        + "4. - Find item by id -" + ln
                        + "5. - Find items by name -" + ln
                        + "6. - Exit Program -" + ln
        ));
    }*/
}
