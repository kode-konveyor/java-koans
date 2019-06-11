package java8;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static tools.Constants.__;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AboutLambdas {

    interface Caps {
        public String capitalize(String name);
    }

    String fieldFoo = "Lambdas";

    @Override
    public String toString() {
        return "CAPS";
    }

    static String str = "";

    //lambda has access to "this"
    Caps thisLambdaField = s -> this.toString();
    //lambda has access to object methods
    Caps toStringLambdaField = s -> toString();

    @Test
    public void verySimpleLambda() throws InterruptedException {
        Runnable r8 = () -> str = "changed in lambda";
        r8.run();
        assertEquals(str, __);
    }

    @Test
    public void simpleLambda() {
        Caps caps = (String n) -> {
            return n.toUpperCase();
        };
        String capitalized = caps.capitalize("James");
        assertEquals(capitalized, __);
    }

    @Test
    public void simpleSuccinctLambda() {
        //parameter type can be omitted,
        //code block braces {} and return statement can be omitted for single statement lambda
        //parameter parenthesis can be omitted for single parameter lambda
        Caps caps = s -> s.toUpperCase();
        String capitalized = caps.capitalize("Arthur");
        assertEquals(capitalized, __);
    }

    @Test
    public void lambdaField() {
        assertEquals(thisLambdaField.capitalize(""), __);
    }

    @Test
    public void lambdaField2() {
        assertEquals(toStringLambdaField.capitalize(""), __);
    }

    @Test
    public void effectivelyFinal() {
        //final can be omitted like this:
        /* final */
        String effectivelyFinal = "I'm effectively final";
        Caps caps = s -> effectivelyFinal.toUpperCase();
        assertEquals(caps.capitalize(effectivelyFinal), __);
    }

    @Test
    public void methodReference() {
        Caps caps = String::toUpperCase;
        String capitalized = caps.capitalize("Gosling");
        assertEquals(capitalized, __);
    }

    @Test
    public void thisIsSurroundingClass() {
        //"this" in lambda points to surrounding class
        Function<String, String> foo = s -> s + this.fieldFoo + s;
        assertEquals(foo.apply("|"), __);
    }

}

