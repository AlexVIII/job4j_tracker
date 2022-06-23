package ru.job4j.io;

import java.util.Scanner;

public class Matchers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок <-" : "       -> Второй игрок";
            System.out.println(player);
            System.out.print("Ведите число от 1 до 3 : ");
            int matchers = Integer.parseInt(input.nextLine());
            if (matchers >= 1 && matchers <= Math.min(3, count)) {
                turn = !turn;
                count = count - matchers;
                System.out.println(" __________");
                System.out.println("Остаток " + count);
                System.out.println(" __________");
            } else {
                System.out.println("Недопустимое значение.Повторите ввод");
            }
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }
}