package pl.javastart.junittestingcourse.examples;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInfo;

@Tag("slow")
class ASlowTest {

    void verySlowTest() throws InterruptedException {
        System.out.println("Very slow test");
        Thread.sleep(10000);
    }

    @RepeatedTest(10)
    void slowTest(TestInfo testInfo) throws InterruptedException {
        System.out.println("Slow test: " + testInfo.getDisplayName());
        Thread.sleep(1000);
    }
}
