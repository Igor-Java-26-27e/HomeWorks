package homework12.task2;


import java.util.List;

public class Contacts{
    private String name;
    private String telefon;

    public Contacts(String name, String telefon) {
        this.name = name;
        this.telefon = telefon;
    }

    public static void get (String searchName, List<Contacts>addressbook){
        for (Contacts contact : addressbook) {
            if (contact.name.equalsIgnoreCase(searchName)) System.out.println(contact);
        }

    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "Contacts{" +
                "name='" + name + '\'' +
                ", telefon='" + telefon + '\'' +
                '}';
    }
}
