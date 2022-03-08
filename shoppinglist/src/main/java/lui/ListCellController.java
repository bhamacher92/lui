package lui;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.control.ListCell;
import javafx.scene.control.Label;

import javafx.fxml.FXMLLoader;
import java.io.IOException;

class ListCellController extends ListCell<String> {
        
        @FXML
        private Label element;

        @FXML
        private GridPane gridpane;

        private FXMLLoader mLLoader;

        ListController controller;

        ListCellController(ListController controller){
            this.controller=controller;
        }

        @Override
        public void updateItem(final String item, boolean empty) {
            super.updateItem(item, empty);
            if (item != null) {
                mLLoader = new FXMLLoader(getClass().getResource("listcell.fxml"));
                mLLoader.setController(this);
                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                element.setText(item);
                setText(null);
                setGraphic(gridpane);
            }else{
                setText(null);
                setGraphic(null);
            }
        }

    @FXML
    public void handleRemoveElement(){
            controller.removeElement(this.getIndex());
    }
}



    
