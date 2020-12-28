package asm4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StaffList {

    private Scanner scanner;

    private List<Staff> icaculator;

    private DepartmentList departmentList;

    public StaffList() {

    }

    /**
     * Constructor and List
     * 
     * @param scanner
     * @param departments
     */
    public StaffList(Scanner scanner, DepartmentList departments) {
        this.scanner = scanner;
        this.departmentList = departments;
        icaculator = new ArrayList<>(
                Arrays.asList(new Employee("A1", "Thanh", 18, 2.0, "11-11-2020", "Development", 1, 9),
                        new Manager("A4", "Thanh", 24, 1.4, "07-10-2020", "Development", 1, "Project Leader"),
                        new Manager("A4", "Thanh", 24, 1.4, "07-10-2020", "Development", 1, "Project Leader"),
                        new Manager("A5", "Thuan", 21, 1.0, "07-09-2020", "IT", 1, "Technical Leader"),
                        new Manager("A6", "Tran", 22, 2.2, "07-03-2020", "Account", 1, "Business Leader"),
                        new Employee("A1", "Thanh", 18, 2.0, "11-11-2020", "Development", 1, 9),
                        new Employee("A1", "Nam", 18, 2.0, "5-1-2020", "Development", 2, 3),
                        new Employee("A2", "Dien", 18, 1.5, "04-02-2020", "IT", 5, 6),
                        new Employee("A2", "Hai", 20, 1.7, "21-11-2020", "IT", 4, 5),
                        new Employee("A3", "Binh", 25, 1.7, "03-07-2020", "Account", 3, 1),
                        new Employee("A2", "Ton", 21, 1.3, "11-11-2020", "IT", 5, 2),
                        new Employee("A1", "Tho", 24, 1.3, "11-11-2020", "Development", 1, 4),
                        new Employee("A1", "Hien", 27, 1.6, "11-11-2020", "Development", 4, 1),
                        new Employee("A3", "Hang", 22, 1.6, "11-11-2020", "Account", 3, 7),
                        new Employee("A1", "Lam", 29, 2.1, "11-11-2020", "Development", 1, 9),
                        new Employee("A2", "Dai", 19, 2.2, "11-11-2020", "IT", 4, 2),
                        new Employee("A1", "Minh", 30, 1.1, "11-11-2020", "Development", 7, 1),
                        new Employee("A3", "Hien", 28, 1.2, "11-11-2020", "Account", 1, 2)));

    }

    /**
     * Display Employee
     */
    public void displayEmployee() {
        System.out.println("Employee list: ");
        System.out.printf("%-10s%-15s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%n", "ID", "Name", "Age", "SalaryScale",
                "startDate", "Department", "DaysOff", "Position", "Overtime");
        for (ICalculator it : icaculator) {
            System.out.println(it.toString());
        }
    }

    /**
     * add Employee
     */
    public void addEmployee() {
        Employee employee = new Employee();
        System.out.println("Enter new information for employee (1 = employee, 2 = manager): ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.print("ID: ");
        String id = scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Age: ");
        // int age = scanner.nextInt();
        int age = InputHelper.inputInt(scanner, 0, 200);

        scanner.nextLine();
        System.out.print("salaryScale: ");
        double salaryScale = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("startDate: ");
        String startDate = scanner.nextLine();

        System.out.print("Department: ");
        String department;
        do {
            department = scanner.nextLine();
            if (!departmentList.isDepartmentExist(department)) {
                System.out.println("Department is not exist! Please input again: ");
                department = "";
            }
        } while (department.equals(""));
        Department de = departmentList.getDepartmentByName(department);
        de.setEmploysNum(de.getEmploysNum() + 1);
        employee.setDepartment(department);

        System.out.print("DaysOff: ");
        int daysOff = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
        case 1:
            System.out.print("Overtime: ");
            int overTime = scanner.nextInt();
            scanner.nextLine();
            icaculator.add(new Employee(id, name, age, salaryScale, startDate, department, daysOff, overTime));
            break;
        case 2:
            System.out.print("Position: ");
            String Position = scanner.nextLine();
            icaculator.add(new Manager(id, name, age, salaryScale, startDate, department, daysOff, Position));
            break;
        }

    }

    /**
     * Display Employee By Department
     * 
     * @param department
     */
    public void dislayByDepartment(String department) {
        List<ICalculator> departmentEmployees = new ArrayList<ICalculator>();

        for (ICalculator item : icaculator) {
            if ((item instanceof Employee && ((Employee) item).getDepartment().equals(department))
                    || (item instanceof Manager && ((Manager) item).getDepartment().equals(department))) {

                departmentEmployees.add(item);
            }
        }

        if (!departmentEmployees.isEmpty()) {
            System.out.println(department + " Employee: ");
            System.out.println(Employee.getHeader());
            for (ICalculator employee : departmentEmployees) {
                System.out.println(employee.toString());
            }
        }
    }

    /**
     * Search Employee
     * 
     * @param keyword
     */
    public void searchEmployee(String keyword) {
        List<ICalculator> foundEmployees = new ArrayList<ICalculator>();

        // find by id and name
        for (ICalculator item : icaculator) {
            if (item.getId().contains(keyword) || item.getName().contains(keyword)) {
                foundEmployees.add(item);
            }
        }

        // print data
        if (!foundEmployees.isEmpty()) {
            System.out.println("Employees:");
            System.out.println(Employee.getHeader());
            for (ICalculator e : foundEmployees) {
                System.out.println(e);
            }
        } else {
            System.out.println("Employee not found.");
        }
    }

    /**
     * Display Salary
     * 
     * @param type
     */
    public void displaySalary(int type) {
        if (type == 1) {
            System.out.println(String.format("%-10s%-20s%-20s", "ID", "Name", "salary"));
            Collections.sort(icaculator);
            Collections.reverse(icaculator);

            for (ICalculator employee : icaculator) {
                System.out.printf("%-10s%-20s%-20.2f\n", employee.getId(), employee.getName(),
                        employee.caculateSalary());
            }
        } else {
            System.out.println(String.format("%-10s%-20s%-20s", "ID", "Name", "salary"));

            Collections.sort(icaculator);
            for (ICalculator employee : icaculator) {
                System.out.printf("%-10s%-20s%-20.2f\n", employee.getId(), employee.getName(),
                        employee.caculateSalary());
            }

        }
    }
}
