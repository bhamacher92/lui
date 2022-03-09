package shoppinglist.dbBoundary;

import java.util.*;

import org.springframework.stereotype.Component;

import shoppinglist.shared.Recipe;
import shoppinglist.shared.ShoppingList;

@Component
public interface IDatabase {
    public String addRecipe(Recipe recipe);
    public String updateRecipe(String name, Recipe recipe);
    public String addShoppingList(ShoppingList shoppingList);
    public String updateShoppingList(String name, ShoppingList shoppingList);
    public Set<String> getShoppingListNames();
    public Set<String> getRecipeNames();
    
    public ShoppingList getShoppingList(String name);
    public Recipe getRecipe(String name);
}
