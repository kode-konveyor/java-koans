package java7;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static tools.Constants.__;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AboutDiamondOperator {

    private String[] animals = new String[] {"Dog", "Cat", "Tiger", "Elephant", "Zebra"};;

	@Test
    public void diamondOperator() {
        //Generic type of array list inferred - empty <> operator
        List<String> animalsList = new ArrayList<>(Arrays.asList(animals));
        assertEquals(animalsList, __);
    }

    @Test
    public void diamondOperatorInMethodCall() {
        //type of new ArrayList<>() inferred from method parameter
        List<String> animalsList = fill(new ArrayList<>());
        assertEquals(animalsList, __);
    }

    private List<String> fill(List<String> list) {
        list.addAll(Arrays.asList(animals));
        return list;
    }

}
