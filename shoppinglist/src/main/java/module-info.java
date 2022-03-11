module shoppinglist {
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires spring.context;
    requires spring.core;
    requires spring.beans;

    opens shoppinglist.lui to javafx.fxml, spring.core;
    opens shoppinglist to spring.core;
    opens shoppinglist.backend to spring.core;
    opens shoppinglist.dbBoundary to spring.core;
    opens shoppinglist.db to spring.core;
    opens shoppinglist.uiBoundary.ShoppingList to spring.core;
    opens shoppinglist.uiBoundary.MergeList to spring.core;
    opens shoppinglist.uiBoundary to spring.core;
    opens shoppinglist.lmerge to spring.core;


    exports shoppinglist;
    exports shoppinglist.backend;
    exports shoppinglist.lui;
    exports shoppinglist.uiBoundary;
    exports shoppinglist.uiBoundary.MergeList;
    exports shoppinglist.uiBoundary.ShoppingList;
    exports shoppinglist.uiBoundary.Recipe;
    exports shoppinglist.dbBoundary;
    exports shoppinglist.shared;
    exports shoppinglist.db;
    exports shoppinglist.sconvert;
    exports shoppinglist.lmerge;

    

}
