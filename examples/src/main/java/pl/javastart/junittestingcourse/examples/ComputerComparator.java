package pl.javastart.junittestingcourse.examples;

import java.util.Comparator;

public class ComputerComparator implements Comparator<Computer> {

    @Override
    public int compare(Computer computer1, Computer computer2) {
        if(computer1.getCpu() > computer2.getCpu()) {
            return -1;
        } else if( computer1.getCpu() == computer2.getCpu()){
            return 0;
        } else {
            return 1;
        }
    }
}
