package ru.job4j.io;

import java.util.Scanner;
import java.util.Random;

public class MagicBall {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int answer = new Random().nextInt(3);
        System.out.println("Добрый день. Сегодня 20 июня 2022 я скажу что тебя ждет.");
        if (answer == 0) {
            System.out.println("Сегодня ты выиграешь в лотерею");
        } else if (answer == 1) {
            System.out.println("Ты попадешь в аварию");
        } else {
            System.out.println("Не придавай ничему значения");
        }
    }
}