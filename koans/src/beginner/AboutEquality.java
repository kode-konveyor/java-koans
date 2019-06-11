package beginner;

import org.junit.jupiter.api.Test;

import static tools.Constants.__;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AboutEquality {

    @Test
    public void doubleEqualsTestsIfTwoObjectsAreTheSame() {
        Object object = new Object();
        Object sameObject = object;
        assertEquals(object == sameObject, __);
        assertEquals(object == new Object(), __);
    }

    @Test
    public void equalsMethodByDefaultTestsIfTwoObjectsAreTheSame() {
        Object object = new Object();
        assertEquals(object.equals(object), __);
        assertEquals(object.equals(new Object()), __);
    }

    @Test
    public void equalsMethodCanBeChangedBySubclassesToTestsIfTwoObjectsAreEqual() {
        Object object = Integer.valueOf(1);
        assertEquals(object.equals(object), __);
        assertEquals(object.equals(Integer.valueOf(1)), __);
        // Note: This means that for the class 'Object' there is no difference between 'equal' and 'same'
        // but for the class 'Integer' there is difference - see below
    }

    @Test
    public void equalsMethodCanBeChangedBySubclassesToTestsIfTwoObjectsAreEqualExample() {
        Integer value1 = Integer.valueOf(4);
        Integer value2 = Integer.valueOf(2 + 2);
        assertEquals(value1.equals(value2), __);
        assertEquals(value1, __);
    }

    @Test
    public void objectsNeverEqualNull() {
        assertEquals(new Object().equals(null), __);
    }

    @Test
    public void objectsEqualThemselves() {
        Object obj = new Object();
        assertEquals(obj.equals(obj), __);
    }
}
