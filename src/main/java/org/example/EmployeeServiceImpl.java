package org.example;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    public String getEmployeeInfo(Employee employee){
        //Grąžinkite informaciją apie darbuotoją kaip String (pvz., "Name: John, Age: 30, Salary: 5000").
        return "Name: " + employee.getName() + ", Age:" + employee.getAge() + ", Salary: " + employee.getSalary();
    }

    public void performDuties(Employee employee){
        System.out.print(employee.getName()+ " ");
        if(employee instanceof Manager){
            if(((Manager) employee).getTeamSize() > 10) System.out.println("Valdo didelę komandą.");
            else System.out.println("Valdo mažą komandą.");
        } else if(employee instanceof Developer){
            if(((Developer) employee).progrLang.equals("Java"))
                System.out.println("Yra " + ((Developer) employee).progrLang + " programuotojas, uždirba " + employee.getSalary());
            else if(((Developer) employee).progrLang.equals("C#"))
                System.out.println("Yra " + ((Developer) employee).progrLang + " programuotojas, uždirba " + employee.getSalary());
            else System.out.println("Yra " + ((Developer) employee).progrLang + " programuotojas, uždirba " + employee.getSalary());
        }
    }

    public void promoteEmployee(Employee employee){
        if(employee instanceof Manager){
            ((Manager) employee).setTeamSize(((Manager) employee).getTeamSize() + 1);
            if(((Manager) employee).getTeamSize() > 15) ((Manager) employee).setSalary(((Manager) employee).getSalary()*1.1);
        } else if(employee instanceof Developer){
            switch (((Developer) employee).progrLang) {
                case "C#":
                    ((Developer) employee).setSalary(((Developer) employee).getSalary()*1.07);
                    break;
                case "Java":
                    ((Developer) employee).setSalary(((Developer) employee).getSalary()*1.12);
                    break;
                default:
                    break;
            }
        }
    }

    public void changeName(Employee employee, String newName){
        employee.setName(newName);
    }

    public void changeAge(Employee employee, int newAge){
        employee.setAge(newAge);
    }

    public void fireEmployee(List<Employee> employeeList, Employee employee){
        //if(employee != null) employeeList.remove(employee);
        employeeList.remove(employee);
    }

    public void calculateBonus(Employee employee){
        if(employee instanceof Manager) {
            ((Manager) employee).setSalary(((Manager) employee).getSalary() * 1.10);
            return;
        }
        if(employee instanceof Developer) {
            ((Developer) employee).setSalary(((Developer) employee).getSalary() * 1.05);
            return;
        }
        employee.setSalary(employee.getSalary() * 1.03);
    }

    public  void evaluatePerformance(Employee employee, int performanceScore){
        if(performanceScore >= 9) {
            employee.setSalary(employee.getSalary() * 1.10);
            return;
        }
        if(performanceScore >= 7) {
            employee.setSalary(employee.getSalary() * 1.05);
            return;
        }
        System.out.println("Darbuotojo veikla nepatenkinama.");
    }

    public void transferDepartment(Employee employee, String newDepartment){
        employee.setDepartment(newDepartment);
    }

    public void listAllEmployees(List<Employee> employees){
        for(Employee item: employees){
            if(item instanceof Manager) {
                String temp = String.format("%.2f", ((Manager) item).getSalary());
                System.out.println("Vardas: " + ((Manager) item).getName() +
                        ", amžius " + ((Manager) item).getAge() +
                        ", uždarbis " + temp +
                        ", departamentas " + ((Manager) item).getDepartment() +
                        ", komandos dydis " + ((Manager) item).getTeamSize());;
            } else if(item instanceof Developer) {
                String temp = String.format("%.2f", ((Developer) item).getSalary());
                System.out.println("Vardas: " + ((Developer) item).getName() +
                        ", amžius " + ((Developer) item).getAge() +
                        ", uždarbis " + temp +
                        ", departamentas " + ((Developer) item).getDepartment() +
                        ", programavimo kalba " + ((Developer) item).getProgrLang());;
            }
        }
    }

    public Employee findEmployeeByName(List<Employee> employees, String name){
        for(Employee item: employees){
            if(item.getName().equals(name)) return item;
        }
        return null;
    }

}

