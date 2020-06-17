package pl.javastart.tj.exception1;

import java.math.BigDecimal;

class SalaryCalculatorService {

    public BigDecimal calculateSalary(Employee employee) throws SalaryCalculationFailedException {
        TaskManagementSystem taskManagementSystem = new TaskManagementSystem();

        int finishedTasks = taskManagementSystem.countFinishedTasksForEmployee(employee);
        BigDecimal bonus = BigDecimal.ZERO;
        if (finishedTasks >= 10) {
            bonus = new BigDecimal("500");
        } else if (finishedTasks > 20) {
            bonus = new BigDecimal("1000");
        }

        return employee.getBaseSalary().add(bonus);
    }

}
