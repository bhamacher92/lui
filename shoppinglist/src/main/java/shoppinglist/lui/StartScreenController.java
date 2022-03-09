package shoppinglist.lui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

public class StartScreenController implements Initializable {
    

    @FXML
    ListView<String> listslist;


    StartScreenController(){

    }


    @Override
    public void initialize(URL l, ResourceBundle resources) {

    }

    @FXML
    public void handleAddList(){
        try {
            LuiWrapper.setRoot("list",new ListController());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
