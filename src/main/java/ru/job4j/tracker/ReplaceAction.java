package ru.job4j.tracker;

public class ReplaceAction implements UserAction {

    private final Output output;

    public ReplaceAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "- Edit item -";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("Edit item");
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter new name : ");
        Item item = new Item(name);
        output.println("_____________");
        if (tracker.replace(id, item)) {
            output.println("Item is changed");
        } else {
            output.println("Данной заявки нет");
        }
        output.println("_____________");
        return true;
    }
}
