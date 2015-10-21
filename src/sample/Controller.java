package sample;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private ListView<String> Main_ListView_lv1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> items = Main_ListView_lv1.getItems();
        Main_ListView_lv1.setFixedCellSize(50);
        items.add("One");
        items.add("Two");
        items.add("Three");
        items.add("Four");
        items.add("Five");

    }


}
