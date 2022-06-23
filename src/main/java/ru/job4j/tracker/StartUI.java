package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu(scanner);
            System.out.print("Select: ");
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 0) {
                System.out.print("Create a new Item ");
                System.out.print("Enter new name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
                System.out.println("Добавленная заявка :" + item);
            } else if (select == 1) {
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
            } else if (select == 2) {
                System.out.print("Edit item");
                System.out.print("Enter id : ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter new name : ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                System.out.println("_____________");
                if (tracker.replace(id, item)) {
                    System.out.println("Заявка успешна изменена");
                } else {
                    System.out.println("Данной заявки нет");
                }
                System.out.println("_____________");
            } else if (select == 3) {
                System.out.println("Delete item");
                System.out.print("Enter id :");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.println("_____________");
                if (tracker.delete(id)) {
                    System.out.println("Заявка успешно удалена");
                } else {
                    System.out.println("Данной заяки нет");
                }
                System.out.println("_____________");
            } else if (select == 4) {
                System.out.println("Find item by id");
                System.out.print("Enter id : ");
                int id = Integer.parseInt(scanner.nextLine());
                Item item = tracker.findById(id);
                System.out.println("_____________");
                if (item != null) {
                    System.out.println(item);
                } else {
                    System.out.println("Заявка не найдена");
                    System.out.println("____________");
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private  void showMenu(Scanner scanner) {
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
