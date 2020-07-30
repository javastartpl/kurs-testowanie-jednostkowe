package pl.javastart.junittestingcourse.examples.mockito.behaviour.argumentmatcher;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class ArgumentMatcherMultipleParamsTest {


    @Test
    public void shouldSendEmailOnlyToAdmin() {
        // given
        EmailService emailService = mock(EmailService.class);
        // when
        when(emailService.prepareEmailContentFormatting("Treść Maila", any())).thenReturn("<b>Treść Maila</b>"); // (1)

        String preparedContent = emailService.prepareEmailContentFormatting("Treść Maila", false);

        assertThat(preparedContent).isEqualTo("<b>Treść Maila</b>");
    }








    @Test
    public void shouldSendEmailOnlyToAdminFixed() {
        // given
        EmailService emailService = mock(EmailService.class);
        // when
        when(emailService.prepareEmailContentFormatting(ArgumentMatchers.any(), anyBoolean())).thenReturn("<b>Treść Maila</b>");

        String preparedContent = emailService.prepareEmailContentFormatting("Treść Maila", false);
        assertThat(preparedContent).isEqualTo("<b>Treść Maila</b>");
    }











    @Test
    public void alreadySentEmails() {
        // given
        EmailService emailService = mock(EmailService.class);
        List<Email> emails = new ArrayList<>();
        emails.add(new Email("a"));
        emails.add(new Email("b"));
        // when
        when(emailService.filterOutAlreadySentEmails(ArgumentMatchers.any())).thenReturn(emails);

        List<Email> emails1 = emailService.filterOutAlreadySentEmails(new ArrayList<>());

        assertThat(emails).isEqualTo(emails1);
    }






    @Test
    public void shouldSendEmailOnlyToAdminWithAny() {
        // given
        EmailService emailService = mock(EmailService.class);
        // when
        when(emailService.prepareEmailContentFormatting(any(), anyBoolean())).thenReturn("Treść Maila");
    }

}
