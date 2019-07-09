package intermediate;

import org.junit.jupiter.api.Test;

import static tools.Constants.__;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class AboutEquality {
    private static final String REMOVE_THIS_LINE = "Remove this after you've implemented Car.equals";

	// This suite of Koans expands on the concepts introduced in beginner.AboutEquality

    @Test
    public void sameObject() {
        Object a = new Object();
        Object b = a;
        assertEquals(a == b, __);
    }

    @Test
    public void equalObject() {
        Integer a = Integer.valueOf(1);
        Integer b = Integer.valueOf(1);
        assertEquals(a.equals(b), __);
        assertEquals(b.equals(a), __);
    }

    @Test
    public void noObjectShouldBeEqualToNull() {
        assertEquals(new Object().equals(null), __);
    }

    static class Car {
        @SuppressWarnings("unused")
		private String name = "";
        @SuppressWarnings("unused")
        private int horsepower = 0;

        public Car(String s, int p) {
            name = s;
            horsepower = p;
        }

        @Override
        public boolean equals(Object other) {
            // Change this implementation to match the equals contract
            // Car objects with same horsepower and name values should be considered equal
            // http://download.oracle.com/javase/6/docs/api/java/lang/Object.html#equals(java.lang.Object)
            return false;
        }

        @Override
        public int hashCode() {
            // @see http://download.oracle.com/javase/6/docs/api/java/lang/Object.html#hashCode()
            return super.hashCode();
        }
    }

    @Test
    public void equalForOwnObjects() {
        Car car1 = new Car("Beetle", 50);
        Car car2 = new Car("Beetle", 50);
        // @see Car.equals (around line 45) for the place to solve this
        assertEquals(car1.equals(car2), true);
        assertEquals(car2.equals(car1), true);
    }

    @Test
    public void unequalForOwnObjects() {
        Car car1 = new Car("Beetle", 50);
        Car car2 = new Car("Porsche", 300);
        // @see Car.equals (around line 45) for the place to solve this
        fail(REMOVE_THIS_LINE);
        assertEquals(car1.equals(car2), false);
    }

    @Test
    public void unequalForOwnObjectsWithDifferentType() {
        Car car1 = new Car("Beetle", 50);
        String s = "foo";
        // @see Car.equals (around line 45) for the place to solve this
        fail(REMOVE_THIS_LINE);
        assertEquals(car1.equals(s), false);
    }

    @Test
    public void equalNullForOwnObjects() {
        Car car1 = new Car("Beetle", 50);
        // @see Car.equals (around line 45) for the place to solve this
        fail(REMOVE_THIS_LINE);
        assertEquals(car1.equals(null), false);
    }

    @Test
    public void ownHashCode() {
        // As a general rule: When you override equals you should override
        // hash code
        // Read the hash code contract to figure out why
        // http://download.oracle.com/javase/6/docs/api/java/lang/Object.html#hashCode()

        // Implement Car.hashCode around line 51 so that the following assertions pass
        Car car1 = new Car("Beetle", 50);
        Car car2 = new Car("Beetle", 50);
        assertEquals(car1.equals(car2), true);
        assertEquals(car1.hashCode() == car2.hashCode(), true);
    }

    static class Chicken {
        String color = "green";

        @Override
        public int hashCode() {
            return 4000;
        }

        @Override
        public boolean equals(Object other) {
            if (!(other instanceof Chicken))
                return false;
            return ((Chicken) other).color.equals(color);
        }
    }

    @Test
    public void ownHashCodeImplementationPartTwo() {
        Chicken chicken1 = new Chicken();
        chicken1.color = "black";
        Chicken chicken2 = new Chicken();
        assertEquals(chicken1.equals(chicken2), __);
        assertEquals(chicken1.hashCode() == chicken2.hashCode(), __);
        // Does this still fit the hashCode contract? Why (not)?
        // Fix the Chicken class to correct this.
    }

}
