package pl.javastart.tj.random;

import java.util.UUID;

public class RandomTextGenerator {

    public String getRandomText() {
        return UUID.randomUUID().toString();
    }
}
