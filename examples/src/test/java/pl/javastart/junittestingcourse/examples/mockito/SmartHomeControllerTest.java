package pl.javastart.junittestingcourse.examples.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SmartHomeControllerTest {

    @Mock private HumiditySensor humiditySensorMock;
    @Mock private WateringController wateringControllerMock;
    @InjectMocks private SmartHomeController smartHomeController;

    @Test
    void shouldDisableWatering() {
        // given
        when(humiditySensorMock.getHumidity()).thenReturn(50);

        // when
        smartHomeController.enableWateringIfNeeded();

        // then
        verify(wateringControllerMock).disableWatering();
    }

}