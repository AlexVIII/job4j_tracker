package ru.job4j.tracker;

public class CreateAction implements UserAction {

    @Override
    public String name() {
        return "- Add new Item -";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println();
        System.out.println("Create a new Item ");
        String name = input.askStr("Enter new name: ");
        System.out.println("_____________");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Добавленная заявка :" + item);
        System.out.println("_____________");

        return true;
    }
}
