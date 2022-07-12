package lesson10;

import java.util.*;

public class Database {
    List<Employee> employees = new ArrayList<>();
    Map<String, Employee> employeeMap = new HashMap<>();
    Set<String> position = new HashSet<>();

    public void init() {
        List<Employee> addEmploees = Arrays.asList(new Employee("John", "director", 1250, 45),
                new Employee("Joy", "assistant", 750, 23),
                new Employee("Mark", "engineer", 1050, 42),
                new Employee("Karl", "engineer", 1025, 38));

        employees.addAll(addEmploees);

        for (Employee employee : addEmploees) {
            employeeMap.put(employee.getName(), employee);
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
}
