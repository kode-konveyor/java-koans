package java8;

import org.junit.jupiter.api.Test;

import static tools.Constants.__;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AboutMultipleInheritance {

    interface Human {
        default String sound() {
            return "hello";
        }
    }

    interface Bull {
        default String sound() {
            return "moo";
        }
    }

    class Minotaur implements Human, Bull {
        //both interfaces implement same default method
        //has to be overridden
        @Override
        public String sound() {
            return Bull.super.sound();
        }
    }

    @Test
    public void multipleInheritance() {
        Minotaur minotaur = new Minotaur();
        assertEquals(minotaur.sound(), __);
    }

}
