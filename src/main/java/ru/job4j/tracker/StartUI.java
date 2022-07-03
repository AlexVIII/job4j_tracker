package ru.job4j.tracker;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            showMenu();
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
            if (select == 0) {
                new CreateAction(out);
            } else if (select == 1) {
                new FindAllAction(out);
            } else if (select == 2) {
                new ReplaceAction(out);
            } else if (select == 3) {
                new DeleteAction(out);
            } else if (select == 4) {
              new FindByIdAction(out);
            } else if (select == 5) {
               new FindByNameAction(out);
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
       Output output = new ConsoleOutput();
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new FindAllAction(output),
                new ReplaceAction(output),
                new DeleteAction(output),
                new FindByIdAction(output),
                new FindByNameAction(output),
                new ExitAction()};
        new StartUI(output).init(input, tracker, actions);
    }
}
