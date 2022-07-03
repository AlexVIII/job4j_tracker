package ru.job4j.tracker;

import javax.swing.*;

public class FindByIdAction implements UserAction {

    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "- Find item by id - ";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("Find item by id");
        int id = input.askInt("Enter id : ");
        Item item = tracker.findById(id);
        System.out.println("_____________");
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Заявка не найдена");
        }
        System.out.println("____________");
        return true;
    }
}
