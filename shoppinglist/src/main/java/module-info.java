module weshopfaster {
    requires transitive javafx.controls;
    requires javafx.fxml;

    opens lui to javafx.fxml;

    exports shoppinglist;
    exports shoppinglist.usecases;
    exports lui;
    exports uiBoundary;
    exports uiBoundary.ShoppingList;
    exports uiBoundary.Recipe;
    exports dbBoundary;
    exports shared;
    exports db;
    exports sconvert;
    exports lmerge;
}
