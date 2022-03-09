package shoppinglist.backend;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import shoppinglist.dbBoundary.IDatabase;
import shoppinglist.shared.*;
import shoppinglist.uiBoundary.ShoppingList.*;

@Component
public class UseShoppingList implements IAddShoppingList, IUpdateShoppingList, IPullExistingShoppingLists {
   
   private IDatabase db;
   
  
   public UseShoppingList(){
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
