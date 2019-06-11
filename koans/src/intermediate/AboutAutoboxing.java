package intermediate;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static tools.Constants.__;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AboutAutoboxing {

    @Test
    public void addPrimitivesToCollection() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(0, Integer.valueOf(42));
        assertEquals(list.get(0), __);
    }

    @Test
    public void addPrimitivesToCollectionWithAutoBoxing() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(0, 42);
        assertEquals(list.get(0), __);
    }

    @Test
    public void migrateYourExistingCodeToAutoBoxingWithoutFear() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(0, Integer.valueOf(42));
        assertEquals(list.get(0), __);

        list.add(1, 84);
        assertEquals(list.get(1), __);
    }

    @Test
    public void allPrimitivesCanBeAutoboxed() {
        List<Double> doubleList = new ArrayList<Double>();
        doubleList.add(0, Double.valueOf(42));
        assertEquals(doubleList.get(0), __);

        List<Long> longList = new ArrayList<Long>();
        longList.add(0, Long.valueOf(42));
        assertEquals(longList.get(0), __);

        List<Character> characterList = new ArrayList<Character>();
        characterList.add(0, Character.valueOf('z'));
        assertEquals(characterList.get(0), __);
    }

}
