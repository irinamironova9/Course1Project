public class Main {
    public static void main(String[] args) {
        Employee[] employeesBook = new Employee[10];

        Employee anna = new Employee("Сидорова Анна Ивановна", 3, 85_000d);
        addEmployee(employeesBook, anna);

        Employee boris = new Employee("Иванов Борис Фёдорович", 5, 70_000d);
        addEmployee(employeesBook, boris);

        Employee olga = new Employee("Потапова Ольга Алексеевна", 1, 100_000d);
        addEmployee(employeesBook, olga);

        printAllEmployees(employeesBook);

        olga.setDepartment(2);
        System.out.printf("Теперь %s работает в отделе №%s.%n", olga.getFullName(), olga.getDepartment());

        boris.setSalary(80_000);
        System.out.printf("Теперь %s получает %.2f рублей в месяц.%n", boris.getFullName(), boris.getSalary());

        double sumOfSalaries = calculateSumOfSalaries(employeesBook);
        System.out.printf("Сумма зарплат за месяц = %.2f рублей.%n", sumOfSalaries);

        findLowestSalaryEmployee(employeesBook);
        findHighestSalaryEmployee(employeesBook);

        System.out.printf("Средняя зарплата среди всех сотрудников = %.2f рублей.%n", calculateAverageSalary(employeesBook));

        printNames(employeesBook);

        indexSalaries(employeesBook, 2.5);
        printAllEmployees(employeesBook);

        findLowSalEmployee_Department(employeesBook, 2);
        findHighSalEmployee_Department(employeesBook, 4);

        System.out.printf("Сумма зарплат по отделу №%s за месяц = %.2f рублей.%n", 3, calculateSumOfSalaries_Department(employeesBook, 3));
        System.out.printf("Средняя зарплата по отделу №%s = %.2f рублей.%n", 3, calculateAverageSalary_Department(employeesBook, 3));
        indexSalaries_Department(employeesBook, 5, 8);
        printAllEmployees(employeesBook);

        printDepartmentEmployees(employeesBook, 2);

        System.out.println(" --- ");
        printWhoIsBelow(employeesBook, 100_000);
        System.out.println(" --- ");
        printWhoIsAbove(employeesBook, 100_000);
    }

    public static void printAllEmployees(Employee[] employeesBook) {
        if (employeesBook[0] == null) {
            System.out.println("Книга учёта сотрудников пуста.");
        }
        for (Employee employee : employeesBook) {
            if (employee == null) {
                break;
            }
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
        if (employeesBook[0] == null) {
            throw new RuntimeException("Книга учёта сотрудников пуста.");
        }
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

    public static double calculateAverageSalary(Employee[] employeesBook) {
        double sumOfSalaries = calculateSumOfSalaries(employeesBook);
        return sumOfSalaries / (Employee.getCOUNTER() - 1);
    }

    public static void printNames(Employee[] employeesBook) {
        if (employeesBook[0] == null) {
            System.out.println("Книга учёта сотрудников пуста.");
        }
        for (Employee employee : employeesBook) {
            if (employee == null) {
                break;
            }
            System.out.println(employee.getFullName());
        }
    }

    public static void indexSalaries(Employee[] employeesBook, double percent) {
        for (Employee employee : employeesBook) {
            if (employee == null) {
                break;
            }
            employee.setSalary(employee.getSalary() + employee.getSalary() / 100 * percent);
        }
    }
    public static void findLowSalEmployee_Department(Employee[] employeesBook, int department) {
        if (department < 1 || department > 5) {
            throw new IllegalArgumentException("Недопустимый номер отдела");
        }
        if (employeesBook[0] == null) {
            throw new RuntimeException("Книга учёта сотрудников пуста.");
        }
        double lowestSalary = Double.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < employeesBook.length; i++) {
            if (employeesBook[i] == null) {
                break;
            }
            if (employeesBook[i].getDepartment() == department) {
                if (employeesBook[i].getSalary() < lowestSalary) {
                    lowestSalary = employeesBook[i].getSalary();
                    index = i;
                }
            }
        }
        if (index == -1) {
            System.out.printf("В отделе №%s нет сотрудников.%n", department);
        } else {
            System.out.printf("Сотрудник с минимальной по отделу №%s зарплатой в размере %.2f рублей - %s.%n", department, lowestSalary, employeesBook[index].getFullName());
        }
    }
    public static void findHighSalEmployee_Department(Employee[] employeesBook, int department) {
        if (department < 1 || department > 5) {
            throw new IllegalArgumentException("Недопустимый номер отдела");
        }
        if (employeesBook[0] == null) {
            throw new RuntimeException("Книга учёта сотрудников пуста.");
        }
        double highestSalary = 0;
        int index = -1;
        for (int i = 0; i < employeesBook.length; i++) {
            if (employeesBook[i] == null) {
                break;
            }
            if (employeesBook[i].getDepartment() == department) {
                if (employeesBook[i].getSalary() > highestSalary) {
                    highestSalary = employeesBook[i].getSalary();
                    index = i;
                }
            }
        }
        if (index == -1) {
            System.out.printf("В отделе №%s нет сотрудников.%n", department);
        } else {
            System.out.printf("Сотрудник с максимальной по отделу №%s зарплатой в размере %.2f рублей - %s.%n", department, highestSalary, employeesBook[index].getFullName());
        }
    }
    public static double calculateSumOfSalaries_Department(Employee[] employeesBook, int department) {
        if (department < 1 || department > 5) {
            throw new IllegalArgumentException("Недопустимый номер отдела");
        }
        if (employeesBook[0] == null) {
            throw new RuntimeException("Книга учёта сотрудников пуста.");
        }
        double sumOfSalaries = 0;
        int numberOfEmployees = 0;
        for (Employee employee : employeesBook) {
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
    public static double calculateAverageSalary_Department(Employee[] employeesBook, int department) {
        if (department < 1 || department > 5) {
            throw new IllegalArgumentException("Недопустимый номер отдела");
        }
        if (employeesBook[0] == null) {
            throw new RuntimeException("Книга учёта сотрудников пуста.");
        }
        double sumOfSalaries = calculateSumOfSalaries_Department(employeesBook, department);
        int numberOfEmployees = 0;
        for (Employee employee : employeesBook) {
            if (employee == null) {
                break;
            }
            if (employee.getDepartment() == department) {
                numberOfEmployees++;
            }
        }
        return sumOfSalaries / numberOfEmployees;
    }
    public static void indexSalaries_Department(Employee[] employeesBook, int department, double percent) {
        if (department < 1 || department > 5) {
            throw new IllegalArgumentException("Недопустимый номер отдела");
        }
        for (Employee employee : employeesBook) {
            if (employee == null) {
                break;
            }
            if (employee.getDepartment() == department) {
                employee.setSalary(employee.getSalary() + employee.getSalary() / 100 * percent);
            }
        }
    }

    public static void printDepartmentEmployees(Employee[] employeesBook, int department) {
        if (department < 1 || department > 5) {
            throw new IllegalArgumentException("Недопустимый номер отдела");
        }
        if (employeesBook[0] == null) {
            System.out.println("Книга учёта сотрудников пуста.");
        }
        int numberOfEmployees = 0;
        for (Employee employee : employeesBook) {
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

    public static void printWhoIsBelow(Employee[] employeesBook, double salary) {
        for (Employee employee : employeesBook) {
            if (employee == null) {
                break;
            }
            if (employee.getSalary() < salary) {
                System.out.println(employee.displayWithoutDepartment());
            }
        }
    }
    public static void printWhoIsAbove(Employee[] employeesBook, double salary) {
        for (Employee employee : employeesBook) {
            if (employee == null) {
                break;
            }
            if (employee.getSalary() >= salary) {
                System.out.println(employee.displayWithoutDepartment());
            }
        }
    }
}