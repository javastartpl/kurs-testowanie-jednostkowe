package pl.javastart.tj.exception1;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class SalaryCalculatorServiceTest {
    @Test
    public void asd() {
        SalaryCalculatorService a = new SalaryCalculatorService();

        a.calculateSalary(new Employee("Ted", BigDecimal.ZERO));



    }

}