package pl.javastart.junittestingcourse.examples.mockito.behaviour.argumentmatcher;

public class Email {
    private String content;

    public Email(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }
}
