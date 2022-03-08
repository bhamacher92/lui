package shoppinglist;
import db.TempDb;
import lui.LuiWrapper;
import uiBoundary.*;

public class App {
        public static void main(String[] args) {
        
        ILui ui = new LuiWrapper();

        IShoppingList bl = new ShoppingList(ui,new TempDb());   

        ui.exec();
    }

}