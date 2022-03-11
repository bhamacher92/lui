package shoppinglist.lui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

@Component
public class StartScreenController implements Initializable {
    

    @FXML
    ListView<String> listslist;


    @Autowired
    ListController listController;

    StartScreenController(){

    }


    @Override
    public void initialize(URL l, ResourceBundle resources) {

    }

    @FXML
    public void handleAddList(){
        try {
            LuiWrapper.setRoot("list",listController);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
