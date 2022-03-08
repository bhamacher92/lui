package shoppinglist.usecases;

import uiBoundary.ShoppingList.*;
import dbBoundary.IDatabase;
import shared.*;

public class AddShoppingList implements IAddShoppingList {

   private IDatabase db;
   
   public AddShoppingList(IDatabase db){
    this.db=db;
   }

   public String addShoppingList(ShoppingList shoppingList){
    db.addShoppingList(shoppingList);
    return shoppingList.name;
   } 
}
