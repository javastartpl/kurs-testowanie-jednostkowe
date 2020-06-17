package pl.javastart.tj.exception1;

import java.math.BigDecimal;

class Employee {

    private String name;
    private BigDecimal baseSalary;

    public Employee(String name, BigDecimal baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getBaseSalary() {
        return baseSalary;
    }
}
