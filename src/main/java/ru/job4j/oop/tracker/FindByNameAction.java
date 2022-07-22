package ru.job4j.oop.tracker;

public class FindByNameAction implements UserAction {

    private final Output output;

    public FindByNameAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "- Find items by name -";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("Find item by name");
        String name = input.askStr("Enter name : ");
        Item[] items = tracker.findByName(name);
        output.println("_____________");
        if (items.length > 0) {
            for (Item item : items) {
                output.println(item);
            }
        } else {
            output.println("Заявки с именем : '"  + name + "' не найдены");
        }
        output.println("____________");
        return true;
    }
}
