package shoppinglist.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;

import shoppinglist.db.TempDb;
import shoppinglist.dbBoundary.IDatabase;
import shoppinglist.lmerge.ListElement;
import shoppinglist.lmerge.Quantity;
import shoppinglist.shared.ShoppingList;

public class TempDbTest {
    
    @Test
    public void testAddShoppingList() {
        IDatabase db=new TempDb();
        String name=new String("Name");

        ShoppingList list=new ShoppingList(name);
        list.elements.add(new ListElement("Reis", new Quantity(2)));

        db.addShoppingList(list);
        Set<String> names=db.getShoppingListNames();
        assertTrue(names.contains(name));
        ShoppingList listResult=db.getShoppingList(name);
        assertTrue(list.equals(listResult));
        list.elements.add(new ListElement("Reis", new Quantity(2)));
        list.name="test";
        assertFalse(list.equals(listResult));
    }

    @Test
    public void testAddListWithExistingName(){
        IDatabase db=new TempDb();
        ShoppingList list1=new ShoppingList("list");
        ShoppingList list2=new ShoppingList("list");
        ShoppingList list3=new ShoppingList("list");

        assertEquals("list",db.addShoppingList(list1));
        assertEquals("list2",db.addShoppingList(list2));
        assertEquals("list3",db.addShoppingList(list3));
    }

    @Test
    public void testUpdateShoppingList(){
        IDatabase db=new TempDb();
        String name=new String("Name");
        ShoppingList list=new ShoppingList(name);
        list.elements.add(new ListElement("Reis", new Quantity(2)));
        db.addShoppingList(list);
        ShoppingList listResult=db.getShoppingList(name);
        assertEquals(listResult.elements.size(), 1);
        list.elements.add(new ListElement("Nudeln", new Quantity(3)));
        db.updateShoppingList(list.name,list);
        listResult=db.getShoppingList(name);
        assertEquals(2, listResult.elements.size());
    }

    @Test 
    public void testUpdateNotExistingList(){
        IDatabase db=new TempDb();
        ShoppingList list=new ShoppingList("list");
        ShoppingList listUpdate=new ShoppingList("listUpdate");
        list.elements.add(new ListElement("Reis", new Quantity(2)));
        db.addShoppingList(list);
        list.elements.add(new ListElement("Nudeln", new Quantity(3)));
        assertEquals(listUpdate.name,db.updateShoppingList(listUpdate.name,listUpdate));
        assertTrue(db.getShoppingListNames().contains("list"));
        assertTrue(db.getShoppingListNames().contains("listUpdate"));
    }
}
