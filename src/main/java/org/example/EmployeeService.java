package org.example;

import java.util.List;

public interface EmployeeService {
    public String getEmployeeInfo(Employee employee);
    public void performDuties(Employee employee);
    public void changeName(Employee employee, String newName);
    public void changeAge(Employee employee, int newAge);
    public void fireEmployee(List<Employee> employeeList, Employee employee);
    public void calculateBonus(Employee employee);
    public  void evaluatePerformance(Employee employee, int performanceScore);
    public void transferDepartment(Employee employee, String newDepartment);
    public void listAllEmployees(List<Employee> employees);
    public Employee findEmployeeByName(List<Employee> employees, String name);

}
