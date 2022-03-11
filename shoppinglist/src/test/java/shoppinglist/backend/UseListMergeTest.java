package shoppinglist.backend;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.TestCase;
import shoppinglist.lmerge.ListElement;
import shoppinglist.lmerge.Merger;
import shoppinglist.lmerge.Quantity;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {UseListMerge.class,Merger.class})
public class UseListMergeTest extends TestCase {

    @Autowired
    private UseListMerge useMerger;

    @Test
    public void testMerge() {
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

        List<ListElement> mergedList = useMerger.merge(listInput);
        assertTrue(elemementsHaveSameQuantity(expectedList, mergedList));
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