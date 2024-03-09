package Task_3.Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        Random r = new Random();
        
        System.out.println("Generated list:");
        for (int i = 0; i < 5; i++) {
            employees.add(new Employee(r.nextInt(100, 100000), r.nextInt(20, 80)));
            System.out.println(employees.get(i));
        }
        System.out.println("");

        Collections.sort(employees);
        
        System.out.println("Sorted by age list:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        System.out.println("");

        Collections.sort(employees, new EmployeeSalaryComparator());
        
        System.out.println("Sorted by salary list:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        System.out.println("");
    }
}