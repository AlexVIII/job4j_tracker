package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> account = new HashMap<>();
        account.put("stockon@yandex.ru", "Vasyanin Aleksander");
        account.put("on@yandex.ru", "Aleksander");
        for (Map.Entry<String, String> acnt : account.entrySet()) {
            String key =  acnt.getKey();
            String value = acnt.getValue();
            System.out.println("User: " + value + ", mail: " + key);
        }
    }
}