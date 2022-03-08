package lui;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import shoppinglist.App;

import java.io.IOException;

import uiBoundary.ILui;
import uiBoundary.IShoppingList;

public class LuiWrapper extends Application implements ILui {

    private static Scene scene;
    private IShoppingList shoppingList;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("startScreen",new StartScreenController()), 640, 480);
        scene.getStylesheets().add(getClass().getResource("demo.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    static public void setRoot(String fxml,Object controller) throws IOException {
        scene.setRoot(loadFXML(fxml,controller));
    }

    private static Parent loadFXML(String fxml,Object controller) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/lui/"+fxml + ".fxml"));
        if(controller != null){
            fxmlLoader.setController(controller);
        }
        return fxmlLoader.load();
    }

    public void exec(){
        launch();
    }

    public void setShoppingList(IShoppingList shoppingList){
        this.shoppingList=shoppingList;
    }
}
