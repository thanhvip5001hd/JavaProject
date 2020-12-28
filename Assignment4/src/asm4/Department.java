package asm4;

class Department {
    private String id;
    private String name;
    private int employsNum;

    /**
     * 
     * @param id
     * @param name
     * @param employsNum
     */
    public Department(String id, String name, int employsNum) {
        this.id = id;
        this.name = name;
        this.employsNum = employsNum;
    }

    /**
     * 
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     */
    public int getEmploysNum() {
        return employsNum;
    }

    /**
     * 
     * @param employsNum
     */
    public void setEmploysNum(int employsNum) {
        this.employsNum = employsNum;
    }

    static String getHeader() {
        // TODO Auto-generated method stub
        return String.format("%-10s%-15s%-20s\n%s", "ID", "Name", "EmployeeNum",
                "---------------------------------------");
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("%-10s%-15s%-20d", id, name, employsNum);
    }
}