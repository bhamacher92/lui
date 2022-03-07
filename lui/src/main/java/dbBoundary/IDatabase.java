package dbBoundary;

import java.util.*;

public interface IDatabase {
    public void addRecipe(Recipe recipe);
    public void addShoppingList(String name,ShoppingList shoppingList);
    public Set<String> getShoppingListNames();
    public Set<String> getRecipeNames();
    
    public ShoppingList getShoppingList(String name);
    public Recipe getRecipe(String name);
}
