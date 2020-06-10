package pl.javastart.junittestingcourse.examples.multipleassertions;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import pl.javastart.junittestingcourse.examples.model.Superhero;
import pl.javastart.junittestingcourse.examples.model.Superheros;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class AssertJMultipleAssertions {

    @Test
    void multipleAssertions() {
        Superhero hulk = Superheros.getHulk();
        assertThat(hulk.getAbilities()).contains("intelligence");
        assertThat(hulk.getColor()).isEqualTo("blue");
        assertThat(hulk.getPublisher()).isEqualTo("Disney");
    }

    @Test
    void multipleAssertionsTogether() {
        Superhero hulk = Superheros.getHulk();
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(hulk.getAbilities()).contains("intelligence");
        softAssertions.assertThat(hulk.getColor()).isEqualTo("blue");
        softAssertions.assertThat(hulk.getPublisher()).isEqualTo("Disney");
        softAssertions.assertAll();
    }
}