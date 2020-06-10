package pl.javastart.junittestingcourse.examples.argumentcaptor.example2;

import java.util.List;

public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    void createMultipleUsers(List<UserDto> users) {
        for (UserDto user : users) {
            userRepository.addUser(user.getName(), user.getSurname());
        }

    }
}
