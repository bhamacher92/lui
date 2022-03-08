package dbBoundary;

import java.util.*;

import shared.Recipe;
import shared.ShoppingList;

public interface IDatabase {
    public void addRecipe(Recipe recipe);
    public void addShoppingList(ShoppingList shoppingList);
    public Set<String> getShoppingListNames();
    public Set<String> getRecipeNames();
    
    public ShoppingList getShoppingList(String name);
    public Recipe getRecipe(String name);
}
