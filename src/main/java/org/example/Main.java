package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        Turėtų bazinę klasę Employee su savybėmis Name, Age ir Salary, bei metodą Work().
//        Sukurtų dvi paveldėtas klases: Manager ir Developer.
//        Manager klasė turi turėti papildomą savybę TeamSize ir perrašytą metodą Work().
//        Developer klasė turi turėti papildomą savybę ProgrammingLanguage ir perrašytą metodą Work().
//        Sukurtų sąrašą Employee objektų, kuriame būtų tiek Manager, tiek Developer objektai.
//        Naudotų ciklą, kuris iteruoja per sąrašą ir patikrina objektų tipus naudojant operatorių kuris paima objekto tipą.
//        Naudotų sudėtingesnes sąlygas objektų apdorojimui:
//        Jei objektas yra Manager, patikrinkite jo TeamSize. Jei komandos dydis didesnis nei 10, išveskite pranešimą,
//        kad valdo didelę komandą, kitu atveju - kad valdo mažą komandą.
//        Jei objektas yra Developer, patikrinkite jo ProgrammingLanguage. Jei programavimo kalba yra "C#",
//        išveskite pranešimą, kad yra C# programuotojas su nurodyta alga. Jei programavimo kalba yra "Java",
//        išveskite pranešimą, kad yra Java programuotojas su nurodyta alga.
//        Kitu atveju, išveskite pranešimą apie kitą programavimo kalbą su nurodyta alga.

//        getEmployeeInfo(Employee employee) metode:
//        Grąžinkite informaciją apie darbuotoją kaip String (pvz., "Name: John, Age: 30, Salary: 5000").
//        Panaudoti sąsają:
//        Sukurkite sąrašą Employee objektų, kuriame būtų tiek Manager, tiek Developer objektai.
//        Sukurkite EmployeeService objektą.
//        Naudokite ciklą, kuris iteruoja per sąrašą:
//        Kiekvienam Employee objekte:
//        Kviečiant EmployeeService.getEmployeeInfo(Employee employee) metodą, išveskite informaciją apie darbuotoją.
//        Kviečiant EmployeeService.performDuties(Employee employee) metodą, atlikite atitinkamus veiksmus pagal darbuotojo tipą.

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Manager("Manager1", 45, 2900.00, "marketing",15));
        employeeList.add(new Developer("Developer1", 25, 1200.00, "information technology","Java"));
        employeeList.add(new Developer("Developer2", 19, 750.00, "information technology","C#"));
        employeeList.add(new Developer("Developer3", 39, 3900.00, "information technology","Java"));
        employeeList.add(new Developer("Developer4", 32, 2500.00, "information technology","C++"));
        employeeList.add(new Manager("Manager2", 32, 1900.00, "operations management",5));

        printTeam(employeeList);
        System.out.println();

        EmployeeServiceImpl ui = new EmployeeServiceImpl();
        for(Employee item: employeeList){
            System.out.println(ui.getEmployeeInfo(item));
        }
        System.out.println();

        for(Employee item: employeeList){
            ui.performDuties(item);
        }
        System.out.println();

        for(Employee item: employeeList){
            ui.promoteEmployee(item);
            System.out.println(ui.getEmployeeInfo(item));
        }
        System.out.println();

        ui.changeName(employeeList.get(4), "DeveloperNew");
        ui.changeAge(employeeList.get(4), 35);

        ui.fireEmployee(employeeList, employeeList.get(4));


    }

    public static void printTeam (List<Employee> employeeList) {
        for(Employee item: employeeList){
            System.out.println(item);
            if(item instanceof Manager){
                if(((Manager) item).getTeamSize() > 10) System.out.println("Valdo didelę komandą.");
                else System.out.println("Valdo mažą komandą.");
            } else if(item instanceof Developer){
                if(((Developer) item).progrLang.equals("Java"))
                    System.out.println("Yra " + ((Developer) item).progrLang + " programuotojas, uždirba " + item.getSalary());
                else if(((Developer) item).progrLang.equals("C#"))
                    System.out.println("Yra " + ((Developer) item).progrLang + " programuotojas, uždirba " + item.getSalary());
                else System.out.println("Yra " + ((Developer) item).progrLang + " programuotojas, uždirba " + item.getSalary());
            }
        }
    }

}