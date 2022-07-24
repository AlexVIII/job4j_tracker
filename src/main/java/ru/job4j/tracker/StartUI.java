package ru.job4j.tracker;

import java.util.List;

public class StartUI {

    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("WRONG INPUT,You can select : 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
          /*  if (select == 0) {
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
                new ExitAction(out);
            }*/
        }
    }

    private  void showMenu(List<UserAction> actions) {
        out.println("Menu:");
        for (int i = 0; i < actions.size(); i++) {
            out.println(i + ". " + actions.get(i).name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new FindAllAction(output),
                new ReplaceAction(output),
                new DeleteAction(output),
                new FindByIdAction(output),
                new FindByNameAction(output),
                new ExitAction(output)};
        new StartUI(output).init(input, tracker, List.of(actions));
    }
}
