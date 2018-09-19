package pl.javastart.junittestingcourse.examples;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class Calculator {
    int add(int a, int b) {
        return a + b;
    }


    void a() {

        Collections.emptyList().stream().collect(Collectors.toList());


    }
}
