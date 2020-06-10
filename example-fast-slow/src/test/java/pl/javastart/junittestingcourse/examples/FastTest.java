package pl.javastart.junittestingcourse.examples;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInfo;

@Tag("fast")
public class FastTest {

    @RepeatedTest(1000)
    void fast(TestInfo testInfo) {
        System.out.println("Fast test: " + testInfo.getDisplayName());
    }

}
