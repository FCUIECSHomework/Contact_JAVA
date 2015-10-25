package sample;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML private ListView<String> Main_ListView_lv1;
    @FXML private Button Main_Button_newContact;
    @FXML private Button Main_Button_editContact;
    @FXML private Button Main_Button_deleteContact;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setAllEventAction();

        ObservableList<String> items = Main_ListView_lv1.getItems();
        Main_ListView_lv1.setFixedCellSize(50);
        items.add("One");
        items.add("Two");
        items.add("Three");
        items.add("Four");
        items.add("Five");

    }

    private void setAllEventAction() {
        Main_Button_newContact.setOnAction(event -> {
            createNewWindow("NewContact");
        });

        Main_Button_editContact.setOnAction(event -> {
//            createNewWindow("EditContact");
        });

        Main_Button_deleteContact.setOnAction(event -> {
//            createNewWindow("DeleteContact");
        });
    }

    private void createNewWindow(String fxmlName) {
        NewWindow newContact = new NewWindow(fxmlName);
    }




}