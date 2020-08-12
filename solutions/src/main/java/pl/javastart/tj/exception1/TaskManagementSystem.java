package pl.javastart.tj.exception1;

import java.util.Random;

class TaskManagementSystem {

    /**
     * Ta metoda nie ma być testowana, specjalnie jest tutaj losowa implementacja
     */
    public int countFinishedTasksForEmployee(Employee employee) throws EmployeeNoLongerWorkingException {
        return new Random().nextInt(30);
    }

}
