package pl.javastart.junittestingcourse.examples;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInfo;

@Tag("slow")
public class SlowTest {

    @RepeatedTest(10)
    void asd(TestInfo testInfo) throws InterruptedException {
        System.out.println("Slow test: " + testInfo.getDisplayName());
        Thread.sleep(1000);
    }
}
