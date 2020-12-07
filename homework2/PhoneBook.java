package geekbrains.jt.homework2;

import java.util.HashMap;
import java.util.LinkedList;

public class PhoneBook {

    HashMap<String, LinkedList<Person>> phoneBook = new HashMap<>();
    LinkedList<Person> list;

    public PhoneBook() { }

    public void addContact(String surname, String phone, String email ) {
        list = new LinkedList<>();

        if (phoneBook.containsKey(surname)) {
            list = phoneBook.get(surname);
            list.add(new Person(surname, phone, email));
            phoneBook.replace(surname, list);
        }
        else {
            list.add(new Person(surname, phone, email));
            phoneBook.put(surname, list);
        }
    }

    public String[] getContactPhone(String surname) {
        if (!phoneBook.containsKey(surname)) return new String[0];
        list = phoneBook.get(surname);
        String[] result = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i).getPhoneNumber();
        }

        return result;
    }

    public String[] getContactEmail(String surname) {
        if (!phoneBook.containsKey(surname)) return new String[0];
        list = phoneBook.get(surname);
        String[] result = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i).getEmail();
        }

        return result;
    }
}
