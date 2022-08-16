package lesson13;

import lesson11.lesson10Update.Employee;
import lesson11.lesson10Update.InitDb;

import java.util.*;
import java.util.stream.Collectors;

public class Lesson13 {
    public static void main(String[] args) {
        Collection<Employee> employees = InitDb.getInitData();
        //long counter = 0;
        // for (Employee employee : employees)
        /*Iterator<Employee> iterator = employees.iterator();
        while(iterator.hasNext()){
         Employee employee = iterator.next();
            if (employee.getPosition().equals("engineer")){
                counter++;
            }
        }*/
        long counter = employees.stream()
                .filter(p -> p.getPosition().equals("engineer"))
                .count();
        System.out.println(counter);

        Set<String> position =
                employees.stream()
                //.filter(e -> e.get.Age()>40)
                        .map(e -> e.getPosition().toLowerCase())
                        .collect(Collectors.toSet());
        System.out.println(position);
        // filter(), map()
        // count(), collect()

        // sozdanie Mapi imea => sotrudnik
        Map<String, Employee> employeeMap = employees.stream()
                .collect(Collectors.toMap(e -> e.getName(), e->e));
        System.out.println(employeeMap);

        // Sozanie karti pozitziea+> spisok sotrudnikov
        Map<String, Set<String>> positionMap = employees.stream()
                .collect(Collectors.groupingBy(e -> e.getPosition(),
                        Collectors.mapping(e -> e.getName(), Collectors.toSet())
                ));
        System.out.println(positionMap);
    }
}
