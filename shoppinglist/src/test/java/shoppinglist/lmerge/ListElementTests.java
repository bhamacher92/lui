package shoppinglist.lmerge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class ListElementTests {

    @Test
    public void testAddIntegerQuantity() {
        ListElement elment1 = new ListElement("Reis", new Quantity(2));
        Quantity quantityToAdd = new Quantity(1);
        Quantity expectedQuantity = new Quantity(3);

        assertEquals(elment1.addQuantity(quantityToAdd).Quantity, expectedQuantity);
    }

    @Test
    public void testEquals() {
        ListElement elment1 = new ListElement("Reis", new Quantity(2));
        ListElement elment2 = new ListElement("Reis", new Quantity(3));
        ListElement elment3 = new ListElement("Mais", new Quantity(2));

        assertTrue(elment1.equals(elment2));
        assertFalse(elment2.equals(elment3));
        assertFalse(elment1.equals(elment3));
    }
}
