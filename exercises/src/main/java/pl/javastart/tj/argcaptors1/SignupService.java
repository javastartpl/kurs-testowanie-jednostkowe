package pl.javastart.tj.argcaptors1;

class SignupService {

    private final SignupRepository signupRepository;

    public SignupService(SignupRepository signupRepository) {
        this.signupRepository = signupRepository;
    }

    public void createSignup(Long userId, Long courseId) {
        Signup signup = new Signup();

        signupRepository.save(signup);
    }

}
