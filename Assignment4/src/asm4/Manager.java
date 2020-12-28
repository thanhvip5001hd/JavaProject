package asm4;

public class Manager extends Staff implements ICalculator, Comparable<ICalculator> {

    /**
     * manager title
     */
    private String title;

    /**
     * get manager title
     * 
     * @return manager title
     */
    public String getTitle() {
        return title;
    }

    /**
     * set manager title
     * 
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    public Manager() {
    }

    /**
     * 
     * @param id          manager id
     * @param name        manager name
     * @param age         manager age
     * @param salaryScale manager salaryScale
     * @param startDate   manager startDate
     * @param department  manager department
     * @param daysOff     manager daysOff
     * @param title       manager title
     */
    public Manager(String id, String name, int age, double salaryScale, String startDate, String department,
            int daysOff, String title) {
        super(id, name, age, salaryScale, startDate, department, daysOff);
        // TODO Auto-generated constructor stub
        this.title = title;
    }

    public static String getHeader() {
        return String.format("%-10s%-15s%-20s%-20s%-20s%-20s%-20s%-20s\n%s", "ID", "Name", "Age", "SalaryScale",
                "StartDate", "Department", "DaysOff", "Title",
                "-----------------------------------------------------------------------------------------------------------------------------------");

    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("%-10s%-15s%-20s%-20s%-20s%-20s%-20s%-20s%-20s", this.getId(), this.getName(),
                this.getAge(), this.getSalaryScale(), this.getStartDate(), this.getDepartment(), this.getDaysOff(),
                this.getTitle(), "");
    }

    @Override
    public double caculateSalary() {
        // TODO Auto-generated method stub
        return (getSalaryScale() * 5000000)
                + (getTitle() == "Business Leader" ? 8000000 : getTitle() == "Project Leader" ? 5000000 : 6000000);
    }

    @Override
    public int compareTo(ICalculator o) {
        // TODO Auto-generated method stub
        return (int) (this.caculateSalary() - o.caculateSalary());
    }

}
