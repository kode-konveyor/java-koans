package intermediate;

import org.junit.jupiter.api.Test;

import java.util.*;

import static tools.Constants.__;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class AboutCollections {

    @Test
    public void usingAnArrayList() {
        // List = interface
        // The generic syntax and special generic cases will be handled in
        // AboutGenerics. We just use <String> collections here to keep it
        // simple.
        List<String> list = new ArrayList<String>();
        // ArrayList: simple List implementation
        list.add("Chicken");
        list.add("Dog");
        list.add("Chicken");
        assertEquals(list.get(0), __);
        assertEquals(list.get(1), __);
        assertEquals(list.get(2), __);
    }

    @Test
    public void usingAQueue() {
        // Queue = interface
        Queue<String> queue = new PriorityQueue<String>();
        // PriorityQueue: simple queue implementation
        queue.add("Cat");
        queue.add("Dog");
        assertEquals(queue.peek(), __);
        assertEquals(queue.size(), __);
        assertEquals(queue.poll(), __);
        assertEquals(queue.size(), __);
        assertEquals(queue.poll(), __);
        assertEquals(queue.isEmpty(), __);
    }

    @Test
    public void usingABasicSet() {
        Set<String> set = new HashSet<String>();
        set.add("Dog");
        set.add("Cat");
        set.add("Dog");
        assertEquals(set.size(), __);
        assertEquals(set.contains("Dog"), __);
        assertEquals(set.contains("Cat"), __);
        assertEquals(set.contains("Chicken"), __);
    }

    @Test
    public void usingABasicMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("first key", "first value");
        map.put("second key", "second value");
        map.put("first key", "other value");
        assertEquals(map.size(), __);
        assertEquals(map.containsKey("first key"), __);
        assertEquals(map.containsKey("second key"), __);
        assertEquals(map.containsValue("first value"), __);
        assertEquals(map.get("first key"), __);
    }

    @Test
    public void usingBackedArrayList() {
        String[] array = {"a", "b", "c"};
        List<String> list = Arrays.asList(array);
        list.set(0, "x");
        assertEquals(array[0], __);
        array[0] = "a";
        assertEquals(list.get(0), __);
        // Just think of it as quantum state teleportation...
    }

    @Test
    public void usingBackedSubMap() {
        TreeMap<String, String> map = new TreeMap<String, String>();
        map.put("a", "Aha");
        map.put("b", "Boo");
        map.put("c", "Coon");
        map.put("e", "Emu");
        map.put("f", "Fox");
        SortedMap<String, String> backedMap = map.subMap("c", "f");
        assertEquals(backedMap.size(), __);
        assertEquals(map.size(), __);
        backedMap.put("d", "Dog");
        assertEquals(backedMap.size(), __);
        assertEquals(map.size(), __);
        assertEquals(map.containsKey("d"), __);
        // Again: backed maps are just like those little quantum states
        // that are connected forever...
    }

    @Test
    public void differenceBetweenOrderedAndSorted() {
        TreeSet<String> sorted = new TreeSet<String>();
        sorted.add("c");
        sorted.add("z");
        sorted.add("a");
        assertEquals(sorted.first(), __);
        assertEquals(sorted.last(), __);
        // Look at the different constructors for a TreeSet (or TreeMap)
        // Ponder how you might influence the sort order. Hold that thought
        // until you approach AboutComparison

        LinkedHashSet<String> ordered = new LinkedHashSet<String>();
        ordered.add("c");
        ordered.add("z");
        ordered.add("a");
        StringBuffer sb = new StringBuffer();
        for (String s : ordered) {
            sb.append(s);
        }
        assertEquals(sb.toString(), __);
    }
}
