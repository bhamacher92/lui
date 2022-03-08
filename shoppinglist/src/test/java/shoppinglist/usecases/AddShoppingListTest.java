package shoppinglist.usecases;

import org.junit.Test;

import db.TempDb;
import dbBoundary.IDatabase;
import junit.framework.TestCase;
import lmerge.ListElement;
import shared.ShoppingList;
import shoppinglist.usecases.helpers.DbSpy;
import uiBoundary.ShoppingList.IAddShoppingList;

public class AddShoppingListTest extends TestCase{

    private IAddShoppingList addShoppingList;
    private DbSpy db;
    
    @Override
    protected void setUp(){
        db = new DbSpy();
        this.addShoppingList = new AddShoppingList(db);
    }

    @Test
    public void testAddShoppingList() {
        ShoppingList list=new ShoppingList("test");
        list.elements.add(new ListElement("Reis"));
        addShoppingList.addShoppingList(list);
        assertTrue(db.shoppinglistAdded.name.equals("test"));
    }
}
