package ru.job4j.tracker;

public class CreateAction implements UserAction {
    private final Output output;

    public CreateAction(Output output) {
        this.output = output;
    }
    @Override
    public String name() {
        return "- Add new Item -";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("");
        output.println("Create a new Item ");
        String name = input.askStr("Enter new name: ");
        output.println("_____________");
        Item item = new Item(name);
        tracker.add(item);
        output.println("Добавленная заявка :" + item);
        output.println("_____________");

        return true;
    }
}
