package pl.javastart.tj.assertjintro;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertJIntroTest {

    @Test
    public void shouldEndWithA() {

        String name = "Dorota";
        String otherName = "Anna";

        assertThat(name)
                .isNotEqualTo(otherName)
                .endsWith("a")
                .hasSize(6);
    }

}
