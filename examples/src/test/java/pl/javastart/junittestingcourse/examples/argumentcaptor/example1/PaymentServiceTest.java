package pl.javastart.junittestingcourse.examples.argumentcaptor.example1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class PaymentServiceTest {

    @Mock private PaymentRepository paymentRepository;
    @Mock private PaymentDto paymentDto;
    @Captor private ArgumentCaptor<Payment> captor;

    private PaymentService paymentService;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
        paymentService = new PaymentService(paymentRepository);
        paymentDto = Mockito.mock(PaymentDto.class);
        when(paymentDto.getMethod()).thenReturn("PayPal");
    }

    @Test
    void shouldSetCorrectPaymentPrefix() {
        // when
        paymentService.prepareAndSave(paymentDto);

        // then
        verify(paymentRepository).save(captor.capture());

        Payment payment = captor.getValue();
        assertThat(payment.getCode()).startsWith("paypal_");
    }

    @Test
    void shouldSetCorrectPaymentMethod() {
        // when
        paymentService.prepareAndSave(paymentDto);

        // then
        verify(paymentRepository).save(captor.capture());

        Payment payment = captor.getValue();
        assertThat(payment.getMethod()).isEqualTo("PayPal");
    }


    @Test
    void shouldSetCorrectPaymentPrefixForMultiple() {
        // given
        PaymentDto paymentDto1 = Mockito.mock(PaymentDto.class);
        PaymentDto paymentDto2 = Mockito.mock(PaymentDto.class);
        PaymentDto paymentDto3 = Mockito.mock(PaymentDto.class);
        when(paymentDto1.getMethod()).thenReturn("PayPal");
        when(paymentDto2.getMethod()).thenReturn("Przelewy24");
        when(paymentDto3.getMethod()).thenReturn("Przelewy24");
        List<PaymentDto> paymentDtos = Arrays.asList(paymentDto1, paymentDto2, paymentDto3);

        // when
        paymentService.prepareAndSaveMultiple(paymentDtos);

        // then
        verify(paymentRepository, times(3)).save(captor.capture());

        List<Payment> paymentList = captor.getAllValues();

        Payment payment1 = paymentList.get(0);
        assertThat(payment1.getCode()).startsWith("paypal_");

        Payment payment2 = paymentList.get(1);
        assertThat(payment2.getCode()).startsWith("przelewy24_");
    }










//    @Test
//    void shouldSetCorrectPaymentPrefix() {
//
//        PaymentService paymentService = new PaymentService(paymentRepository);
//
//        PaymentDto paymentDto = new PaymentDto();
//        paymentDto.setMethod("PayPal");
//
//        // when
//        paymentService.prepareAndSave(paymentDto);
//
//        // then
//        ArgumentCaptor<Payment> argumentCaptor = ArgumentCaptor.forClass(Payment.class);
//        verify(paymentRepository).save(argumentCaptor.capture());
//
//        Payment payment = argumentCaptor.getValue();
//        Assertions.assertThat(payment.getCode()).startsWith("paypal_");
//    }

//    @Test
//    void shouldSetCorrectPaymentPrefixCreatedWithAnnotation() {
//
//        PaymentService paymentService = new PaymentService(paymentRepository);
//
//        PaymentDto paymentDto = new PaymentDto();
//        paymentDto.setMethod("PayPal");
//
//        // when
//        paymentService.prepareAndSave(paymentDto);
//
//        // then
//        verify(paymentRepository).save(paymentArgumentCaptor.capture());
//
//        Payment payment = paymentArgumentCaptor.getValue();
//        Assertions.assertThat(payment.getCode()).startsWith("paypal_");
//
//    }

}