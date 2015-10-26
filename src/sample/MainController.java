package sample;

import javafx.collections.FXCollections;
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
import java.util.List;
import java.util.ResourceBundle;

public class MainController extends Controller implements Initializable {
    @FXML private ListView<UserObject> Main_ListView_lv1;
    @FXML private Button Main_Button_newContact;
    @FXML private Button Main_Button_editContact;
    @FXML private Button Main_Button_deleteContact;

//    private List<UserObject> listOfUserObject;
    private ObservableList<UserObject> listViewUserItems;
    private JsonContact contact1 = new JsonContact();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setAllEventAction();
        setUpListView();

//        ObservableList<UserObject> myObservableList = FXCollections.observableList(listOfUserObject);
//        Main_ListView_lv1.setItems(myObservableList);
    }

    private void setAllEventAction() {
        Main_Button_newContact.setOnAction(event -> {
            createNewWindow("NewContact", "New Contact");
        });

        Main_Button_editContact.setOnAction(event -> {
//            createNewWindow("NewContact", "Edit Contact");
        });

        Main_Button_deleteContact.setOnAction(event -> {
//            createNewWindow("DeleteContact", "Delete");
        });
    }

    private void setUpListView() {
        Main_ListView_lv1.setFixedCellSize(50);
        listViewUserItems = Main_ListView_lv1.getItems();
    }

    public void updateListView() {
        UserObject[] tempUser = contact1.getAllContact();
        listViewUserItems.clear();
        for (UserObject user : tempUser) {
            listViewUserItems.add(user);
        }

    }

    private void createNewWindow(String fxmlName, String title) {
        NewWindow tempWindow = new NewWindow(fxmlName);
        tempWindow.setTitle(title);
    }

    public JsonContact getContact() {
        return this.contact1;
    }

}