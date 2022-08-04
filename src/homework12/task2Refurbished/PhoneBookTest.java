package homework12.task2Refurbished;

public class PhoneBookTest {
    public static void main(String[] args) {
        //create and fill phone book
        PhoneBook pb = new PhoneBook();
        pb.add("John", 3351268);
        pb.add("John", 2215568);
        pb.add("John", 2314516);
        pb.add("Luke", 5561223);
        pb.add("Mark", 3351261);

        // test getting system of phone book
        System.out.println(pb.get("John"));
        System.out.println(pb.get("Luke"));
        System.out.println(pb.get("Bill"));


    }
}
