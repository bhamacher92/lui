package shoppinglist.usecases;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import junit.framework.TestCase;
import lmerge.ListElement;
import shared.ShoppingList;
import shoppinglist.usecases.helpers.DbSpy;
import uiBoundary.ShoppingList.IAddShoppingList;
import uiBoundary.ShoppingList.IPullExistingShoppingLists;
import uiBoundary.ShoppingList.IUpdateShoppingList;

public class AddShoppingListTest extends TestCase{

    private IAddShoppingList addShoppingList;
    private IUpdateShoppingList updateShoppingList;
    private IPullExistingShoppingLists pullShoppingList;
    private DbSpy db;
    
    @Override
    protected void setUp(){
        db = new DbSpy();
        UseShoppingList interactor =  new UseShoppingList(db);
        this.addShoppingList = interactor;
        this.updateShoppingList = interactor;
        this.pullShoppingList = interactor;
    }

    @Test
    public void testAddShoppingList() {
        db.clean();
        ShoppingList list=new ShoppingList("test");
        list.elements.add(new ListElement("Reis"));
        addShoppingList.addShoppingList(list);
        assertTrue(db.shoppinglistAdded.name.equals("test"));
    }

    @Test
    public void testUpdateShoppingList(){
        db.clean();
        ShoppingList list=new ShoppingList("test");
        list.elements.add(new ListElement("Reis"));
        updateShoppingList.updateShoppingList(list.name,list);
        assertTrue(db.shoppinglistAdded.name.equals("test"));
    }

    @Test
    public void testPullExistingShoppingLists(){
        db.clean();
        Set<String> expected = new HashSet<String>();
        expected.add("list1");
        expected.add("list2");
        expected.add("list3");
        db.shoppingListNames=expected;
        Set<String> result = pullShoppingList.pullExistingShoppingLists();
        assertTrue(expected.equals(result));
    }

}
 