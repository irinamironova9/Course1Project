public class Employee {
    private final String fullName;
    private int department;
    private double salary;
    private final int id;
    private static int COUNTER = 1;

    public Employee(String fullName, int department, double salary) {
        if (department < 1 || department > 5) {
            throw new IllegalArgumentException("Недопустимый номер отдела");
        }
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
        id = COUNTER;
        COUNTER += 1;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public static int getCOUNTER() {
        return COUNTER;
    }

    public void setDepartment(int department) {
        if (department < 1 || department > 5) {
            throw new IllegalArgumentException("Недопустимый номер отдела");
        }
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return fullName + ", отдел №" + department + ", з/п " + salary + " руб./мес., id = " + id;
    }

    public String displayWithoutDepartment() {
        return fullName + ", з/п " + salary + " руб./мес., id = " + id;
    }
}
