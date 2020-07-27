package pl.javastart.junittestingcourse.examples.mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class SmartHomeControllerTest {

    @Mock HumiditySensor humiditySensor;
    @Mock WateringController wateringController;
    @Mock Random random;

    @InjectMocks
    private SmartHomeController smartHomeController;

    @BeforeEach
    public void init() {
        smartHomeController = new SmartHomeController(humiditySensor, wateringController, random);
    }

    @Test
    public void shouldDisableWatering() {
        // given
        Mockito.when(humiditySensor.getHumidity()).thenReturn(50);

        // when
        smartHomeController.enableWateringIfNeeded();

        // then
        verify(wateringController).disableWatering();
    }

    @Test
    public void shouldEnableWatering() {
        // given
        Mockito.when(humiditySensor.getHumidity()).thenReturn(49);

        // when
        smartHomeController.enableWateringIfNeeded();

        // then
        verify(wateringController).enableWatering();
    }

}