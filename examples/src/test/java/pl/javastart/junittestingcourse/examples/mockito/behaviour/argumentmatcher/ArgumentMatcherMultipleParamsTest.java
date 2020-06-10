package pl.javastart.junittestingcourse.examples.mockito.behaviour.argumentmatcher;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.NotExtensible;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class ArgumentMatcherMultipleParamsTest {

    @Test
    public void shouldSendEmailOnlyToAdmin() {
        // given
        EmailService emailService = mock(EmailService.class);
        // when
        when(emailService.prepareEmailContentFormatting("Treść Maila", anyBoolean())).thenReturn("Treść Maila"); // (1)
    }

    @Test
    public void shouldSendEmailOnlyToAdminFixed() {
        // given
        EmailService emailService = mock(EmailService.class);
        // when
        when(emailService.prepareEmailContentFormatting(eq("Treść Maila"), anyBoolean())).thenReturn("Treść Maila");
    }

    @Test
    public void alreadySentEmails() {
        // given
        EmailService emailService = mock(EmailService.class);
        List<Email> emails = new ArrayList<>();
        // when
        when(emailService.filterOutAlreadySentEmails(anyList())).thenReturn(emails);
    }

    @Test
    public void shouldSendEmailOnlyToAdminWithAny() {
        // given
        EmailService emailService = mock(EmailService.class);
        // when
        when(emailService.prepareEmailContentFormatting(any(), anyBoolean())).thenReturn("Treść Maila");
    }

}
