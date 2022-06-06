package oop;

public class Student {
    public static void main(String[] args) {
        Student petya = new Student();

        for (int i = 0; i < 1; i++) {
            petya.playForward();
            petya.songForward();
            for (int j = 0; j < 1; j++) {
                petya.playBack();
                petya.songBack();
            }
            petya.playForward();
            petya.songForward();

        }
    }

    public void songForward() {
        System.out.println("I believe I can fly");
    }

    public void songBack() {
        System.out.println("Fly can I believe I");
    }

    public void playForward() {
        System.out.println("С D E F G A H C");
    }

    public void playBack() {
        System.out.println("C H A G F E D C");
    }
}