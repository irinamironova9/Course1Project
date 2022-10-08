public class Main {
    public static void main(String[] args) {
        Employee[] employeesBook = new Employee[10];

        Employee anna = new Employee("Сидорова Анна Ивановна", 3, 85_000d);
        addEmployee(employeesBook, anna);

        Employee boris = new Employee("Иванов Борис Фёдорович", 5, 50_000d);
        addEmployee(employeesBook, boris);

        Employee olga = new Employee("Потапова Ольга Алексеевна", 1, 100_000d);
        addEmployee(employeesBook, olga);

        printAllEmployees(employeesBook);

        double sumOfSalaries = calculateSumOfSalaries(employeesBook);
        System.out.printf("Сумма зарплат за месяц = %.2f рублей.%n", sumOfSalaries);

        findLowestSalaryEmployee(employeesBook);
        findHighestSalaryEmployee(employeesBook);
    }

    public static void printAllEmployees(Employee[] employeesBook) {
        for (Employee employee : employeesBook) {
            System.out.println(employee);
        }
    }

    public static void addEmployee(Employee[] employeesBook, Employee employee) {
        if (employee.getId() > employeesBook.length) {
            throw new RuntimeException("В этой книге закончилось место для записи новых сотрудников.");
        }
        employeesBook[employee.getId() - 1] = employee;
    }

    public static double calculateSumOfSalaries(Employee[] employeesBook) {
        double sumOfSalaries = 0;
        for (Employee employee : employeesBook) {
            if (employee == null) {
                break;
            }
            sumOfSalaries += employee.getSalary();
        }
        return sumOfSalaries;
    }

    public static void findLowestSalaryEmployee(Employee[] employeesBook) {
        if (employeesBook[0] == null) {
            throw new RuntimeException("Книга учёта сотрудников пуста.");
        }
        double lowestSalary = Double.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < employeesBook.length; i++) {
            if (employeesBook[i] == null) {
                break;
            }
            if (employeesBook[i].getSalary() < lowestSalary) {
                lowestSalary = employeesBook[i].getSalary();
                index = i;
            }
        }
        System.out.printf("Сотрудник с минимальной зарплатой в %.2f рублей - %s.%n", lowestSalary, employeesBook[index].getFullName());
    }
    public static void findHighestSalaryEmployee(Employee[] employeesBook) {
        if (employeesBook[0] == null) {
            throw new RuntimeException("Книга учёта сотрудников пуста.");
        }
        double highestSalary = Double.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < employeesBook.length; i++) {
            if (employeesBook[i] == null) {
                break;
            }
            if (employeesBook[i].getSalary() > highestSalary) {
                highestSalary = employeesBook[i].getSalary();
                index = i;
            }
        }
        System.out.printf("Сотрудник с максимальной зарплатой в %.2f рублей - %s.%n", highestSalary, employeesBook[index].getFullName());
    }
}