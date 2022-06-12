package ru.job4j.inheritance;

public class PizzaExtraCheeseExtraTomato extends PizzaExtraCheese {
    public PizzaExtraCheeseExtraTomato() {
        super();
    }

    public String name() {
        return super.name() + " + extra tomato";
    }
}
