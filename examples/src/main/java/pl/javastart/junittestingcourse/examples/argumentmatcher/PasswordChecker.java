package pl.javastart.junittestingcourse.examples.argumentmatcher;

public class PasswordChecker {

    private InvalidPasswordService invalidPasswordService;

    public PasswordChecker(InvalidPasswordService invalidPasswordService) {
        this.invalidPasswordService = invalidPasswordService;
    }

    void checkPassword(String password) {
        if(password.equals("A123B32")) {
            // OK continue...
        } else {
            // invalid password
            invalidPasswordService.notifyAboutInvalidPassword();
        }
    }

    void checkPasswordNew(String password, String ip) {
        if (password.equals("A123B32")) {
            // OK continue...
        } else {
            // invalid password
            invalidPasswordService.notifyAboutInvalidPassword(1, "Próba włamania z ip: " + ip);
        }
    }
}