package pl.javastart.junittestingcourse.examples.mockito;

public class SmartHomeController {

    private HumiditySensor humiditySensor;
    private WateringController wateringController;

    public SmartHomeController(HumiditySensor humiditySensor, WateringController wateringController) {
        this.humiditySensor = humiditySensor;
        this.wateringController = wateringController;
    }

    public void enableWateringIfNeeded() {
        int humidity = humiditySensor.getHumidity();

        if (humidity < 50) {
            wateringController.enableWatering();
        } else {
            wateringController.disableWatering();
        }
    }

}
