package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();


    @Test
    public void getEmployeeInfoToString(){
        //Arrange
        Employee employee = new Manager("Manager1", 45, 2900.00, "marketing",15);
        String employeeInfoString = "Name: " + employee.getName() + ", Age:" + employee.getAge() + ", Salary: " + employee.getSalary();
        var employeeServiceImpl = new EmployeeServiceImpl();
        //Execute
        //Assert
        assertEquals(employeeInfoString, employeeServiceImpl.getEmployeeInfo(employee));
    }

    @Test
    public void performDutiesByManagerBigTeam(){
        //Setup
        System.setOut(new PrintStream(outputStreamCaptor));
        Employee employee = new Manager("Manager1", 45, 2900.00, "marketing",15);
        String expectedString = employee.getName() + " Valdo didelę komandą.\r\n";
        var employeeServiceImpl = new EmployeeServiceImpl();
        //Execute
        employeeServiceImpl.performDuties(employee);
        //Assert
        assertEquals(expectedString, outputStreamCaptor.toString());
        System.setOut(standardOut);
    }

    @Test
    public void performDutiesByDeveloperJava(){
        //Setup
        System.setOut(new PrintStream(outputStreamCaptor));
        Employee employee = new Developer("Developer3", 39, 3900.00, "information technology","Java");
        String expectedString = employee.getName() + " Yra Java programuotojas, uždirba " + employee.getSalary() + "\r\n";
        var employeeServiceImpl = new EmployeeServiceImpl();
        //Execute
        employeeServiceImpl.performDuties(employee);
        //Assert
        assertEquals(expectedString, outputStreamCaptor.toString());
        System.setOut(standardOut);
    }


    @Test
    public void promoteManagerThanTeamGreater15plus1(){
        //Setup
        var employeeServiceImpl = new EmployeeServiceImpl();
        Employee employee = new Manager("Manager1", 45, 2900.00, "marketing",15);
        double salary = 2900.00 * 1.10;
        //Execute
        employeeServiceImpl.promoteEmployee(employee);
        //Assert
        assertEquals(salary, employee.getSalary());
    }

    @Test
    public void doNotpromoteManagerThanTeamSmaller10(){
        //Setup
        var employeeServiceImpl = new EmployeeServiceImpl();
        Employee employee = new Manager("Manager1", 45, 2900.00, "marketing",9);
        double salary = 2900.00;
        //Execute
        employeeServiceImpl.promoteEmployee(employee);
        //Assert
        assertEquals(salary, employee.getSalary());
    }

    @Test
    public void promoteDeveloperThanProgrammingLanguageJava(){
        //Setup
        var employeeServiceImpl = new EmployeeServiceImpl();
        Employee employee = new Developer("Developer1", 25, 1200.00, "information technology","Java");
        double salary = 1200.00 * 1.12;
        //Execute
        employeeServiceImpl.promoteEmployee(employee);
        //Assert
        assertEquals(salary, employee.getSalary());
    }

    @Test
    public void changeNameForDeveloper(){
        //Setup
        var employeeServiceImpl = new EmployeeServiceImpl();
        Employee employee = new Developer("Developer2", 19, 750.00, "information technology","C#");
        String expName = "Developer10";
        //Execute
        employeeServiceImpl.changeName(employee, expName);
        //Assert
        assertEquals(expName, employee.getName());
    }

    @Test
    public void changeNameForManager(){
        //Setup
        var employeeServiceImpl = new EmployeeServiceImpl();
        Employee employee = new Manager("Manager2", 32, 1900.00, "operations management",5);
        String expName = "Manager9";
        //Execute
        employeeServiceImpl.changeName(employee, expName);
        //Assert
        assertEquals(expName, employee.getName());
    }

    @Test
    public void changeAgeForDeveloper(){
        //Setup
        var employeeServiceImpl = new EmployeeServiceImpl();
        Employee employee = new Developer("Developer2", 19, 750.00, "information technology","C#");
        int expAge = 25;
        //Execute
        employeeServiceImpl.changeAge(employee, expAge);
        //Assert
        assertEquals(expAge, employee.getAge());
    }

    @Test
    public void changeAgeForManager(){
        //Setup
        var employeeServiceImpl = new EmployeeServiceImpl();
        Employee employee = new Manager("Manager1", 45, 2900.00, "marketing",15);
        int expAge = 49;
        //Execute
        employeeServiceImpl.changeAge(employee, expAge);
        //Assert
        assertEquals(expAge, employee.getAge());
    }

    @Test
    public void fireEmployeeFromEmployeeList(){
        //Setup
        var employeeServiceImpl = new EmployeeServiceImpl();
        List<Employee> employeeList = new ArrayList<>();
        Employee employee1 =new Manager("Manager1", 45, 2900.00, "marketing",15);
        Employee employee2 = new Developer("Developer4", 32, 2500.00, "information technology","C++");
        employeeList.add(employee1);
        employeeList.add(employee2);
        //Execute
        employeeServiceImpl.fireEmployee(employeeList, employee2);
        //Assert
        assertEquals(false, employeeList.contains(employee2));
    }

    @Test
    public void tryfireNullEmployeeFromEmployeeListContainsNullEmployee(){
        //Setup
        var employeeServiceImpl = new EmployeeServiceImpl();
        List<Employee> employeeList = new ArrayList<>();
        Employee employee1 =new Manager("Manager1", 45, 2900.00, "marketing",15);
        Employee employee2 = null;
        employeeList.add(employee1);
        employeeList.add(employee2);
        //Execute
        employeeServiceImpl.fireEmployee(employeeList, employee2);
        //Assert
        assertEquals(false, employeeList.contains(employee2));
    }

    @Test
    public void calculateBonusForManager(){
        //Setup
        Employee employee = new Manager("Manager1", 45, 2900.00, "marketing",15);
        var employeeServiceImpl = new EmployeeServiceImpl();
        double newSalary = employee.getSalary() * 1.10;
        //Execute
        employeeServiceImpl.calculateBonus(employee);
        //Assert
        assertEquals(newSalary, employee.getSalary());
    }

    @Test
    public void calculateBonusForDeveloper(){
        //Setup
        Employee employee = new Developer("Developer3", 39, 3900.00, "information technology","Java");
        var employeeServiceImpl = new EmployeeServiceImpl();
        double newSalary = employee.getSalary() * 1.05;
        //Execute
        employeeServiceImpl.calculateBonus(employee);
        //Assert
        assertEquals(newSalary, employee.getSalary());
    }

    @Test
    public  void evaluatePerformanceThanEaqual9(){
        //Setup
        Employee employee =new Developer("Developer2", 19, 750.00, "information technology","C#");
        var employeeServiceImpl = new EmployeeServiceImpl();
        int performance = 9;
        double newSalary = employee.getSalary() * 1.10;
        //Execute
        employeeServiceImpl.evaluatePerformance(employee, performance);
        //Assert
        assertEquals(newSalary, employee.getSalary());
    }

    @Test
    public  void evaluatePerformanceLessThan7(){
        //Setup
        System.setOut(new PrintStream(outputStreamCaptor));
        Employee employee =new Developer("Developer2", 19, 750.00, "information technology","C#");
        var employeeServiceImpl = new EmployeeServiceImpl();
        String expectedString = "Darbuotojo veikla nepatenkinama.\r\n";
        int performance = 6;
        //Execute
        employeeServiceImpl.evaluatePerformance(employee, performance);
        //Assert
        assertEquals(expectedString, outputStreamCaptor.toString());
        System.setOut(standardOut);
    }

    @Test
    public void transferEmployeeToNewDepartment (){
        //Setup
        Employee employee = new Developer("Developer1", 25, 1200.00, "information technology","Java");
        var employeeServiceImpl = new EmployeeServiceImpl();
        String newDepartment = "operations management";
        //Execute
        employeeServiceImpl.transferDepartment(employee, newDepartment);
        //Assert
        assertEquals(newDepartment, employee.getDepartment());
    }

    @Test
    public void listAllEmployeesFromEmployeesList (){
        //Setup
        System.setOut(new PrintStream(outputStreamCaptor));
        Employee employee1 =new Developer("Developer2", 19, 750.00, "information technology","C#");
        Employee employee2 =new Manager("Manager1", 45, 2900.00, "marketing",15);
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add(employee2);
        var employeeServiceImpl = new EmployeeServiceImpl();

        String tempDvlp = String.format("%.2f", ((Developer) employeeList.get(0)).getSalary());
        String expectedString = ("Vardas: " + employeeList.get(0).getName() +
                ", amžius " + employeeList.get(0).getAge() +
                ", uždarbis " + tempDvlp +
                ", departamentas " + employeeList.get(0).getDepartment() +
                ", programavimo kalba " + ((Developer) employeeList.get(0)).getProgrLang()) + "\r\n";

        String tempMng = String.format("%.2f", ((Manager) employeeList.get(1)).getSalary());
        expectedString += ("Vardas: " + employeeList.get(1).getName() +
                ", amžius " + employeeList.get(1).getAge() +
                ", uždarbis " + tempMng +
                ", departamentas " + employeeList.get(1).getDepartment() +
                ", komandos dydis " + ((Manager) employeeList.get(1)).getTeamSize()) + "\r\n";

        //Execute
        employeeServiceImpl.listAllEmployees(employeeList);
        //Assert
        assertEquals(expectedString, outputStreamCaptor.toString());
        System.setOut(standardOut);
    }

    @Test
    public void findEmployeeByNameInEmployeesList () {
        //Setup
        Employee employee1 =new Developer("Developer2", 19, 750.00, "information technology","C#");
        Employee employee2 =new Manager("Manager1", 45, 2900.00, "marketing",15);
        Employee employee3 = new Developer("Developer1", 25, 1200.00, "information technology","Java");
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        var employeeServiceImpl = new EmployeeServiceImpl();
        String searchName = "Developer1";
        //Assert
        assertEquals(employee3, employeeServiceImpl.findEmployeeByName(employeeList, searchName));
    }

    @Test
    public void findEmployeeByNameInEmployeesListWhenEmployeeNotFound () {
        //Setup
        Employee employee1 =new Developer("Developer2", 19, 750.00, "information technology","C#");
        Employee employee2 =new Manager("Manager1", 45, 2900.00, "marketing",15);
        Employee employee3 = new Developer("Developer1", 25, 1200.00, "information technology","Java");
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        var employeeServiceImpl = new EmployeeServiceImpl();
        String searchName = "Developer10";
        //Assert
        assertEquals(null, employeeServiceImpl.findEmployeeByName(employeeList, searchName));
    }

}