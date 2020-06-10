package pl.javastart.tj.mocking1;

import java.util.Random;

public class TaskManagementSystem {

    /**
     * Ta metoda nie ma być testowana, specjalnie jest tutaj losowa implementacja
     */
    public int countFinishedTasksForEmployee(Employee employee) {
        return new Random().nextInt(30);
    }

}
