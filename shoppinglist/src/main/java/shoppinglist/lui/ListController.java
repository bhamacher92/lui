package shoppinglist.lui;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import shoppinglist.lmerge.ListElement;
import shoppinglist.sconvert.StringConverter;
import shoppinglist.uiBoundary.MergeList.IMergeList;

@Component
public class ListController  implements Initializable {
   
    @Autowired
    private IMergeList merger;

    @Autowired
    private StartScreenController startScreenController;
   
    @FXML
    private ListView<String> listView;

    @FXML
    private TextField input;

    @Override
    public void initialize(URL l, ResourceBundle resources) {
        this.listView.setCellFactory(blub -> new ListCellController(this));
    }

    @FXML
    public void handleAddElement(){
        System.out.println("Button clicked");
        this.listView.getItems().add(this.input.getText());
    }

    @FXML
    public void handleBackToStart(){
        try {
            LuiWrapper.setRoot("startScreen", startScreenController);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleOnKeyPressed(KeyEvent event){
        if (event.getCode().equals(KeyCode.ENTER)) {
            this.listView.getItems().add(this.input.getText());
        

        List<ListElement> listInput=new ArrayList<ListElement>();
        for( String ele : listView.getItems()){
            listInput.add(StringConverter.string2ListElement(ele));
        }
        List<ListElement> mergeResult=merger.merge(listInput);

        this.listView.getItems().clear();
        for( ListElement ele : mergeResult){
            this.listView.getItems().add(StringConverter.listELement2String(ele));
        }        
    }

    }

    public void setList(ArrayList<String> list){

    }

    public void removeElement(int idx){
        listView.getItems().remove(idx);
    }


}
