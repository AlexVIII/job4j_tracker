package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                rsl = i;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Element is not find");
        }
        return rsl;
    }

    public static void main(String[] args) {
        try {
            System.out.println(indexOf(new String[]{"l", "k", "m"}, "m"));
            System.out.println(indexOf(new String[]{"l", "k", "u"}, "0"));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}