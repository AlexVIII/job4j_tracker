package ru.job4j.ex;

public class FoundEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                rsl = i;
            }
        }
        return rsl;
    }

    public static void main(String[] args) throws ElementNotFoundException {
        try {
            System.out.println(indexOf(new String[]{"l", "k", "m"}, "m"));
            System.out.println(indexOf(new String[]{"l", "k", "u"}, "0"));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}