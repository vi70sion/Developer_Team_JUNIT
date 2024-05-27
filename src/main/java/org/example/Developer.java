package org.example;

public class Developer extends Employee{
    String progrLang;

    public Developer(String name, int age, double salary, String department, String progrLang) {
        super(name, age, salary, department);
        this.progrLang = progrLang;
    }

    public String getProgrLang() { return progrLang; }
    public void setProgrLang(String progrLang) { this.progrLang = progrLang; }

    @Override
    public void Work(){

    }

    @Override
    public String toString() {
        return super.toString() + ", programavimo kalba: " + progrLang;
    }
}

