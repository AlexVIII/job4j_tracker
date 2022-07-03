package ru.job4j.tracker;

public class ReplaceAction implements UserAction {

    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "- Edit item -";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("Edit item");
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter new name : ");
        Item item = new Item(name);
        System.out.println("_____________");
        if (tracker.replace(id, item)) {
            System.out.println("Заявка успешна изменена");
        } else {
            System.out.println("Данной заявки нет");
        }
        System.out.println("_____________");
        return true;
    }
}
