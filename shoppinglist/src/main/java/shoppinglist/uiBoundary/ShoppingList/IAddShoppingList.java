package shoppinglist.uiBoundary.ShoppingList;

import org.springframework.stereotype.Component;

import shoppinglist.shared.ShoppingList;

@Component
public interface IAddShoppingList {
    public String addShoppingList(ShoppingList shoppingList);
}
