package db;

import java.util.*;

import dbBoundary.*;
import shared.Recipe;
import shared.ShoppingList;

public class TempDb implements IDatabase{
    public TempDb(){
        shoppinglists=new HashMap<String,ShoppingList>();
    }

    public void addRecipe(Recipe recipe){

    }
    public void addShoppingList(ShoppingList shoppingList){
        shoppinglists.put(shoppingList.name,new ShoppingList(shoppingList));
    }
    public Set<String> getShoppingListNames(){
        return shoppinglists.keySet();
    }
    public Set<String> getRecipeNames(){
        return new HashSet<String>();
    }
    
    public ShoppingList getShoppingList(String name){
        if(shoppinglists.containsKey(name) ){
            return shoppinglists.get(name);
        }
        return new ShoppingList();
    }

    public Recipe getRecipe(String name){
        return new Recipe();
    }


    private Map<String,ShoppingList> shoppinglists;

}
