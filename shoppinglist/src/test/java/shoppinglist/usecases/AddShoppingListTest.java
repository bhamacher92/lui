package shoppinglist.usecases;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import junit.framework.TestCase;

import shoppinglist.lmerge.ListElement;
import shoppinglist.shared.ShoppingList;
import shoppinglist.uiBoundary.ShoppingList.IAddShoppingList;
import shoppinglist.uiBoundary.ShoppingList.IPullExistingShoppingLists;
import shoppinglist.uiBoundary.ShoppingList.IUpdateShoppingList;
import shoppinglist.usecases.helpers.DbSpy;

import org.springframework.context.annotation.ComponentScan;



@ComponentScan
public class AddShoppingListTest extends TestCase{

    //@Autowired
    private IAddShoppingList addShoppingList;

    //@Autowired
    private IUpdateShoppingList updateShoppingList;
    
    //@Autowired
    private IPullExistingShoppingLists pullShoppingList;
    
    //@Autowired
    DbSpy db;

    @Override
    protected void setUp(){
        // UseShoppingList interactor =  new UseShoppingList();
        // this.addShoppingList = interactor;
        // this.updateShoppingList = interactor;
        // this.pullShoppingList = interactor;
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
 