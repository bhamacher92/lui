package shoppinglist.uiBoundary.ShoppingList;

import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public interface IPullExistingShoppingLists {
    Set<String> pullExistingShoppingLists();
}
