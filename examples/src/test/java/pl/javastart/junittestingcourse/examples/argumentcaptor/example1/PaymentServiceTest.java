package pl.javastart.junittestingcourse.examples.argumentcaptor.example1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.mockito.Mockito.verify;

class PaymentServiceTest {

    @Mock PaymentRepository paymentRepository;
    @Captor ArgumentCaptor<Payment> paymentArgumentCaptor;

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void shouldSetCorrectPaymentPrefix() {

        PaymentService paymentService = new PaymentService(paymentRepository);

        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setMethod("PayPal");

        // when
        paymentService.prepareAndSave(paymentDto);

        // then
        ArgumentCaptor<Payment> argumentCaptor = ArgumentCaptor.forClass(Payment.class);
        verify(paymentRepository).save(argumentCaptor.capture());

        Payment payment = argumentCaptor.getValue();
        Assertions.assertThat(payment.getCode()).startsWith("paypal_");
    }

    @Test
    void shouldSetCorrectPaymentPrefixCreatedWithAnnotation() {

        PaymentService paymentService = new PaymentService(paymentRepository);

        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setMethod("PayPal");

        // when
        paymentService.prepareAndSave(paymentDto);

        // then
        verify(paymentRepository).save(paymentArgumentCaptor.capture());

        Payment payment = paymentArgumentCaptor.getValue();
        Assertions.assertThat(payment.getCode()).startsWith("paypal_");

    }

}