package pl.javastart.tj.random;

public class PasswordResetGenerationService {

    public RandomTextGenerator randomTextGenerator;

    public PasswordResetGenerationService(RandomTextGenerator randomTextGenerator) {
        this.randomTextGenerator = randomTextGenerator;
    }

    public String preparePasswordResetMessage() {

        return "Cześć, aby przejść do resetowania hasła naciśnij " +
                "<a href=\"https://example.com/reset?key=" + randomTextGenerator.getRandomText() + "\">ten link</a>";

    }

}
