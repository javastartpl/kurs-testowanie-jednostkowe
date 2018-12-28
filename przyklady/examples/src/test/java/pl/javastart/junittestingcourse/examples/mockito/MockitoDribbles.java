package pl.javastart.junittestingcourse.examples.mockito;

import org.mockito.BDDMockito;
import org.mockito.Mock;

public class MockitoDribbles {

    @Mock HumiditySensor humiditySensor;

    public void asd() {
        BDDMockito.when(humiditySensor.getHumidity()).thenReturn(5);
        BDDMockito.given(humiditySensor.getHumidity()).willReturn(5);


    }
}
