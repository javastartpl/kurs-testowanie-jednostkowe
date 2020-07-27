package pl.javastart.tj.junit5assertions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import java.util.function.Supplier;

public class AssertionsWIthJUnit5 {

    @Test
    public void messageExample() {
        // given

        // when

        String actual = "b";

        // then

        long start = System.currentTimeMillis();
        String expected = "a";

        Assertions.assertEquals(expected, actual, this::createMessage);

        System.out.println("Trwało to : " + (System.currentTimeMillis() - start) + " ms");

        /*
            sprawdź czy wynik obliczenia to 5
            sprawdź czy lista wynikowa zawiera dokładnie 10 elementów
            sprawdź czy tekst wynikowy jest zakończony fragmentem "naście"
            sprawdź czy wynik to null
         */

    }

    private String createMessage() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Wartości różnią się od siebie!";
    }

    @Test
    public void assertionsOverview() {

//        String result = "abc";
//
//        Assertions.assertNull(result);
//        Assertions.assertNotNull(result);
//
//        Assertions.assertFalse();
//        Assertions.assertTrue();
//
//        Assertions.assertSame();
//        Assertions.assertNotSame();
//
//        Assertions.assertThrows();
//
//        Assertions.assertAll();

    }


}
