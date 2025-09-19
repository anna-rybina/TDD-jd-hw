package com.github.annarybina;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class PhoneBook {
    private Map<String, String> contactsByName;
    private Map<String, String> contactsByNumber;
    private TreeSet<String> sortedNames;

    public PhoneBook() {
        contactsByName = new HashMap<>();
        contactsByNumber = new HashMap<>();
        sortedNames = new TreeSet<>();
    }

    public int add(String name, String number) {
        if (contactsByName.containsKey(name)) {
            return contactsByName.size();
        }

        contactsByName.put(name, number);
        contactsByNumber.put(number, name);
        sortedNames.add(name);
        return contactsByName.size();
    }

    public String findByNumber(String number) {
        return contactsByNumber.get(number);
    }

    public String findByName(String name) {
        return contactsByName.get(name);
    }

    public void printAllNames() {

    }
}