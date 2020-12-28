package asm4;

public abstract class Staff implements ICalculator, Comparable<ICalculator> {
    /** Staff Id */
    private String id;
    /** Staff Name */
    private String name;
    /** Staff Age */
    private int age;
    /** Staff salaryScale */
    private double salaryScale;
    /** Staff startDate */
    private String startDate;
    /** Staff department */
    private String department;
    /** Staff daysOff */
    private int daysOff;

    public Staff() {
    }

    /**
     * Constructor
     * 
     * @param id          Staff Id
     * @param name        Staff Name
     * @param age         Staff age
     * @param salaryScale Staff salaryScale
     * @param startDate   Staff startDate
     * @param department  Staff department
     * @param daysOff     Staff daysOff
     */
    public Staff(String id, String name, int age, double salaryScale, String startDate, String department,
            int daysOff) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salaryScale = salaryScale;
        this.startDate = startDate;
        this.department = department;
        this.daysOff = daysOff;
    }

    /**
     * Get staff Id
     * 
     * @return staff Id
     */
    public String getId() {
        return id;
    }

    /**
     * Set staff Id
     * 
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get staff Name
     * 
     * @return staff name
     */
    public String getName() {
        return name;
    }

    /**
     * Set staff Name
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get staff Age
     * 
     * @return staff Age
     */
    public int getAge() {
        return age;
    }

    /**
     * Set Staff Age
     * 
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Get Staff salaryScale
     * 
     * @return Staff salaryScale
     */
    public double getSalaryScale() {
        return salaryScale;
    }

    /**
     * Set Staff salaryScale
     * 
     * @param salaryScale
     */
    public void setSalaryScale(double salaryScale) {
        this.salaryScale = salaryScale;
    }

    /**
     * Get Staff startDate
     * 
     * @return Staff startDate
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * Set Staff startDate
     * 
     * @param startDate
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * Get Staff Department
     * 
     * @return Staff Department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * set staff department
     * 
     * @param department
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * get staff daysOff
     * 
     * @return staff daysOff
     */
    public int getDaysOff() {
        return daysOff;
    }

    /**
     * set staff daysOff
     * 
     * @param daysOff
     */
    public void setDaysOff(int daysOff) {
        this.daysOff = daysOff;
    }

    @Override
    abstract public String toString();

    @Override
    public int compareTo(ICalculator o) {
        return (int) (this.caculateSalary() - o.caculateSalary());
    }
}
