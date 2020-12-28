package asm4;

import java.util.Scanner;

public class HumanResources {
    private static Scanner scanner;
    private static StaffList staffs;
    private static DepartmentList departments;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        departments = new DepartmentList();
        staffs = new StaffList(scanner, departments);
        HumanResources HumanResources = new HumanResources();
        System.out.println("Welcome to the employee management software !");

        int choice;

        boolean end = false;
        do {
            System.out.println("1. Display employees.");
            System.out.println("2. Display department.");
            System.out.println("3. Display employees by department.");
            System.out.println("4. Add a new employees.");
            System.out.println("5. Search employee by ID or name");
            System.out.println("6. Display salary.");
            System.out.println("7. Display salary in ascending order.");

            System.out.print("You choice: ");
            choice = scanner.nextInt();

            scanner.nextLine();

            switch (choice) {
            case 1:
                // displayEmployees();
                staffs.displayEmployee();
                break;
            case 2:
                // displayDepartment();
                departments.displayDepartment();
                ;
                break;
            case 3:
                HumanResources.displayEmployeesByDepartment();
                break;
            case 4:
                // addEmployees();
                staffs.addEmployee();
                break;
            case 5:
                HumanResources.searchByKeyword();
                break;
            case 6:
                staffs.displaySalary(1);
                break;
            case 7:
                staffs.displaySalary(2);
                break;

            }

        } while (!end);
        System.out.println("Thank you!");
        System.out.println("Goodbye, see you again!");
    }

    /**
     * Display Employee By Department
     */
    private void displayEmployeesByDepartment() {
        for (final Department department : DepartmentList.getAll()) {
            System.out.println();
            staffs.dislayByDepartment(department.getName());

        }
    }

    /**
     * search Keyword
     */
    private void searchByKeyword() {
        System.out.print("Enter keyword: ");
        String keyword = scanner.nextLine();

        System.out.println();
        staffs.searchEmployee(keyword);

    }

}