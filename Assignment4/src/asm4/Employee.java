package asm4;

/**
 * Employee
 * 
 * @author THANH
 *
 */
public class Employee extends Staff implements ICalculator, Comparable<ICalculator> {

    /** employees overtime */
    private int overTime;

    public Employee() {
    }

    /**
     * 
     * @param id          Employee id
     * @param name        employee name
     * @param age         employee age
     * @param salaryScale employee salaryScale
     * @param startDate   employee startDate
     * @param department  employee department
     * @param daysOff     employee daysOff
     * @param overTime    employee overTime
     */
    public Employee(String id, String name, int age, double salaryScale, String startDate, String department,
            int daysOff, int overTime) {
        super(id, name, age, salaryScale, startDate, department, daysOff);
        this.overTime = overTime;
    }

    /**
     * get employee overTime
     * 
     * @return employee overTime
     */
    public int getOverTime() {
        return overTime;
    }

    /**
     * set employee overTime
     * 
     * @param overTime
     */
    public void setOverTime(int overTime) {
        this.overTime = overTime;
    }

    /**
     * Caculate Salary
     */
    @Override
    public double caculateSalary() {
        // TODO Auto-generated method stub
        return (this.getSalaryScale() * 3000000 + this.getOverTime() * 200000);
    }

    public static String getHeader() {
        return String.format("%-10s%-15s%-20s%-20s%-20s%-20s%-20s%-20s\n%s", "ID", "Name", "Age", "SalaryScale",
                "StartDate", "Department", "DaysOff", "overTime",
                "-----------------------------------------------------------------------------------------------------------------------------------");

    }

    @Override
    public String toString() {
        return String.format("%-10s%-15s%-20s%-20s%-20s%-20s%-20s%-20s%-20d", this.getId(), this.getName(),
                this.getAge(), this.getSalaryScale(), this.getStartDate(), this.getDepartment(), this.getDaysOff(), "",
                this.getOverTime());
    }

    /**
     * compare salary
     */
    @Override
    public int compareTo(ICalculator o) {
        return (int) (this.caculateSalary() - o.caculateSalary());
    }

}