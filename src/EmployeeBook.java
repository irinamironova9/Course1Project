public class EmployeeBook {
    private final Employee[] employeeBook;
    private int filledIn = 0;

    public EmployeeBook() {
        this.employeeBook = new Employee[10];
    }

    public void addEmployee(String fullName, int department, double salary) {
        if (filledIn == employeeBook.length) {
            throw new RuntimeException("Закончилось место для записи новых сотрудников.");
        }
        Employee employee = new Employee(fullName, department, salary);
        employeeBook[filledIn] = employee;
        filledIn++;
    }

    public void removeEmployee(String fullName) {
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i].getFullName().equals(fullName)) {
                System.out.printf("Сотрудник(ца) %s удален(а).%n", fullName);
                System.arraycopy(employeeBook, i + 1, employeeBook, i, filledIn - i - 1);
                employeeBook[filledIn - 1] = null;
                filledIn--;
                break;
            }
        }
    }
    public void removeEmployee(int id) {
        for (Employee employee : employeeBook) {
            if (employee.getId() == id) {
                removeEmployee(employee.getFullName());
                break; // Как здесь лучше: отослать к методу или скопировать код?
            }
        }
    }

    public void editSalary(String fullName, double salary) {
        for (Employee employee : employeeBook) {
            if (employee.getFullName().equals(fullName)) {
                employee.setSalary(salary);
                break;
            }
        }
    }
    public void editDepartment(String fullName, int department) {
        for (Employee employee : employeeBook) {
            if (employee.getFullName().equals(fullName)) {
                employee.setDepartment(department);
                break;
            }
        }
    }

    public void printByDepartment() {
        for (int i = 1; i <= 5; i++) {
            System.out.printf("Отдел №%s:%n", i);
            for (Employee employee : employeeBook) {
                if (employee == null) {
                    break;
                }
                if (employee.getDepartment() == i) {
                    System.out.println(employee.getFullName());
                }
            }
        }
    }
    public void printAllEmployees() {
        if (employeeBook[0] == null) {
            System.out.println("Книга учёта сотрудников пуста.");
        }
        for (Employee employee : employeeBook) {
            if (employee == null) {
                break;
            }
            System.out.println(employee);
        }
    }



    public double calculateSumOfSalaries() {
        if (employeeBook[0] == null) {
            throw new RuntimeException("Книга учёта сотрудников пуста.");
        }
        double sumOfSalaries = 0;
        for (Employee employee : employeeBook) {
            if (employee == null) {
                break;
            }
            sumOfSalaries += employee.getSalary();
        }
        return sumOfSalaries;
    }

    public void findLowestSalaryEmployee() {
        if (employeeBook[0] == null) {
            throw new RuntimeException("Книга учёта сотрудников пуста.");
        }
        double lowestSalary = Double.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i] == null) {
                break;
            }
            if (employeeBook[i].getSalary() < lowestSalary) {
                lowestSalary = employeeBook[i].getSalary();
                index = i;
            }
        }
        System.out.printf("Сотрудник с минимальной зарплатой в %.2f рублей - %s.%n", lowestSalary, employeeBook[index].getFullName());
    }
    public void findHighestSalaryEmployee() {
        if (employeeBook[0] == null) {
            throw new RuntimeException("Книга учёта сотрудников пуста.");
        }
        double highestSalary = Double.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i] == null) {
                break;
            }
            if (employeeBook[i].getSalary() > highestSalary) {
                highestSalary = employeeBook[i].getSalary();
                index = i;
            }
        }
        System.out.printf("Сотрудник с максимальной зарплатой в %.2f рублей - %s.%n", highestSalary, employeeBook[index].getFullName());
    }

    public double calculateAverageSalary() {
        double sumOfSalaries = calculateSumOfSalaries();
        return sumOfSalaries / (Employee.getCOUNTER() - 1);
    }

    public void printNames() {
        if (employeeBook[0] == null) {
            System.out.println("Книга учёта сотрудников пуста.");
        }
        for (Employee employee : employeeBook) {
            if (employee == null) {
                break;
            }
            System.out.println(employee.getFullName());
        }
    }

    public void indexSalaries(double percent) {
        for (Employee employee : employeeBook) {
            if (employee == null) {
                break;
            }
            employee.setSalary(employee.getSalary() + employee.getSalary() / 100 * percent);
        }
    }
    public void findLowSalEmployee_Department(int department) {
        if (department < 1 || department > 5) {
            throw new IllegalArgumentException("Недопустимый номер отдела");
        }
        if (employeeBook[0] == null) {
            throw new RuntimeException("Книга учёта сотрудников пуста.");
        }
        double lowestSalary = Double.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i] == null) {
                break;
            }
            if (employeeBook[i].getDepartment() == department) {
                if (employeeBook[i].getSalary() < lowestSalary) {
                    lowestSalary = employeeBook[i].getSalary();
                    index = i;
                }
            }
        }
        if (index == -1) {
            System.out.printf("В отделе №%s нет сотрудников.%n", department);
        } else {
            System.out.printf("Сотрудник с минимальной по отделу №%s зарплатой в размере %.2f рублей - %s.%n", department, lowestSalary, employeeBook[index].getFullName());
        }
    }
    public void findHighSalEmployee_Department(int department) {
        if (department < 1 || department > 5) {
            throw new IllegalArgumentException("Недопустимый номер отдела");
        }
        if (employeeBook[0] == null) {
            throw new RuntimeException("Книга учёта сотрудников пуста.");
        }
        double highestSalary = 0;
        int index = -1;
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i] == null) {
                break;
            }
            if (employeeBook[i].getDepartment() == department) {
                if (employeeBook[i].getSalary() > highestSalary) {
                    highestSalary = employeeBook[i].getSalary();
                    index = i;
                }
            }
        }
        if (index == -1) {
            System.out.printf("В отделе №%s нет сотрудников.%n", department);
        } else {
            System.out.printf("Сотрудник с максимальной по отделу №%s зарплатой в размере %.2f рублей - %s.%n", department, highestSalary, employeeBook[index].getFullName());
        }
    }
    public double calculateSumOfSalaries_Department(int department) {
        if (department < 1 || department > 5) {
            throw new IllegalArgumentException("Недопустимый номер отдела");
        }
        if (employeeBook[0] == null) {
            throw new RuntimeException("Книга учёта сотрудников пуста.");
        }
        double sumOfSalaries = 0;
        int numberOfEmployees = 0;
        for (Employee employee : employeeBook) {
            if (employee == null) {
                break;
            }
            if (employee.getDepartment() == department) {
                sumOfSalaries += employee.getSalary();
                numberOfEmployees++;
            }
        }
        if (numberOfEmployees == 0) {
            throw new RuntimeException("В отдеде № " + department + " нет сотрудников.");
        }
        return sumOfSalaries;
    }
    public double calculateAverageSalary_Department(int department) {
        if (department < 1 || department > 5) {
            throw new IllegalArgumentException("Недопустимый номер отдела");
        }
        if (employeeBook[0] == null) {
            throw new RuntimeException("Книга учёта сотрудников пуста.");
        }
        double sumOfSalaries = calculateSumOfSalaries_Department(department);
        int numberOfEmployees = 0;
        for (Employee employee : employeeBook) {
            if (employee == null) {
                break;
            }
            if (employee.getDepartment() == department) {
                numberOfEmployees++;
            }
        }
        return sumOfSalaries / numberOfEmployees;
    }
    public void indexSalaries_Department(int department, double percent) {
        if (department < 1 || department > 5) {
            throw new IllegalArgumentException("Недопустимый номер отдела");
        }
        for (Employee employee : employeeBook) {
            if (employee == null) {
                break;
            }
            if (employee.getDepartment() == department) {
                employee.setSalary(employee.getSalary() + employee.getSalary() / 100 * percent);
            }
        }
    }

    public void printDepartmentEmployees(int department) {
        if (department < 1 || department > 5) {
            throw new IllegalArgumentException("Недопустимый номер отдела");
        }
        if (employeeBook[0] == null) {
            System.out.println("Книга учёта сотрудников пуста.");
        }
        int numberOfEmployees = 0;
        for (Employee employee : employeeBook) {
            if (employee == null) {
                break;
            }
            if (employee.getDepartment() == department) {
                System.out.println(employee.displayWithoutDepartment());
                numberOfEmployees++;
            }
        }
        if (numberOfEmployees == 0) {
            System.out.printf("В отделе №%s нет сотрудников.%n", department);
        }
    }

    public void printWhoIsBelow(double salary) {
        for (Employee employee : employeeBook) {
            if (employee == null) {
                break;
            }
            if (employee.getSalary() < salary) {
                System.out.println(employee.displayWithoutDepartment());
            }
        }
    }
    public void printWhoIsAbove(double salary) {
        for (Employee employee : employeeBook) {
            if (employee == null) {
                break;
            }
            if (employee.getSalary() >= salary) {
                System.out.println(employee.displayWithoutDepartment());
            }
        }
    }
}
