import java.util.Arrays;

public class Collaborator {
    public static void main(String[] args) {
        Employee[] persArray = new Employee[5];
        persArray[0] = new Employee("Ivanov Ivan", "Engineer", "ivanov@gmail.com", "+4917432354", 2243.53, 41);
        persArray[1] = new Employee("Timur Scvortov", "Architect", "timur@yahoo.com", "+30120549867", 2598.73, 35);
        persArray[2] = new Employee("Elena Sidorova", "Contabil", "e.sidorova@mail.ru", "+7932457933", 1985.4, 54);
        persArray[3] = new Employee("Maxim Sergheev", "Traktorist", "sergheecm@gmail.com", "+14523054324", 1550.87, 43);
        persArray[4] = new Employee("Violeta Karamanova", "Povar", "v_karamanova@rambler.ru", "+393245875434", 2030.34, 32);
        //System.out.println(Arrays.toString(persArray));
        for (int i = 0; i < persArray.length; i++) {
            if (persArray[i].getAge() > 40) {
                System.out.println(persArray[i]);
            }
        }
    }
}

class Employee {
    private String name;
    private String post;
    private String email;
    private String tel;
    private double salary;
    private int age;

    Employee(String name, String post, String email, String tel, double salary, int age) {
        this.name = name;
        this.post = post;
        this.email = email;
        this.tel = tel;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return name + ", " + post + ", " + email + ", " + tel + ", " + salary + ", " + age;
    }
}

