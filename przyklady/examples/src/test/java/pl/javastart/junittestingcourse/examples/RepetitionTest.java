package pl.javastart.junittestingcourse.examples;

import org.junit.jupiter.api.*;

public class RepetitionTest {

    private long timestamp;

    @BeforeEach
    void before(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println("Uruchamiam test " + testInfo.getDisplayName());
        timestamp = System.currentTimeMillis();
    }

    @RepeatedTest(value = 5, name = "MojTest")
    void testSomething(RepetitionInfo repetitionInfo) throws InterruptedException {
        System.out.println("Wykonuję powtórzenie " + repetitionInfo.getCurrentRepetition());
        Thread.sleep(100);
    }

    @AfterEach
    void after(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println("Wykonanie testu " + testInfo.getDisplayName() + " "
                + repetitionInfo.getCurrentRepetition() + "/" + repetitionInfo.getTotalRepetitions()
                + " trwało: " + (System.currentTimeMillis() - timestamp) + "ms");
    }
}
