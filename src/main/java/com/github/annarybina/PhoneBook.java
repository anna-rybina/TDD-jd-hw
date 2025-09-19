package com.github.annarybina;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private Map<String, String> contactsByName;
    private Map<String, String> contactsByNumber;

    public PhoneBook() {
        contactsByName = new HashMap<>();
        contactsByNumber = new HashMap<>();
    }

    public int add(String name, String number) {
        if (contactsByName.containsKey(name)) {
            return contactsByName.size();
        }

        contactsByName.put(name, number);
        contactsByNumber.put(number, name);
        return contactsByName.size();
    }

    public String findByNumber(String number) {
        return contactsByNumber.get(number);
    }

    public String findByName(String name) {
        return contactsByName.get(name);
    }
}