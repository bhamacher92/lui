package lui;

import java.io.IOException;

import javafx.fxml.FXML;

public class StartScreenController {
    
    @FXML
    public void handleAddList(){
        try {
            LuiWrapper.setRoot("list",new ListController());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
