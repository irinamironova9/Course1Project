public class EmployeeBook {
    private final Employee[] employeeBook;
    private int filledIn;

    public EmployeeBook() {
        this.employeeBook = new Employee[10];
    }

    public int getFilledIn() {
        return filledIn;
    }

    public void checkEmployeeBookIsNotEmpty() {
        if (filledIn == 0) {
            throw new RuntimeException("Эта книга учёта сотрудников пуста.");
        }
    }

    public void addEmployee(String fullName, int department, double salary) {
        if (filledIn == employeeBook.length) {
            throw new RuntimeException("В этой книге закончилось место для записи новых сотрудников.");
        }
        Employee employee = new Employee(fullName, department, salary);
        employeeBook[filledIn] = employee;
        filledIn++;
    }

    public void removeEmployee(String fullName) {
        for (int i = 0; i < filledIn; i++) {
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

    public void editDepartment(String fullName, int department) {
        Employee.checkDepartmentIsAcceptable(department);
        for (Employee employee : employeeBook) {
            if (employee.getFullName().equals(fullName)) {
                employee.setDepartment(department);
                break;
            }
        }
    }

    public void editSalary(String fullName, double salary) {
        Employee.checkSalaryIsAcceptable(salary);
        for (Employee employee : employeeBook) {
            if (employee.getFullName().equals(fullName)) {
                employee.setSalary(salary);
                break;
            }
        }
    }

    public void printAllEmployees() {
        if (filledIn == 0) {
            System.out.println("Эта книга учёта сотрудников пуста.");
        }
        for (Employee employee : employeeBook) {
            if (employee == null) {
                break;
            }
            System.out.println(employee);
        }
    }

    public void printNames() {
        if (filledIn == 0) {
            System.out.println("Эта книга учёта сотрудников пуста.");
        }
        for (Employee employee : employeeBook) {
            if (employee == null) {
                break;
            }
            System.out.println(employee.getFullName());
        }
    }

    public void printWhoIsBelow(double salary) {
        Employee.checkSalaryIsAcceptable(salary);
        int numberOfEmployees = 0;
        for (Employee employee : employeeBook) {
            if (employee == null) {
                break;
            }
            if (employee.getSalary() < salary) {
                System.out.println(employee.displayWithoutDepartment());
                numberOfEmployees++;
            }
        }
        if (numberOfEmployees == 0) {
            System.out.printf("Ниже зарплаты в %.2f руб/мес никто не получает.%n", salary);
        }
    }
    public void printWhoIsAbove(double salary) {
        Employee.checkSalaryIsAcceptable(salary);
        int numberOfEmployees = 0;
        for (Employee employee : employeeBook) {
            if (employee == null) {
                break;
            }
            if (employee.getSalary() >= salary) {
                System.out.println(employee.displayWithoutDepartment());
                numberOfEmployees++;
            }
        }
        if (numberOfEmployees == 0) {
            System.out.printf("Выше зарплаты в %.2f руб/мес никто не получает.%n", salary);
        }
    }

    public void findLowestSalaryEmployee() {
        checkEmployeeBookIsNotEmpty();
        double lowestSalary = Double.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < filledIn; i++) {
            if (employeeBook[i].getSalary() < lowestSalary) {
                lowestSalary = employeeBook[i].getSalary();
                index = i;
            }
        }
        System.out.printf("Сотрудник с минимальной зарплатой в %.2f рублей - %s.%n", lowestSalary, employeeBook[index].getFullName());
    }

    public void findHighestSalaryEmployee() {
        checkEmployeeBookIsNotEmpty();
        double highestSalary = -1;
        int index = -1;
        for (int i = 0; i < filledIn; i++) {
            if (employeeBook[i].getSalary() > highestSalary) {
                highestSalary = employeeBook[i].getSalary();
                index = i;
            }
        }
        System.out.printf("Сотрудник с максимальной зарплатой в %.2f рублей - %s.%n", highestSalary, employeeBook[index].getFullName());
    }

    public double calculateSumOfSalaries() {
        checkEmployeeBookIsNotEmpty();
        double sumOfSalaries = 0;
        for (Employee employee : employeeBook) {
            if (employee == null) {
                break;
            }
            sumOfSalaries += employee.getSalary();
        }
        return sumOfSalaries;
    }

    public double calculateAverageSalary() {
        return calculateSumOfSalaries() / filledIn;
    }

    public void indexSalaries(double percent) {
        for (Employee employee : employeeBook) {
            if (employee == null) {
                break;
            }
            employee.setSalary(employee.getSalary() + employee.getSalary() / 100 * percent);
        }
    }

    // Методы для работы с отделами:

    public void printAllByDepartment() {
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

    public void printOnlyDepartmentEmployees(int department) {
        Employee.checkDepartmentIsAcceptable(department);
        if (filledIn == 0) {
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

    public void findLowSalEmployee_Department(int department) {
        Employee.checkDepartmentIsAcceptable(department);
        checkEmployeeBookIsNotEmpty();
        double lowestSalary = Double.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < filledIn; i++) { //
            if (employeeBook[i].getDepartment() == department) {
                if (employeeBook[i].getSalary() < lowestSalary) {
                    lowestSalary = employeeBook[i].getSalary();
                }
                index = i;
            }
        }
        if (index == -1) {
            System.out.printf("В отделе №%s нет сотрудников.%n", department);
        } else {
            System.out.printf("Сотрудник с минимальной по отделу №%s зарплатой в размере %.2f рублей - %s.%n", department, lowestSalary, employeeBook[index].getFullName());
        }
    }

    public void findHighSalEmployee_Department(int department) {
        Employee.checkDepartmentIsAcceptable(department);
        checkEmployeeBookIsNotEmpty();
        double highestSalary = -1;
        int index = -1;
        for (int i = 0; i < filledIn; i++) {
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
        Employee.checkDepartmentIsAcceptable(department);
        checkEmployeeBookIsNotEmpty();
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
        Employee.checkDepartmentIsAcceptable(department);
        checkEmployeeBookIsNotEmpty();
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
        Employee.checkDepartmentIsAcceptable(department);
        checkEmployeeBookIsNotEmpty();
        for (Employee employee : employeeBook) {
            if (employee == null) {
                break;
            }
            if (employee.getDepartment() == department) {
                employee.setSalary(employee.getSalary() + employee.getSalary() / 100 * percent);
            }
        }
    }
}
