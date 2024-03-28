package javaassignment;
import java.util.*;

class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee ID: " + id +
                "\nName: " + name +
                "\nDepartment: " + department +
                "\nSalary: $" + salary;
    }
}

 class EmployeeManagementSystem {
    private static List<Employee> employees = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\nEmployee Management System Menu:");
            System.out.println("1. Add new employee");
            System.out.println("2. Update employee details");
            System.out.println("3. Delete an employee");
            System.out.println("4. Display all employees");
            System.out.println("5. Search for an employee");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    updateEmployee();
                    break;
                case 3:
                    deleteEmployee();
                    break;
                case 4:
                    displayEmployees();
                    break;
                case 5:
                    searchEmployee();
                    break;
                case 0:
                    System.out.println("Exiting Employee Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        } while (choice != 0);
        scanner.close();
    }

    private static void addEmployee() {
        System.out.print("Enter employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();

        System.out.print("Enter employee department: ");
        String department = scanner.nextLine();

        System.out.print("Enter employee salary: $");
        double salary = scanner.nextDouble();

        Employee employee = new Employee(id, name, department, salary);
        employees.add(employee);
        System.out.println("Employee added successfully.");
    }

    private static void updateEmployee() {
        System.out.print("Enter employee ID to update details: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        Employee employee = findEmployeeById(id);
        if (employee != null) {
            System.out.println("Employee found:");
            System.out.println(employee);

            System.out.print("Enter new name (leave empty to keep current): ");
            String newName = scanner.nextLine();
            if (!newName.isEmpty()) {
                employee.setName(newName);
            }

            System.out.print("Enter new department (leave empty to keep current): ");
            String newDept = scanner.nextLine();
            if (!newDept.isEmpty()) {
                employee.setDepartment(newDept);
            }

            System.out.print("Enter new salary (-1 to keep current): $");
            double newSalary = scanner.nextDouble();
            if (newSalary != -1) {
                employee.setSalary(newSalary);
            }

            System.out.println("Employee details updated successfully.");
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    private static void deleteEmployee() {
        System.out.print("Enter employee ID to delete: ");
        int id = scanner.nextInt();

        Employee employee = findEmployeeById(id);
        if (employee != null) {
            employees.remove(employee);
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    private static void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees to display.");
        } else {
            System.out.println("Employee List:");
            for (Employee employee : employees) {
                System.out.println(employee);
                System.out.println("--------------------");
            }
        }
    }

    private static void searchEmployee() {
        System.out.print("Enter employee ID to search: ");
        int id = scanner.nextInt();

        Employee employee = findEmployeeById(id);
        if (employee != null) {
            System.out.println("Employee found:");
            System.out.println(employee);
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    private static Employee findEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null; // Employee not found
    }
}
 class sixthanswer {
     private static List<Employee> employees = new ArrayList<>();
     private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        int choice;
        do {
            System.out.println("\nEmployee Management System Menu:");
            System.out.println("1. Add new employee");
            System.out.println("2. Update employee details");
            System.out.println("3. Delete an employee");
            System.out.println("4. Display all employees");
            System.out.println("5. Search for an employee");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    updateEmployee();
                    break;
                case 3:
                    deleteEmployee();
                    break;
                case 4:
                    displayEmployees();
                    break;
                case 5:
                    searchEmployee();
                    break;
                case 0:
                    System.out.println("Exiting Employee Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        } while (choice != 0);
        scanner.close();
    }
     private static void addEmployee() {
         System.out.print("Enter employee ID: ");
         int id = scanner.nextInt();
         scanner.nextLine(); // Consume newline character

         System.out.print("Enter employee name: ");
         String name = scanner.nextLine();

         System.out.print("Enter employee department: ");
         String department = scanner.nextLine();

         System.out.print("Enter employee salary: $");
         double salary = scanner.nextDouble();

         Employee employee = new Employee(id, name, department, salary);
         employees.add(employee);
         System.out.println("Employee added successfully.");
     }

     private static void updateEmployee() {
         System.out.print("Enter employee ID to update details: ");
         int id = scanner.nextInt();
         scanner.nextLine(); // Consume newline character

         Employee employee = findEmployeeById(id);
         if (employee != null) {
             System.out.println("Employee found:");
             System.out.println(employee);

             System.out.print("Enter new name (leave empty to keep current): ");
             String newName = scanner.nextLine();
             if (!newName.isEmpty()) {
                 employee.setName(newName);
             }

             System.out.print("Enter new department (leave empty to keep current): ");
             String newDept = scanner.nextLine();
             if (!newDept.isEmpty()) {
                 employee.setDepartment(newDept);
             }

             System.out.print("Enter new salary (-1 to keep current): $");
             double newSalary = scanner.nextDouble();
             if (newSalary != -1) {
                 employee.setSalary(newSalary);
             }

             System.out.println("Employee details updated successfully.");
         } else {
             System.out.println("Employee with ID " + id + " not found.");
         }
     }

     private static void deleteEmployee() {
         System.out.print("Enter employee ID to delete: ");
         int id = scanner.nextInt();

         Employee employee = findEmployeeById(id);
         if (employee != null) {
             employees.remove(employee);
             System.out.println("Employee deleted successfully.");
         } else {
             System.out.println("Employee with ID " + id + " not found.");
         }
     }

     private static void displayEmployees() {
         if (employees.isEmpty()) {
             System.out.println("No employees to display.");
         } else {
             System.out.println("Employee List:");
             for (Employee employee : employees) {
                 System.out.println(employee);
                 System.out.println("--------------------");
             }
         }
     }

     private static void searchEmployee() {
         System.out.print("Enter employee ID to search: ");
         int id = scanner.nextInt();

         Employee employee = findEmployeeById(id);
         if (employee != null) {
             System.out.println("Employee found:");
             System.out.println(employee);
         } else {
             System.out.println("Employee with ID " + id + " not found.");
         }
     }

     private static Employee findEmployeeById(int id) {
         for (Employee employee : employees) {
             if (employee.getId() == id) {
                 return employee;
             }
         }
         return null; // Employee not found
     }
}
