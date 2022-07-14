package lesson11.lesson10Update;

import java.util.*;

public class Database {
    List<Employee> employees = new ArrayList<>();
    Map<String, Employee> employeeMap = new HashMap<>();
    Map<String, Employee> sortedMap = new TreeMap<>();
    Set<String> position = new HashSet<>();

    public void init() {

        employees.addAll(InitDb.getInitData());

        for (Employee employee : employees) {
            employeeMap.put(employee.getName(), employee);
            sortedMap.put(employee.getName(), employee);
            position.add(employee.getPosition());
        }
    }

    public void create(Employee employee) {
        employees.add(employee);
        employeeMap.put(employee.getName(), employee);
        position.add(employee.getPosition());

    }

    public String read() {
        StringBuffer sb = new StringBuffer();
/*        for (int i = 0; i < employees.size(); i++) {
            sb.append(String.valueOf(i) + ": " +employees.get(i) + "\n");
        }*/
        for (Employee employee : employeeMap.values()) {
            sb.append("" + employee + "\n");
        }
        return sb.toString();
    }

    public void update(String name, Employee employee) {
        delete(name);
        create(employee);
    }

    public boolean delete(String name) {
        Employee employee = employeeMap.get(name);
        if (employee != null) {
            employeeMap.remove(employee.getName());
            employees.remove(employee);
        }
        return false;
    }

    public String find(String name) {
        Employee employee = employeeMap.get(name);
        if (employee != null) {
            return "" + employee + "\n";
        }
        return "Not found";
    }

    public String getPosition() {
        StringBuffer sb = new StringBuffer();
        for (String position : position) {
            sb.append(position + "\n");
        }
        return sb.toString();
    }

    public void printlist(){
        /*Comparator<Employee> comparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                //return o1.getName().compareTo(o2.getName());
                return o1.getAge().compareTo(o2.getAge());
            }
        };
       employees.sort(comparator);*/
        //Set<Employee> sortedSet = new TreeSet<>(employees);
        //for(Employee employee : sortedSet){
        for(Employee employee : sortedMap.values()){  //Vivodim SortedMap
            System.out.println(employee);
        }
    }
}
