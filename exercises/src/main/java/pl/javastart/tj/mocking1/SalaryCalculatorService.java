package pl.javastart.tj.mocking1;

import java.math.BigDecimal;

public class SalaryCalculatorService {

    private TaskManagementSystem taskManagementSystem;

    public SalaryCalculatorService(TaskManagementSystem taskManagementSystem) {
        this.taskManagementSystem = taskManagementSystem;
    }

    public BigDecimal calculateSalary(Employee employee) {
        int finishedTasks = taskManagementSystem.countFinishedTasksForEmployee(employee);

        BigDecimal bonus = BigDecimal.ZERO;
        if (finishedTasks >= 20) {
            bonus = new BigDecimal("1000");
        } else if (finishedTasks >= 10) {
            bonus = new BigDecimal("500");
        }

        return employee.getBaseSalary().add(bonus);
    }

}
