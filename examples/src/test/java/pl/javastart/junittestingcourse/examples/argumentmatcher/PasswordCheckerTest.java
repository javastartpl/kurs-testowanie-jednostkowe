package pl.javastart.junittestingcourse.examples.argumentmatcher;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

class PasswordCheckerTest {

    @Test
    void shouldRunNotificationService() {
        // given
        InvalidPasswordService invalidPasswordService = Mockito.mock(InvalidPasswordService.class);
        PasswordChecker mockitoVerifyExample = new PasswordChecker(invalidPasswordService);

        // when
        mockitoVerifyExample.checkPassword("abc");

        mockitoVerifyExample.getClass().getName();

        // then
        verify(invalidPasswordService).notifyAboutInvalidPassword();
    }

    @Test
    void shouldNotRunNotificationService() {
        // given
        InvalidPasswordService invalidPasswordService = Mockito.mock(InvalidPasswordService.class);
        PasswordChecker mockitoVerifyExample = new PasswordChecker(invalidPasswordService);

        // when
        mockitoVerifyExample.checkPassword("A123B32");

        // then
        verify(invalidPasswordService, never()).notifyAboutInvalidPassword();
    }

    @Test
    void shouldTriggerNotificationService() {
        // given
        InvalidPasswordService invalidPasswordService = Mockito.mock(InvalidPasswordService.class);
        PasswordChecker mockitoVerifyExample = new PasswordChecker(invalidPasswordService);

        // when
        mockitoVerifyExample.checkPasswordNew("abc", "127.0.0.2");

        // then
        verify(invalidPasswordService, never()).notifyAboutInvalidPassword(anyInt(), eq("Próba włamania z ip: 127.0.0.1"));
    }

    @Test
    void shouldNotTriggerNotificationService() {
        // given
        InvalidPasswordService invalidPasswordService = Mockito.mock(InvalidPasswordService.class);
        PasswordChecker mockitoVerifyExample = new PasswordChecker(invalidPasswordService);

        // when
        mockitoVerifyExample.checkPasswordNew("A123B32", "127.0.0.1");

        // then
        verify(invalidPasswordService, never()).notifyAboutInvalidPassword(anyInt(), any());
    }


    @Test
    void shouldTriggerNotificationServiceStartingWithRightMessage() {
        // given
        InvalidPasswordService invalidPasswordService = Mockito.mock(InvalidPasswordService.class);
        PasswordChecker mockitoVerifyExample = new PasswordChecker(invalidPasswordService);

        // when
        mockitoVerifyExample.checkPasswordNew("abc", "127.0.0.1");

        // then
        verify(invalidPasswordService).notifyAboutInvalidPassword(anyInt(), startsWith("Próba włamania z ip: ")); // ArgumentMatchers.startsWith()
    }

    @Test
    void shouldTriggerNotificationServiceWithRightMessageInvalid() {
        // given
        InvalidPasswordService invalidPasswordService = Mockito.mock(InvalidPasswordService.class);
        PasswordChecker mockitoVerifyExample = new PasswordChecker(invalidPasswordService);

        // when
        mockitoVerifyExample.checkPasswordNew("abc", "127.0.0.1");

        // then
        verify(invalidPasswordService).notifyAboutInvalidPassword(anyInt(), "Próba włamania z ip: 127.0.0.1");
    }

    @Test
    void shouldTriggerNotificationServiceWithRightMessageValid() {
        // given
        InvalidPasswordService invalidPasswordService = Mockito.mock(InvalidPasswordService.class);
        PasswordChecker mockitoVerifyExample = new PasswordChecker(invalidPasswordService);

        // when
        mockitoVerifyExample.checkPasswordNew("abc", "127.0.0.1");

        // then
        verify(invalidPasswordService).notifyAboutInvalidPassword(anyInt(), ArgumentMatchers.eq("Próba włamania z ip: 127.0.0.1")); // ArgumentMatchers.eq()
    }
}