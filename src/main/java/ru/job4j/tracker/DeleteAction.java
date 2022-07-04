package ru.job4j.tracker;

public class DeleteAction implements UserAction {

    @Override
    public String name() {
        return "- Delete item -";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("Delete item");
        int id = input.askInt("Enter id :");
        System.out.println("_____________");
        if (tracker.delete(id)) {
            System.out.println("Item was deleted successfully");
        } else {
            System.out.println("Item don't find");
        }
        System.out.println("_____________");
        return true;
    }
}
