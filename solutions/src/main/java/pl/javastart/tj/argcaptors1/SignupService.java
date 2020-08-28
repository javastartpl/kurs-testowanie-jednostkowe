package pl.javastart.tj.argcaptors1;

import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.Set;

class SignupService {

    private final SignupRepository signupRepository;
    private final DateTimeProvider dateTimeProvider;

    public SignupService(SignupRepository signupRepository, DateTimeProvider dateTimeProvider) {
        this.signupRepository = signupRepository;
        this.dateTimeProvider = dateTimeProvider;
    }

    public void createSignup(Long userId, Long courseId) {

        Set<Signup> signups = signupRepository.findByUserId(userId);

        Optional<Signup> existingSignupOptional = signups.stream()
                .filter(s -> s.getCourseId().equals(courseId))
                .findFirst();
        Signup signup = new Signup();

        if (existingSignupOptional.isPresent()) {
            Signup existingSignup = existingSignupOptional.get();
            signup.setFrom(existingSignup.getTo());
            signup.setTo(existingSignup.getTo().plusYears(1));
        } else {
            ZonedDateTime now = dateTimeProvider.now();
            signup.setFrom(now);
            signup.setTo(now.plusYears(1));
        }

        signup.setUserId(userId);
        signup.setCourseId(courseId);
        signupRepository.save(signup);
    }

}
