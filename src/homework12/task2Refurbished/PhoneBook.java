package homework12.task2Refurbished;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneBook {
    private Map<String, Set<Integer>> phoneBook = new HashMap<>();

    public void add (String name, Integer phoneNumber){
        Set<Integer> phones = phoneBook.getOrDefault(name, new HashSet<>());
        phones.add(phoneNumber);
        phoneBook.put(name, phones);
    }

    public Set<Integer> get(String name){
        return phoneBook.get(name);
    }
}
