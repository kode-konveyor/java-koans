package java8;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static tools.Constants.__;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AboutOptional {

    boolean optionalIsPresentField = false;

    @Test
    public void isPresent() {
        boolean optionalIsPresent = false;
        Optional<String> value = notPresent();
        if (value.isPresent()) {
            optionalIsPresent = true;
        }
        assertEquals(optionalIsPresent, __);
    }

    @Test
    public void ifPresentLambda() {
        Optional<String> value = present();
        value.ifPresent(x -> optionalIsPresentField = true);
        assertEquals(optionalIsPresentField, __);
    }

    //use optional on api to signal that value is optional
    public Optional<String> notPresent() {
        return Optional.empty();
    }

    private Optional<String> present() {
        return Optional.of("is present");
    }
}
