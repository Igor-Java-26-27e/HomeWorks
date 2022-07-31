package homework12.task2;
/**
 * Java Pro. Homework #12
 * @author Igor Cijov
 * @version 31 Jul 2022
 */

import java.util.*;

public class TestContacts {
    public static void main(String[] args) {
        Contacts contact1 = new Contacts("Ivanov", "9834598");
        Contacts contact2 = new Contacts("Smirnov", "10934521");
        Contacts contact3 = new Contacts("Ivanov","57874865487");

        List<Contacts> addressbook = new ArrayList<>();
        addressbook.add(contact1);
        addressbook.add(contact2);
        addressbook.add(contact3);
        addressbook.add(new Contacts("Kuznetzov", "58746987"));
        Contacts.get("Ivanov", addressbook);




        /*HashMap<String, Contacts> contactsMap = new HashMap<>();
        for (Contacts contact : addressbook){
            contactsMap.put(contact.getName(), contact);
        }
        contactsMap.get("Ion");
        System.out.println(contactsMap.get("Ion"));*/

        /*Iterator<Contacts> iterator = addressbook.iterator();
        while (iterator.hasNext()) {
            Contacts contact = iterator.next();
            System.out.println(contact);
        }*/
    }
}
