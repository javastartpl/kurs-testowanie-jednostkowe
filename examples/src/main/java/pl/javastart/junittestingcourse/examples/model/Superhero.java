package pl.javastart.junittestingcourse.examples.model;

import java.util.HashSet;
import java.util.Set;

public class Superhero {
    private String color;
    private Set<String> abilities = new HashSet<>();
    private String publisher;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Set<String> getAbilities() {
        return abilities;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
