package beginner;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tools.Constants.__;;

public class AboutArithmeticOperators {

    @Test
    public void simpleOperations() {
        assertEquals(1, 1);
        assertEquals(1 + 1, 2);
        assertEquals(2 + 3 * 4, 14);
        assertEquals((2 + 3) * 4, 20);
        assertEquals(2 * 3 + 4, 10);
        assertEquals(2 - 3 + 4, 3);
        assertEquals(2 + 4 / 2, 4);
        assertEquals((2 + 4) / 2, 3);
    }

    @Test
    public void notSoSimpleOperations() {
        assertEquals(1 / 2, 0);
        assertEquals(3 / 2, 1);
        assertEquals(1 % 2, 1);
        assertEquals(3 % 2, 1);
    }

    @Test
    public void minusMinusVariableMinusMinus() {
        int i = 1;
        assertEquals(--i, 0);
        assertEquals(i, 0);
        assertEquals(i--, 0);
        assertEquals(i, -1);
    }

    @Test
    public void plusPlusVariablePlusPlus() {
        int i = 1;
        assertEquals(++i, 2);
        assertEquals(i, 2);
        assertEquals(i++, 2);
        assertEquals(i, 3);
    }

    @Test
    public void timesAndDivInPlace() {
        int i = 1;
        i *= 2;
        assertEquals(i, 2);
        i /= 2;
        assertEquals(i, 1);
    }

}
