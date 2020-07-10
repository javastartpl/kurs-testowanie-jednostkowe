package pl.javastart.tj.namingandgrouping;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class NamingAndGrouping {

    @Nested
    class Calculator {
        @DisplayName("2 + 2 = 4")
        @Test
        public void shouldAdd2to2AndReturn4() {

        }
    }

    @DisplayName("Mailing tests")
    @Nested
    class Mails {
        @DisplayName("Mails only to subscribers")
        @Test
        public void shouldSendEmailOnlyToSubscribers() {

        }

        @Test
        public void shouldRemoveCacheAfterInvalidate() {

        }
    }


}