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

}