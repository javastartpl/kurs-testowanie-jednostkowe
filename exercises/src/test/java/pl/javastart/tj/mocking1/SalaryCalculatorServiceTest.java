package pl.javastart.tj.mocking1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class SalaryCalculatorServiceTest {

    @Mock TaskManagementSystem taskManagementSystem;

    private SalaryCalculatorService salaryCalculatorService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        salaryCalculatorService = new SalaryCalculatorService(taskManagementSystem);
    }

    @Test
    public void shouldHaveNoBonus() {
        // given
        Employee employee = new Employee("Tomek", BigDecimal.valueOf(2000));
        when(taskManagementSystem.countFinishedTasksForEmployee(employee)).thenReturn(9);

        // when
        BigDecimal salary = salaryCalculatorService.calculateSalary(employee);

        // then
        assertThat(salary).isEqualTo(BigDecimal.valueOf(2000));
    }

    @ValueSource(ints = {10, 19})
    @ParameterizedTest
    public void shouldHave500Bonus(int finishedTasks) {
        // given
        Employee employee = Mockito.mock(Employee.class);
        when(employee.getBaseSalary()).thenReturn(BigDecimal.valueOf(2000));
        when(taskManagementSystem.countFinishedTasksForEmployee(employee)).thenReturn(finishedTasks);

        // when
        BigDecimal salary = salaryCalculatorService.calculateSalary(employee);

        // then
        assertThat(salary).isEqualTo(BigDecimal.valueOf(2500));
    }

    @Test
    public void shouldHave1000Bonus() {
        // given
        Employee employee = new Employee("Tomek", BigDecimal.valueOf(2000));
        when(taskManagementSystem.countFinishedTasksForEmployee(employee)).thenReturn(20);

        // when
        BigDecimal salary = salaryCalculatorService.calculateSalary(employee);

        // then
        assertThat(salary).isEqualTo(BigDecimal.valueOf(3000));
    }

}