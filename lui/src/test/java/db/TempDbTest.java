package db;

import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;

import dbBoundary.IDatabase;
import dbBoundary.ShoppingList;

public class TempDbTest {
    @Test
    public void testAddShoppingList() {
        IDatabase db=new TempDb();
        db.addShoppingList("Blub", new ShoppingList());
        Set<String> names=db.getShoppingListNames();
        assertTrue(names.contains("Blub"));
    }

}
