package ru.job4j.io;

import java.util.Scanner;

public class Matchers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println(player);
            System.out.println("Ведите число от 1 до 3 :");
            int matchers = Integer.parseInt(input.nextLine());
            while (matchers > 3) {
                System.out.println("Недопустимое значение.Повторите ввод");
                System.out.println("Остаток " + count + "  (Значение от 1 до 3)");
                matchers = Integer.parseInt(input.nextLine());
            }
            turn = !turn;
            count = count - matchers;
            System.out.println("Остаток " + count);

        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }
}
