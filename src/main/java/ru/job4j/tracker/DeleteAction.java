package ru.job4j.tracker;

public class DeleteAction implements UserAction {

    private final Output output;

    public DeleteAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "- Delete item -";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("Delete item");
        int id = input.askInt("Enter id :");
        output.println("_____________");
        if (tracker.delete(id)) {
            output.println("Item was deleted successfully");
        } else {
            output.println("Item don't find");
        }
        output.println("_____________");
        return true;
    }
}
