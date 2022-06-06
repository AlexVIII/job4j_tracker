package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Ball ball = new Ball();
        Wolf wolf = new Wolf();
        Hare hare = new Hare();
        Fox fox = new Fox();
        Grandfarther grandfarther = new Grandfarther();
        Grandmorther grandmorther = new Grandmorther();
        Rabbit rabbit =  new Rabbit();
        grandmorther.tryStop(ball);
        grandfarther.tryStop(ball);
        rabbit.tryEat(ball);
        wolf.tryEat(ball);
        hare.tryEat(ball);
        fox.tryEat(ball);
    }
}
