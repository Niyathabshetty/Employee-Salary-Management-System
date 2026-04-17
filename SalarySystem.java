import java.util.*;

class Employee {
    String name;
    double baseSalary;

    Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    double calculateSalary() {
        return baseSalary;
    }

    void displayPayslip() {
        System.out.println("\n----- Payslip -----");
        System.out.println("Name: " + name);
        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Final Salary: " + calculateSalary());
    }
}

class Manager extends Employee {
    double bonus;

    Manager(String name, double baseSalary, double bonus) {
        super(name, baseSalary);
        this.bonus = bonus;
    }

    double calculateSalary() {
        return baseSalary + bonus;
    }

    void displayPayslip() {
        System.out.println("\n----- Manager Payslip -----");
        System.out.println("Name: " + name);
        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Bonus: " + bonus);
        System.out.println("Final Salary: " + calculateSalary());
    }
}


class Staff extends Employee {
    int absentDays;

    Staff(String name, double baseSalary, int absentDays) {
        super(name, baseSalary);
        this.absentDays = absentDays;
    }

    double calculateSalary() {
        double deduction = absentDays * 500;
        return baseSalary - deduction;
    }

    void displayPayslip() {
        System.out.println("\n----- Staff Payslip -----");
        System.out.println("Name: " + name);
        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Absent Days: " + absentDays);
        System.out.println("Deduction: " + (absentDays * 500));
        System.out.println("Final Salary: " + calculateSalary());
    }
}

public class SalarySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        sc.nextLine();

        ArrayList<Employee> employees = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println("\nEmployee " + (i + 1));
            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter base salary: ");
            double salary = sc.nextDouble();

            System.out.print("Enter role (1-Manager, 2-Staff): ");
            int role = sc.nextInt();

            if (role == 1) {
                System.out.print("Enter bonus: ");
                double bonus = sc.nextDouble();
                employees.add(new Manager(name, salary, bonus));
            } else {
                System.out.print("Enter absent days: ");
                int days = sc.nextInt();
                employees.add(new Staff(name, salary, days));
            }

            sc.nextLine();
        }

        System.out.println("\n===== Employee Payslips =====");

        for (Employee emp : employees) {
            emp.displayPayslip();
        }
    }
}