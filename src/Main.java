public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();

        employeeBook.addEmployee("Сидорова Анна Ивановна", 3, 75_000);
        employeeBook.addEmployee("Иванов Борис Фёдорович", 5, 68_000);
        employeeBook.addEmployee("Ковальская Ольга Алексеевна", 1, 100_000);
        employeeBook.addEmployee("Гарибян Зоя Тиграновна", 2, 83_000);
        employeeBook.addEmployee("Джон Браун", 4, 80_000);
        employeeBook.addEmployee("Танака Кадзуо", 4, 95_000);
        employeeBook.addEmployee("Ли Чэньюй", 3, 68_000);
        employeeBook.addEmployee("Кузнецов Олег Дмитриевич", 2, 90_000);

        employeeBook.printAllEmployees();

        double sumOfSalaries = employeeBook.calculateSumOfSalaries();
        System.out.printf("Сумма зарплат за месяц = %.2f рублей.%n", sumOfSalaries);

        employeeBook.findLowestSalaryEmployee();
        employeeBook.findHighestSalaryEmployee();

        System.out.printf("Средняя зарплата среди всех сотрудников = %.2f рублей.%n", employeeBook.calculateAverageSalary());

        employeeBook.printNames();

        employeeBook.indexSalaries(2.5);
        employeeBook.printAllEmployees();

        employeeBook.findLowSalEmployee_Department(2);
        employeeBook.findHighSalEmployee_Department(4);

        System.out.printf("Сумма зарплат по отделу №%s за месяц = %.2f рублей.%n", 3, employeeBook.calculateSumOfSalaries_Department(3));
        System.out.printf("Средняя зарплата по отделу №%s = %.2f рублей.%n", 3, employeeBook.calculateAverageSalary_Department(3));
        employeeBook.indexSalaries_Department(5, 8);
        employeeBook.printAllEmployees();

        employeeBook.printDepartmentEmployees(2);

        System.out.println(" --- ");
        employeeBook.printWhoIsBelow(80_000);
        System.out.println(" --- ");
        employeeBook.printWhoIsAbove(80_000);
        System.out.println(" --- ");

        employeeBook.printByDepartment();
    }
}