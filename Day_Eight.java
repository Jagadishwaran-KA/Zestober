package Zoho_Zestober;

import java.util.*;

class Employee{
    private  final String name;
    private  int salary;
    private  int rating;

    public Employee(String name,int salary,int rating){
        this.name = name;
        this.salary = salary;
        this.rating = rating;
    }

    public int getSalary(){
        return salary;
    }

    public int getRating(){
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" + "name='" + name  + ", salary=" + salary + ", rating=" + rating + '}';
    }
}


public class Day_Eight {
    public static List<Employee>  calculateSalary(List<Employee> employees){
        for(Employee e : employees){
            switch (e.getRating()){
                case 5 -> e.setSalary((int)(1.2 * e.getSalary()));
                case 4 -> e.setSalary((int) (1.1 * e.getSalary()));
                case 3 -> e.setSalary((int)(1.05 * e.getSalary()));
            }
            e.setRating(0);
        }
        employees.sort((p1, p2) -> Integer.compare(p2.getSalary(), p1.getSalary()));
        return employees;
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while(true){
            String name = sc.nextLine();
            if(name.isEmpty()) break;
            int salary = sc.nextInt();
            sc.nextLine();
            int rating = sc.nextInt();
            sc.nextLine();
            employees.add(new Employee(name,salary,rating));
        }
        sc.close();

        List<Employee> updatedEmployeeSalary = calculateSalary(employees);
        for(Employee e : updatedEmployeeSalary) System.out.println(e.toString());

    }
}
