import java.util.ArrayList;

abstract class Employee {
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Employee [name=" + name + ", id=" + id + " salary="+calculateSalary()+"]";
    }
}

class FullTimeEmployee extends Employee {
    private double monthlysalary;

    public FullTimeEmployee(String name, int id, double monthlysalary) {
        super(name, id);
        this.monthlysalary = monthlysalary;
    }

    @Override
    public double calculateSalary() {
        return monthlysalary;
    }

}

class PartTimeEmployee extends Employee {
    private int hour;
    private double hourlyRate;
    public PartTimeEmployee(String name, int id, int hour, double hourlyRate) {
        super(name, id);
        this.hour = hour;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hour;
    }
}

class PayrollSystem{
    private ArrayList<Employee> employees;

    public PayrollSystem(){
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employees.add(employee);
    }

    public void removeEmployee(int id){
       Employee employeeToRemove = null;
       for(Employee employee : employees){
           if(employee.getId() == id){
               employeeToRemove = employee;
               break;
           }

       }
       if(employeeToRemove != null){
           employees.remove(employeeToRemove);
       }
    }

    public void displayAllEmployees(){
        for(Employee employee : employees){
            System.out.println(employee);
        }
    }
}
public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();
        payrollSystem.addEmployee(new FullTimeEmployee("John Doe", 23, 45.00));
        System.out.println(payrollSystem);

    }
}