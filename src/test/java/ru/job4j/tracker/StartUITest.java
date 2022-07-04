package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertNull;
public class StartUITest {
    /*@Test
    public void createItem() {
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {new CreateAction(o),
                new ExitAction()
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }
*/
  /*  @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced Item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", "Replaced Item", "1", "1", "New item name", "2"}
        );
        UserAction[] actions = {
                new CreateAction(),
                new ReplaceAction(),
                new ExitAction()
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }
/*
    @Test
    public void whenDeleteItem() {
        Tracker tracker =  new Tracker();
        Item item = tracker.add(new Item("deleted item"));
        Input in = new StubInput(
                new String[] {"0", "deleted item", "1", "1", "2"}
        );
        UserAction[] actions = {
                new CreateAction(),
                new DeleteAction(),
                new ExitAction()
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }*/
    @Test
    public void whenReplaceItemSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced Item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getName()), "1", String.valueOf(item.getId()), replacedName, "2"}
        );
        UserAction[] actions = {
                new CreateAction(out),
                new ReplaceAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln =System.lineSeparator();
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
    public void whenFindAllActionSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(
                new String[]{"0", String.valueOf(tracker.add(new Item("FindAll"))), "1", "2"}
        );
        UserAction[] actions = {
                new CreateAction(out),
                new FindAllAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln =System.lineSeparator();
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
        String ln =System.lineSeparator();
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
        String ln =System.lineSeparator();
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

}