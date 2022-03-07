package lmerge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import org.junit.Test;


public class MergerTests {
    
    @Test
    public void correctInputIsReturnedAsIs() {
        Merger Merger = new Merger();

        String input = "Reis";
        assertEquals("Reis", Merger.getName(input));
        assertEquals(input, Merger.getName(input));
    }

    @Test
    public void listOfCorrectInputIsReturnedAsIs() {
        Merger Merger = new Merger();
        List<ListElement> listInput = Arrays.asList(
            new ListElement("Reis", new Quantity(1)),
            new ListElement("Mais", new Quantity(2)),
            new ListElement("Kartoffeln", new Quantity(3)));

        List<ListElement> listInput2 = Arrays.asList(
                new ListElement("Kartoffeln", new Quantity(3)),
                new ListElement("Reis", new Quantity(1)),
                new ListElement("Mais", new Quantity(2)));

        List<ListElement> mergedList = Merger.mergeList(listInput);
        assertTrue(containsSameElements(listInput, mergedList));
        assertTrue(elemementsHaveSameQuantity(listInput2, mergedList));
    }

    @Test
    public void resultDoesNotContainDuplicates() {
        Merger Merger = new Merger();
        List<ListElement> listInput = Arrays.asList(
                new ListElement("Reis"),
                new ListElement("Mais"),
                new ListElement("Kartoffeln"),
                new ListElement("Mais"),
                new ListElement("Reis"));

        assertFalse(containsDuplicates(Merger.mergeList(listInput)));

    }

    @Test
    public void duplicatesQuantityAddsUp() {
        Merger Merger = new Merger();
        List<ListElement> listInput = Arrays.asList(
                new ListElement("Reis", new Quantity(1)),
                new ListElement("Mais", new Quantity(2)),
                new ListElement("Kartoffeln", new Quantity(3)),
                new ListElement("Mais", new Quantity(3)),
                new ListElement("Reis", new Quantity(3)));

        List<ListElement> expectedList = Arrays.asList(
                new ListElement("Reis", new Quantity(4)),
                new ListElement("Mais", new Quantity(5)),
                new ListElement("Kartoffeln", new Quantity(3)));

        List<ListElement> mergedList = Merger.mergeList(listInput);
        assertTrue(elemementsHaveSameQuantity(expectedList, mergedList));
    }

    @Test
    public void duplicatesQuantityAddsUpWIthUnits() {
        Merger Merger = new Merger();
        List<ListElement> listInput = Arrays.asList(
                new ListElement("Reis", new Quantity(1, "kg")),
                new ListElement("Mais", new Quantity(2000, "ml")),
                new ListElement("Kartoffeln", new Quantity(3, "lbs")),
                new ListElement("Mais", new Quantity(3, "l")),
                new ListElement("Reis", new Quantity(3000, "g")),
                new ListElement("Mais", new Quantity(3, "kg")),
                new ListElement("Paprika", new Quantity(3)),
                new ListElement("Mais", new Quantity(3)));

        List<ListElement> expectedList = Arrays.asList(
                new ListElement("Reis", new Quantity(4, "kg")),
                new ListElement("Mais", new Quantity(5, "l")),
                new ListElement("Kartoffeln", new Quantity(3, "lbs")),
                new ListElement("Mais", new Quantity(3, "kg")),
                new ListElement("Paprika", new Quantity(3)),
                new ListElement("Mais", new Quantity(3)));

        List<ListElement> mergedList = Merger.mergeList(listInput);
        assertTrue(elemementsHaveSameQuantity(expectedList, mergedList));
    }

    private boolean containsDuplicates(List<ListElement> mergeList) {
        Set<ListElement> inputSet = new HashSet<>(mergeList);
        return inputSet.size() != mergeList.size();
    }

    private boolean containsSameElements(List<ListElement> list1, List<ListElement> list2){
        if (list1.size() != list2.size())
            return false;

        for (ListElement element : list1) {
            if (!list2.contains(element))
                return false;
        }

        return true;
    } 

    private boolean elemementsHaveSameQuantity(List<ListElement> list1, List<ListElement> list2) {
        if (list1.size() != list2.size())
            return false;
       
        for (ListElement element : list1) {
            int matching = 0;
            if (!list2.contains(element))
                return false;

            for (int i = 0; i < list2.size(); ++i) {
                if (list2.get(i).equals(element)) {
                    if (list2.get(i).Quantity.equals(element.Quantity))
                        matching++;
                }
            }
            if (matching != 1)
                return false;
        }

        return true;
    }

}
