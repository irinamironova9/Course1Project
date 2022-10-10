public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();

        employeeBook.addEmployee("Сидорова Анна Ивановна", 3, 75_000);
        employeeBook.addEmployee("Иванов Борис Фёдорович", 5, 68_000);
        employeeBook.addEmployee("Ковальская Ольга Алексеевна", 1, 100_000);
        employeeBook.addEmployee("Гарибян Зоя Тиграновна", 2, 83_000);
        employeeBook.addEmployee("Джон Браун", 4, 80_000);
        employeeBook.addEmployee("Танака Кадзуо", 4, 95_000);
        employeeBook.addEmployee("Ли Чэньюй", 3, 66_000);
        employeeBook.addEmployee("Кузнецов Олег Дмитриевич", 2, 90_000);
        employeeBook.addEmployee("Норма Джин Бейкер", 3, 94_000);
        employeeBook.addEmployee("Васильев Пётр Иванович", 1, 89_000);

        System.out.println("В книге учёта сотрудников записано " + employeeBook.getFilledIn() + " человек.");
        printDivider();

        employeeBook.printAllEmployees();
        printDivider();

        employeeBook.removeEmployee("Сидорова Анна Ивановна");
        employeeBook.removeEmployee(8);

        Employee[] forTestingCode = employeeBook.getEmployeeBook();
        System.out.println(forTestingCode[0]);
        System.out.println(forTestingCode[6]);
        System.out.println(forTestingCode[7]);
        System.out.println(forTestingCode[8]);
        System.out.println(forTestingCode[9]);
        printDivider();
        employeeBook.printAllEmployees();
        printDivider();

        employeeBook.editDepartment("Джон Браун", 5);
        employeeBook.printOnlyDepartmentEmployees(5);
        printDivider();

        employeeBook.editSalary("Ли Чэньюй", 70_000);
        employeeBook.printOnlyDepartmentEmployees(3);
        printDivider();

        System.out.printf("Всего за историю компании в ней работало %s человек.%n", Employee.getCounter() - 1);
        printDivider();

        double sumOfSalaries = employeeBook.calculateSumOfSalaries();
        System.out.printf("Сумма зарплат за месяц = %.2f рублей.%n", sumOfSalaries);
        printDivider();

        employeeBook.findLowestSalaryEmployee();
        employeeBook.findHighestSalaryEmployee();
        printDivider();

        System.out.printf("Средняя зарплата среди всех сотрудников = %.2f рублей.%n", employeeBook.calculateAverageSalary());
        printDivider();

        employeeBook.printNames();
        printDivider();

        employeeBook.indexSalaries(2.5);
        employeeBook.printAllEmployees();
        printDivider();

        employeeBook.findLowSalEmployee_Department(3);
        employeeBook.findHighSalEmployee_Department(3);
        employeeBook.findLowSalEmployee_Department(5);
        employeeBook.findHighSalEmployee_Department(5);
        printDivider();

        System.out.printf("Сумма зарплат по отделу №%s за месяц = %.2f рублей.%n", 1, employeeBook.calculateSumOfSalaries_Department(1));
        System.out.printf("Средняя зарплата по отделу №%s = %.2f рублей.%n", 1, employeeBook.calculateAverageSalary_Department(1));
        printDivider();

        employeeBook.indexSalaries_Department(5, 8);
        employeeBook.printOnlyDepartmentEmployees(5);
        printDivider();

        employeeBook.printWhoIsBelow(95_000);
        printDivider();

        employeeBook.printWhoIsAbove(95_000);
        printDivider();

        employeeBook.printAllByDepartment();
    }

    public static void printDivider() {
        System.out.println("-----");
    }
}