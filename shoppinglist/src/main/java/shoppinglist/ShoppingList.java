package shoppinglist;

import dbBoundary.IDatabase;
import shoppinglist.usecases.AddShoppingList;
import uiBoundary.ILui;
import uiBoundary.IShoppingList;

public class ShoppingList implements IShoppingList {
    
    private ILui ui;
    private IDatabase db;

    // usecaseclasses
    private AddShoppingList addShoppingList;

    ShoppingList(ILui ui, IDatabase db){
        this.db=db;
        this.ui=ui;

        this.ui.setShoppingList(this);

        addShoppingList=new AddShoppingList(this.db);
    }


    public AddShoppingList getAddShoppingList(){
        return addShoppingList;
    }
    
}
