package pl.javastart.junittestingcourse.examples;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Computer lenovo = new Computer(3000, 1100, "lenovo");
        Computer xiaomi = new Computer(2000, 1100, "xiaomi");

        List<Computer> computers = Arrays.asList(lenovo, xiaomi);

        ComputerComparator computerComparator = new ComputerComparator();
        Collections.sort(computers, computerComparator);

        System.out.println(computers);

    }
}
