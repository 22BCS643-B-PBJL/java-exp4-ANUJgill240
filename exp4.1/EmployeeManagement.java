package exp41;
import java.util.*;
public class EmployeeManagement {
    private static List<Employee> employeeList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. Search Employee");
            System.out.println("5. Display All Employees");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    updateEmployee();
                    break;
                case 3:
                    removeEmployee();
                    break;
                case 4:
                    searchEmployee();
                    break;
                case 5:
                    displayEmployees();
                    break;
                case 6:
                    System.out.println("Exiting the system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // Method to add an employee
    private static void addEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Employee Salary: ");
        double salary = scanner.nextDouble();

        employeeList.add(new Employee(id, name, salary));
        System.out.println("Employee added successfully!");
    }

    // Method to update an employee
    private static void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (Employee emp : employeeList) {
            if (emp.id == id) {
                System.out.print("Enter new Name: ");
                emp.name = scanner.nextLine();

                System.out.print("Enter new Salary: ");
                emp.salary = scanner.nextDouble();

                System.out.println("Employee updated successfully!");
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    // Method to remove an employee
    private static void removeEmployee() {
        System.out.print("Enter Employee ID to remove: ");
        int id = scanner.nextInt();

        Iterator<Employee> iterator = employeeList.iterator();
        while (iterator.hasNext()) {
            Employee emp = iterator.next();
            if (emp.id == id) {
                iterator.remove();
                System.out.println("Employee removed successfully!");
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    // Method to search for an employee
    private static void searchEmployee() {
        System.out.print("Enter Employee ID to search: ");
        int id = scanner.nextInt();

        for (Employee emp : employeeList) {
            if (emp.id == id) {
                System.out.println("Employee Found: " + emp);
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    // Method to display all employees
    private static void displayEmployees() {
        if (employeeList.isEmpty()) {
            System.out.println("No employees in the system.");
        } else {
            System.out.println("Employee List:");
            for (Employee emp : employeeList) {
                System.out.println(emp);
            }
        }
    }
}
