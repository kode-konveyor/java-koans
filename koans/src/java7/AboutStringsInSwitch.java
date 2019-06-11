package java7;

import org.junit.jupiter.api.Test;

import static tools.Constants.__;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AboutStringsInSwitch {

    @Test
    public void stringsInSwitchStatement() {
        String[] animals = {"Dog", "Cat", "Tiger", "Elephant", "Zebra"};
        String dangerous = null;
        String notDangerous = null;
        for (String animal : animals) {
            switch (animal) {
                case "Tiger":
                    dangerous = animal;
                case "Dog":
                case "Cat":
                case "Elephant":
                case "Zebra":
                    notDangerous = animal;
            }
        }
        assertEquals(notDangerous, __);
        assertEquals(dangerous, __);
    }

}
