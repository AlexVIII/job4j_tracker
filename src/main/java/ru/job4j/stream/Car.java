package ru.job4j.stream;

import java.time.LocalDate;

public class Car {
    private String brand;
    private String model;
    private LocalDate created;
    private double volume;
    private String color;

    @Override
    public String toString() {
        return "Car{"
                + "brand='" + brand + '\''
                + ", model='" + model + '\''
                + ", created=" + created
                + ", volume=" + volume
                + ", color='" + color + '\''
                + '}';
    }

    static class Builder {
        private String brand;
        private String model;
        private LocalDate created;
        private double volume;
        private String color;

        Builder builderBrand(String brand) {
            this.brand =  brand;
            return this;
        }

        Builder builderModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildCreated(LocalDate created) {
            this.created = created;
            return this;
        }

        Builder buildVolume(double volume) {
            this.volume = volume;
            return this;
        }

        Builder buildColor(String color) {
            this.color = color;
            return this;
        }

        Car build() {
            Car car = new Car();
            car.brand = brand;
            car.model = model;
            car.created = created;
            car.volume = volume;
            car.color = color;
            return car;
        }
    }

    public static void main(String[] args) {
        Car car = new Builder()
                .builderBrand("Toyota")
                .builderModel("Camry")
                .buildCreated(LocalDate.of(2021, 6, 1))
                .buildVolume(2.5)
                .buildColor("Red")
                .build();
        System.out.println(car);
        Car newCar = new Builder()
                .builderBrand("Opel")
                .builderModel("Astra")
                .buildVolume(1.8)
                .buildColor("Black")
                .build();
        System.out.println(newCar);
    }
}