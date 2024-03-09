package Task_3.Comparator;

public class Employee implements Comparable<Employee> {
    
    public int Salary(){
        return salary;
    }
    private int salary;
    
    public int Age(){
        return age;
    }
    private int age;


    public Employee(int salary, int age){
        this.salary = salary;
        this.age = age;
    }

    @Override
    public int compareTo(Employee anotherEmployee) {
        return Integer.compare(this.age, anotherEmployee.age);
    }

    @Override
    public String toString(){
        return "Employee. Age: "+ age + ", Salary: " + salary;
    }
}