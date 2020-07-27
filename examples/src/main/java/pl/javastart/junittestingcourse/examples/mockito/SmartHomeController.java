package pl.javastart.junittestingcourse.examples.mockito;

import java.util.Random;

public class SmartHomeController {

    private HumiditySensor humiditySensor;
    private WateringController wateringController;
    private Random random;

    public SmartHomeController(HumiditySensor humiditySensor, WateringController wateringController, Random random) {
        this.humiditySensor = humiditySensor;
        this.wateringController = wateringController;
        this.random = random;
    }

    public void enableWateringIfNeeded() {
        random.nextInt();
        int humidity = humiditySensor.getHumidity();

        if (humidity < 50) {
            wateringController.enableWatering();
        } else {
            wateringController.disableWatering();
        }
    }

}
