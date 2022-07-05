package ru.job4j.tracker;

import javax.swing.*;

public class FindByIdAction implements UserAction {

    private final Output output;

    public FindByIdAction(Output output) {

        this.output = output;
    }

    @Override
    public String name() {
        return "- Find item by id -";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("Find item by id");
        int id = input.askInt("Enter id : ");
        Item item = tracker.findById(id);
        output.println("_____________");
        if (item != null) {
            output.println(item);
        } else {
            output.println("Заявка не найдена");
        }
        output.println("____________");
        return true;
    }
}
