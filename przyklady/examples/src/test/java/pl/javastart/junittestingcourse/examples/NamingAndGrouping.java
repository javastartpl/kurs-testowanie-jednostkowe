package pl.javastart.junittestingcourse.examples;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class NamingAndGrouping {

    @Nested
    class Calculations {

        @DisplayName("Should add 2 to 2 and return 4")
        @Test
        public void shouldAdd2to2AndReturn4() {
        }

        @Nested
        class Complicated {
            @DisplayName("Should add 1 to 1 and return 2")
            @Test
            public void shouldAdd2to2AndReturn4() {
            }
        }
    }

    @DisplayName("Mail tests")
    @Nested
    class Mails {
        @DisplayName("Should send email olny to subscribers")
        @Test
        public void shouldSendEmailOnlyToSubscribers() {}

        @DisplayName("Should not send multiple mails to one person")
        @Test
        public void shouldNotSendMultipleMailsToOnePerson() {}
    }

    @DisplayName("Should remove cache after invalidate")
    @Test
    public void shouldRemoveCacheAfterInvalidate() {

    }
}