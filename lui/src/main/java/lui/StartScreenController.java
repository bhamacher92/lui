package lui;

import java.io.IOException;

import javafx.fxml.FXML;

public class StartScreenController {
    
    @FXML
    public void handleAddList(){
        try {
            App.setRoot("list");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
