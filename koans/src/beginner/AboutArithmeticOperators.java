package beginner;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tools.Constants.__;;

public class AboutArithmeticOperators {

    @Test
    public void simpleOperations() {
        assertEquals(1, __);
        assertEquals(1 + 1, __);
        assertEquals(2 + 3 * 4, __);
        assertEquals((2 + 3) * 4, __);
        assertEquals(2 * 3 + 4, __);
        assertEquals(2 - 3 + 4, __);
        assertEquals(2 + 4 / 2, __);
        assertEquals((2 + 4) / 2, __);
    }

    @Test
    public void notSoSimpleOperations() {
        assertEquals(1 / 2, __);
        assertEquals(3 / 2, __);
        assertEquals(1 % 2, __);
        assertEquals(3 % 2, __);
    }

    @Test
    public void minusMinusVariableMinusMinus() {
        int i = 1;
        assertEquals(--i, __);
        assertEquals(i, __);
        assertEquals(i--, __);
        assertEquals(i, __);
    }

    @Test
    public void plusPlusVariablePlusPlus() {
        int i = 1;
        assertEquals(++i, __);
        assertEquals(i, __);
        assertEquals(i++, __);
        assertEquals(i, __);
    }

    @Test
    public void timesAndDivInPlace() {
        int i = 1;
        i *= 2;
        assertEquals(i, __);
        i /= 2;
        assertEquals(i, __);
    }

}
