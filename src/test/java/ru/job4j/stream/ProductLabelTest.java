package ru.job4j.stream;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ProductLabelTest {
    @Test
    public void whenGeneratedLabels() {
        Label one = new Label("Bread", 25);
        Label two = new Label("Butter", 70);
        Label three = new Label("Cherry", 120);
        Label four = new Label("Lemon", 60);
        List<Product> products = Arrays.asList(
                new Product("Bread", 50, 5, 4),
                new Product("Butter", 140, 30, 30),
                new Product("Orange", 145, 60, 55),
                new Product("Coffee", 290, 365, 302),
                new Product("Milk", 75, 14, 10),
                new Product("Lemon", 120, 21, 19),
                new Product("Cherry", 240, 35, 34)
        );
        ProductLabel generator = new ProductLabel();
        List<String> strings = generator.generateLabels(products);
        List<String> expected = Arrays.asList(one.toString(), two.toString(), three.toString(), four.toString());
        assertThat(strings).containsAll(expected);
    }
}