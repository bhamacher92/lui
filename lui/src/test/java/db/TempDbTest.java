package db;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;

import dbBoundary.IDatabase;
import dbBoundary.ShoppingList;
import lmerge.ListElement;
import lmerge.Quantity;

public class TempDbTest {
    
    @Test
    public void testAddShoppingList() {
        IDatabase db=new TempDb();
        String name=new String("Name");

        ShoppingList list=new ShoppingList(name);
        list.elements.add(new ListElement("Reis", new Quantity(2)));

        db.addShoppingList(name, list);
        Set<String> names=db.getShoppingListNames();
        assertTrue(names.contains(name));
        ShoppingList listResult=db.getShoppingList(name);
        assertTrue(list.equals(listResult));
        list.elements.add(new ListElement("Reis", new Quantity(2)));
        list.name="test";
        assertFalse(list.equals(listResult));
    }
}
