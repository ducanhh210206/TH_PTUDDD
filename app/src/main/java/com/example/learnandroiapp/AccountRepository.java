package com.example.learnandroiapp;

import java.util.HashMap;
import java.util.Map;

public class AccountRepository {
    private static Map<String, String> accounts = new HashMap<>();

    static {
        accounts.put("admin", "123");
    }

    public static boolean isValidAccount(String username, String password) {
        return accounts.containsKey(username) && accounts.get(username).equals(password);
    }

    public static boolean registerAccount(String username, String password) {
        if (accounts.containsKey(username)) {
            return false;
        }
        accounts.put(username, password);
        return true;
    }
}
