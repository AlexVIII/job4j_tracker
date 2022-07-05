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
        String menu  = "Menu:" + ln
                + "0. - Edit item -" + ln
                + "1. - Exit Program -" + ln;
        assertThat(out.toString(), is(
                menu
                        + "Edit item" + ln
                        + "_____________" + ln
                        + "Item is changed" + ln
                        + "_____________" + ln
                        + menu
                )
        );
    }

    @Test
    public void whenFindAllActionSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Find All"));
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        UserAction[] actions = {
                new FindAllAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        String menu  = "Menu:" + ln
                + "0. - Show all items -" + ln
                + "1. - Exit Program -" + ln;
        assertThat(out.toString(), is(
                menu
                        + "Show all items" + ln
                        + "_____________" + ln
                        + item + ln
                        + "____________" + ln
                + menu
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
        String menu  = "Menu:" + ln
                + "0. - Find items by name -" + ln
                + "1. - Exit Program -" + ln;
        assertThat(out.toString(), is(
                        menu
                + "Find item by name" + ln
                + "_____________" + ln + item + ln
                + "____________" + ln
                + menu
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
        String menu  = "Menu:" + ln
                + "0. - Find item by id -" + ln
                + "1. - Exit Program -" + ln;
        assertThat(out.toString(), is(
                        menu
                + "Find item by id" + ln
                + "_____________" + ln
                + item + ln + "____________" + ln
                + menu
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
        String menu  = "Menu:" + ln
                + "0. - Exit Program -" + ln;
        assertThat(out.toString(), is(
                menu
        ));
    }
}
