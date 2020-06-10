package pl.javastart.junittestingcourse.examples.argumentmatcher;

public class InvalidPasswordService {
    public void notifyAboutInvalidPassword() {
    }

    public void notifyAboutInvalidPassword(String ip) {
    }

    public void notifyAboutInvalidPassword(int i, String s) {
    }
}
