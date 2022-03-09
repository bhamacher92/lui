module weshopfaster {
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires spring.context;
    requires spring.core;
    requires spring.beans;

    opens shoppinglist.lui to javafx.fxml;
    opens shoppinglist to spring.core;

    exports shoppinglist;
    exports shoppinglist.backend;
    exports shoppinglist.lui;
    exports shoppinglist.uiBoundary;
    exports shoppinglist.uiBoundary.ShoppingList;
    exports shoppinglist.uiBoundary.Recipe;
    exports shoppinglist.dbBoundary;
    exports shoppinglist.shared;
    exports shoppinglist.db;
    exports shoppinglist.sconvert;
    exports shoppinglist.lmerge;
}
