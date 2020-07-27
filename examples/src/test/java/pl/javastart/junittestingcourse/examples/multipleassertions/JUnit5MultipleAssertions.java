package pl.javastart.junittestingcourse.examples.multipleassertions;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import pl.javastart.junittestingcourse.examples.model.Superhero;
import pl.javastart.junittestingcourse.examples.model.Superheros;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class JUnit5MultipleAssertions {

    @Test
    void shouldCorrectlyCreateHulk() {
        // when
        Superhero hulk = Superheros.getHulk();

        // then
        assertThat(hulk.getAbilities()).contains("intelligence");
        assertThat(hulk.getColor()).isEqualTo("blue");
        assertThat(hulk.getPublisher()).isEqualTo("Disney");
    }

    @Test
    void multipleAssertionsTogetherWithAssertJ() {
        Superhero hulk = Superheros.getHulk();
        assertAll(
                () -> assertThat(hulk.getAbilities()).contains("intelligence"),
                () -> assertThat(hulk.getColor()).isEqualTo("blue"),
                () -> assertThat(hulk.getPublisher()).isEqualTo("Disney")
        );
    }

    @Test
    void multipleAssertionsTogetherWithJUnit() {
        Superhero hulk = Superheros.getHulk();
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(hulk.getAbilities()).contains("intelligence");
        softAssertions.assertThat(hulk.getColor()).isEqualTo("blue");
        softAssertions.assertThat(hulk.getPublisher()).isEqualTo("Disney");
        softAssertions.assertAll();
    }

}
