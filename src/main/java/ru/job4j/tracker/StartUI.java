package ru.job4j.tracker;

public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println();
        System.out.println("Create a new Item ");
        String name = input.askStr("Enter new name: ");
        System.out.println("_____________");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Добавленная заявка :" + item);
        System.out.println("_____________");
    }

    public static void showAllItems(Tracker tracker) {
        System.out.println("Show all items");
        Item[] items = tracker.findAll();
        System.out.println("_____________");
        if (items.length > 0) {
            for (Item item:items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Хранилище пустое. Заявок не найдено");
        }
        System.out.println("____________");
    }

    public static void replaceItem(Input input, Tracker tracker) {
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
    }

    public static void delete(Input input, Tracker tracker) {
         System.out.println("Delete item");
                int id = input.askInt("Enter id :");
                System.out.println("_____________");
                if (tracker.delete(id)) {
                    System.out.println("Заявка успешно удалена");
                } else {
                    System.out.println("Данной заяки нет");
                }
                System.out.println("_____________");
    }

    public static void findById(Input input, Tracker tracker) {
        System.out.println("Find item by id");
        int id = input.askInt("Enter id : ");
        Item item = tracker.findById(id);
        System.out.println("_____________");
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Заявка не найдена");
            System.out.println("____________");
        }
    }

    public static void findByName(Input input, Tracker tracker) {
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
                    System.out.println("____________");
                }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.showAllItems(tracker);
            } else if (select == 2) {
                StartUI.replaceItem(input, tracker);
            } else if (select == 3) {
                StartUI.delete(input, tracker);
            } else if (select == 4) {
              StartUI.findById(input, tracker);
            } else if (select == 5) {
               StartUI.findByName(input, tracker);
            } else if (select == 6) {
                run = false;
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
        new StartUI().init(input, tracker);
    }
}
