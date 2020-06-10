package pl.javastart.junittestingcourse.examples;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.TestInfo;

@Fast
public class OtherFastTest {

    @RepeatedTest(1000)
    void asd(TestInfo testInfo) {
        System.out.println("Fast test: " + testInfo.getDisplayName());
    }

}
