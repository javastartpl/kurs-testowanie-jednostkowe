package pl.javastart.junittestingcourse.examples.model;

public class Superheros {

    public static Superhero getHulk() {
        Superhero superhero = new Superhero();
        superhero.setColor("green");
        superhero.setPublisher("Marvel");
        superhero.getAbilities().add("superstrength");
        superhero.getAbilities().add("agility");
        superhero.getAbilities().add("regeneration");
        return superhero;
    }
}
