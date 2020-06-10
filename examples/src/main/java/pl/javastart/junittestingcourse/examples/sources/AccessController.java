package pl.javastart.junittestingcourse.examples.sources;

public class AccessController {
    public boolean checkAccessForSignupStatus(SignupStatus signupStatus) {
        return signupStatus == SignupStatus.PAID;
    }
}
