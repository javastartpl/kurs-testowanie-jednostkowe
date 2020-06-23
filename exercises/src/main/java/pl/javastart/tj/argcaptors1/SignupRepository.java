package pl.javastart.tj.argcaptors1;

import java.util.Set;

interface SignupRepository {
    Set<Signup> findByUserId(Long userId);
    void save(Signup signup);
}
