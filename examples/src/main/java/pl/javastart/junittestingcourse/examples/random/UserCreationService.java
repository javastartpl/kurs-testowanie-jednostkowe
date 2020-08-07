package pl.javastart.junittestingcourse.examples.random;

import java.time.ZonedDateTime;

public class UserCreationService {

    private DateTimeProvider dateTimeProvider;

    public UserCreationService(DateTimeProvider dateTimeProvider) {
        this.dateTimeProvider = dateTimeProvider;
    }

    public User createUser(String name) {
        return new User(name, dateTimeProvider.nowAsZonedDateTime());
    }
}