public class Employee {
    private final String fullName;
    private int department;
    private double salary;
    private final int id;
    private static int counter = 1;

    public static void checkDepartmentIsAcceptable(int department) {
        if (department < 1 || department > 5) {
            throw new IllegalArgumentException("Недопустимый номер отдела!");
        }
    }

    public static void checkSalaryIsAcceptable(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Недопустимое значение з/п!");
        }
    }

    public Employee(String fullName, int department, double salary) {
        if (fullName == null || fullName.trim().equals("")) {
            throw new IllegalArgumentException("Недопустимое ФИО!");
        }
        checkDepartmentIsAcceptable(department);
        checkSalaryIsAcceptable(salary);
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
        id = counter;
        counter += 1;
    }

    @Override
    public String toString() {
        return fullName + ", отдел №" + department + ", з/п " + salary + " руб./мес., id = " + id;
    }

    public String displayWithoutDepartment() {
        return fullName + ", з/п " + salary + " руб./мес., id = " + id;
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

    public static int getCounter() {
        return counter;
    }

    public void setDepartment(int department) {
        checkDepartmentIsAcceptable(department);
        this.department = department;
    }

    public void setSalary(double salary) {
        checkSalaryIsAcceptable(salary);
        this.salary = salary;
    }
}
