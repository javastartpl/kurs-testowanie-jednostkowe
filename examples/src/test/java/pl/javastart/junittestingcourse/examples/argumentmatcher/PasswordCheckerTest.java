package pl.javastart.junittestingcourse.examples.argumentmatcher;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class PasswordCheckerTest {


    @Test
    void shouldRunNotificationService() {
        // given
        InvalidPasswordService invalidPasswordService = Mockito.mock(InvalidPasswordService.class);
        PasswordChecker mockitoVerifyExample = new PasswordChecker(invalidPasswordService);

        // when
        mockitoVerifyExample.checkPassword("abc");

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
        verify(invalidPasswordService, Mockito.times(0)).notifyAboutInvalidPassword();
    }

    @Test
    void shouldTriggerNotificationService() {
        // given
        InvalidPasswordService invalidPasswordService = Mockito.mock(InvalidPasswordService.class);
        PasswordChecker mockitoVerifyExample = new PasswordChecker(invalidPasswordService);

        // when
        mockitoVerifyExample.checkPasswordNew("abc", "127.0.0.1");

        // then
        verify(invalidPasswordService).notifyAboutInvalidPassword(Mockito.any(), Mockito.anyString());
    }
}