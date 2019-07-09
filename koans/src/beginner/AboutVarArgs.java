package beginner;

import org.junit.jupiter.api.Test;

import static tools.Constants.__;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AboutVarArgs {

    class ExampleClass {
        public boolean canBeTreatedAsArray(Integer... arguments) {
            return arguments instanceof Integer[];
        }

        public int getLength(Integer... arguments) {
            return arguments.length;
        }

        public String verboseLength(String prefix, Object... arguments) {
            return prefix + arguments.length;
        }

        // *******
        // The following methods won't compile because Java only permits varargs as last argument
	// *******
        // public String invalidMethodDeclaration(String... arguments, String... otherArguments) { return ""; }
        // public String otherInvalidMethodDeclaration(String... arguments, String otherArgument) { return ""; }
    }

    @Test
    public void varArgsCanBeTreatedAsArrays() {
        assertEquals(new ExampleClass().canBeTreatedAsArray(1, 2, 3), __);
    }

    @Test
    public void youCanPassInAsManyArgumentsAsYouLike() {
        assertEquals(new ExampleClass().getLength(1, 2, 3), __);
        assertEquals(new ExampleClass().getLength(1, 2, 3, 4, 5, 6, 7, 8), __);
    }

    @Test
    public void youCanPassInZeroArgumentsIfYouLike() {
        assertEquals(new ExampleClass().getLength(), __);
    }

    @Test
    public void youCanHaveOtherTypesInTheMethodSignature() {
        assertEquals(new ExampleClass().verboseLength("This is how many items were passed in: ", 1, 2, 3, 4), __); 
    }
}
