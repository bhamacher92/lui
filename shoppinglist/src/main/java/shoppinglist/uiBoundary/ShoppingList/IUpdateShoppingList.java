package shoppinglist.uiBoundary.ShoppingList;

import org.springframework.stereotype.Component;

import shoppinglist.shared.ShoppingList;

@Component
public interface IUpdateShoppingList {
    public String updateShoppingList(String name, ShoppingList shoppingList);
}
