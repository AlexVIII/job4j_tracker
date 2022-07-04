package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            showMenu();
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
            if (select == 0) {
                new CreateAction();
            } else if (select == 1) {
                new FindAllAction();
            } else if (select == 2) {
                new ReplaceAction();
            } else if (select == 3) {
                new DeleteAction();
            } else if (select == 4) {
              new FindByIdAction();
            } else if (select == 5) {
               new FindByNameAction();
            } else if (select == 6) {
                new ExitAction();
            }
        }
    }

    private  void showMenu() {
        String[] menu = {
                "- Add new Item -", "- Show all items -", "- Edit item -",
                "- Delete item -", "- Find item by id - ", "- Find items by name -",
                "- Exit Program -"
        };
        System.out.println("Menu:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new FindAllAction(),
                new ReplaceAction(),
                new DeleteAction(),
                new FindByIdAction(),
                new FindByNameAction(),
                new ExitAction()};
        new StartUI().init(input, tracker, actions);
    }
}
