package asm4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class DepartmentList {

    private static List<Department> departments;

    /**
     * List Department
     */
    public DepartmentList() {
        departments = new ArrayList<>(Arrays.asList(new Department("A1", "Development", 9),
                new Department("A2", "IT", 5), new Department("A3", "Account", 4)));
    }

    /**
     * Display Department
     */
    public void display() {
        System.out.println(Department.getHeader());
        for (Department d : departments) {
            System.out.println(d.toString());
        }
    }

    /**
     * @param departmentId
     * @return departmentExist
     */
    public boolean isDepartmentExist(String departmentId) {
        for (Department department : departments) {
            if (department.getName().equals(departmentId)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * @param departmentId
     * @return department
     */
    public Department getDepartmentByName(String departmentId) {
        for (Department department : departments) {
            if (department.getName().equals(departmentId)) {
                return department;
            }
        }
        return null;
    }

    /**
     * display Department
     */
    public void displayDepartment() {
        System.out.println(Department.getHeader());
        for (Department department : departments) {
            System.out.println(department);
        }
    }

    /**
     * get All departments
     * 
     * @return departments
     */
    static List<Department> getAll() {
        return departments;
    }
}