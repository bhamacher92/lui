package shoppinglist;

import dbBoundary.IDatabase;
import shoppinglist.usecases.UseShoppingList;
import uiBoundary.ILui;
import uiBoundary.IShoppingList;

public class ShoppingList implements IShoppingList {
    
    private ILui ui;
    private IDatabase db;

    // usecaseclasses
    private UseShoppingList addShoppingList;

    ShoppingList(ILui ui, IDatabase db){
        this.db=db;
        this.ui=ui;

        this.ui.setShoppingList(this);

        addShoppingList=new UseShoppingList(this.db);
    }


    public UseShoppingList getAddShoppingList(){
        return addShoppingList;
    }
    
}
