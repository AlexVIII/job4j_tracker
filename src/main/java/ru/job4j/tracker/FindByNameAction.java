package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "- Find items by name -";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("Find item by name");
        System.out.print("Enter name : ");
        String name = input.askStr("Enter name : ");
        Item[] items = tracker.findByName(name);
        System.out.println("_____________");
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Заявки с именем : '"  + name + "' не найдены");
        }
        System.out.println("____________");
        return true;
    }
}
