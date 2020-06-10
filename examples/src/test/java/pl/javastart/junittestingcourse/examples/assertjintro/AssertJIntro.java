package pl.javastart.junittestingcourse.examples.assertjintro;

import org.junit.jupiter.api.Test;

import java.util.List;

import static pl.javastart.junittestingcourse.examples.assertjintro.TestClass.abc;

public class AssertJIntro {

    @Test
    public void nameShouldEndWithLetterA() {
        String name = "Dorota";

//        org.junit.jupiter.api.Assertions.assertFalse(name.endsWith("a"));
        org.assertj.core.api.Assertions.assertThat(name).doesNotEndWith("a");

        System.out.println(abc);
    }

    @Test
    public void nameShouldHave6Letters() {
        String name = "Marcin";
        // zawiera dokładnie 6 liter
        org.junit.jupiter.api.Assertions.assertTrue(name.length() == 6);
        org.assertj.core.api.Assertions.assertThat(name).hasSize(6);
    }

    @Test
    public void userNamesShouldContain() {
        List<User> users = List.of(
                new User("Dorota", true),
                new User("Damian", false),
                new User("Kornelia", true)
        );

        org.assertj.core.api.Assertions.assertThat(users)
                .extracting(User::getName)
                .containsExactly("Dorota", "Damian", "Kornelia");
    }

    @Test
    public void adultUsersShouldContainNames() {
        List<User> users = List.of(
                new User("Dorota", true),
                new User("Damian", false),
                new User("Kornelia", true)
        );

        org.assertj.core.api.Assertions.assertThat(users)
                .filteredOn(user -> user.isAdult)
                .extracting(User::getName)
                .containsExactly("Dorota", "Kornelia");
    }

    static class User {

        private String name;
        private boolean isAdult;

        public User(String name, boolean isAdult) {
            this.name = name;
            this.isAdult = isAdult;
        }

        public String getName() {
            return name;
        }

        public boolean isAdult() {
            return isAdult;
        }
    }
}
