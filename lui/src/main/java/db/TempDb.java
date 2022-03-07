package db;

import java.util.*;

import dbBoundary.*;

public class TempDb implements IDatabase{
    TempDb(){
        shoppinglists=new HashMap<String,ShoppingList>();
    }

    public void addRecipe(Recipe recipe){

    }
    public void addShoppingList(String name,ShoppingList shoppingList){
        shoppinglists.put(name,shoppingList);
    }
    public Set<String> getShoppingListNames(){
        return shoppinglists.keySet();
    }
    public Set<String> getRecipeNames(){
        return new HashSet<String>();
    }
    
    public ShoppingList getShoppingList(String name){
        return new ShoppingList();
    }
    public Recipe getRecipe(String name){
        return new Recipe();
    }


    private Map<String,ShoppingList> shoppinglists;

}
