package shoppinglist.usecases;

import uiBoundary.ShoppingList.*;

import java.util.Set;

import dbBoundary.IDatabase;
import shared.*;

public class UseShoppingList implements IAddShoppingList, IUpdateShoppingList, IPullExistingShoppingLists {

   private IDatabase db;
   
   public UseShoppingList(IDatabase db){
    this.db=db;
   }

   public String addShoppingList(ShoppingList shoppingList){
      return db.addShoppingList(shoppingList);
   } 

   public String updateShoppingList(String name,ShoppingList shoppingList){
      return db.updateShoppingList(name,shoppingList);
   }

   @Override
   public Set<String> pullExistingShoppingLists() {
      return  db.getShoppingListNames();
   }
}
