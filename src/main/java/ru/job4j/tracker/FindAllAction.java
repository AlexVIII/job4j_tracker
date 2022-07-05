package ru.job4j.tracker;

public class FindAllAction implements UserAction {

    private final Output output;

    public FindAllAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "- Show all items -";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("Show all items");
        Item[] items = tracker.findAll();
        output.println("_____________");
        if (items.length > 0) {
            for (Item item:items) {
                output.println(item);
            }
        } else {
            output.println("Items don't find");
        }
        output.println("____________");
        return true;
    }
}
