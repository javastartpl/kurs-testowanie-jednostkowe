package pl.javastart.junittestingcourse.examples;

import org.junit.jupiter.api.Tag;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Tag("fast")
public @interface Fast { }
