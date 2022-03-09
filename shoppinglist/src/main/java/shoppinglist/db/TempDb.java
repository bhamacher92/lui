package shoppinglist.db;

import java.util.*;

import org.springframework.stereotype.Component;

import shoppinglist.dbBoundary.*;
import shoppinglist.shared.Recipe;
import shoppinglist.shared.ShoppingList;

@Component
public class TempDb implements IDatabase{
    public TempDb(){
        shoppinglists=new HashMap<String,ShoppingList>();
    }

    public String addRecipe(Recipe recipe){
        return new String();
    }

    public String updateRecipe(String name, Recipe Recipe){
        return new String();
    }

    public String addShoppingList(ShoppingList shoppingList){
        String name=shoppingList.name;
        int append=2;
        while(this.shoppinglists.containsKey(name)){
            name=shoppingList.name+append;
            append++;
        }
        shoppingList.name=name;
        shoppinglists.put(shoppingList.name,new ShoppingList(shoppingList));
        return shoppingList.name;
    }

    public String updateShoppingList(String name, ShoppingList shoppingList){
        try {
            shoppinglists.remove(name);
            return addShoppingList(shoppingList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String();
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
