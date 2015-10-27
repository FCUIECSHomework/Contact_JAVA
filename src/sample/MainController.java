package sample;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private ListView<UserObject> Main_ListView_lv1;
    @FXML
    private Button Main_Button_newContact;
    @FXML
    private Button Main_Button_editContact;
    @FXML
    private Button Main_Button_deleteContact;
    @FXML
    private Button Main_Button_SortUID;
    @FXML
    private Button Main_Button_SortLine;

    private javafx.scene.control.Dialog newContactDialog;
    private javafx.scene.control.Dialog editContactDialog;

    private ObservableList<UserObject> listViewUserItems;
    private JsonContact contact1 = new JsonContact();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setAllEventAction();
        setUpListView();
        sortWithUuidAndUpdateListView();
    }

    private void setAllEventAction() {
        Main_Button_newContact.setOnAction(event -> {
            createNewContact();
        });

        Main_Button_editContact.setOnAction(event -> {
            editContact();
        });

        Main_Button_deleteContact.setOnAction(event -> {
            deleteContact();
        });

        Main_Button_SortUID.setOnAction(event -> {
            sortWithUuidAndUpdateListView();
        });

        Main_Button_SortLine.setOnAction(event -> {
            sortWithLineAndUpdateListView();
        });
    }

    private void setUpListView() {
        Main_ListView_lv1.setFixedCellSize(50);
        listViewUserItems = Main_ListView_lv1.getItems();
    }

    public void sortWithLineAndUpdateListView() {
        updateListView();
        listViewUserItems.sort(new UserObjectComparatorWithLine());
    }

    public void sortWithUuidAndUpdateListView() {
        updateListView();
        listViewUserItems.sort(new UserObjectComparator());
    }

    public void updateListView() {
        listViewUserItems.clear();
        UserObject[] tempUser = contact1.getAllContact();
        for (UserObject user : tempUser) {
            listViewUserItems.add(user);
        }
    }

    private void createNewContact() {
        createNewContactWindowAndSetCallBack();
        newContactDialog.showAndWait();
        sortWithUuidAndUpdateListView();
    }

    private void createNewContactWindowAndSetCallBack() {
        newContactDialog = new Dialog();
        newContactDialog.setTitle("New Contact");
        newContactDialog.setHeaderText("Please Enter data of your new contact.");
        newContactDialog.setResizable(true);
        newContactDialog.setResizable(false);

        Label label1 = new Label("Name: ");
        Label label2 = new Label("Line: ");
        Label label3 = new Label("Email: ");
        Label label4 = new Label("Phone: ");
        TextField text1 = new TextField();
        TextField text2 = new TextField();
        TextField text3 = new TextField();
        TextField text4 = new TextField();

        GridPane grid = new GridPane();
        grid.add(label1, 1, 1);
        grid.add(text1, 2, 1);
        grid.add(label2, 1, 2);
        grid.add(text2, 2, 2);
        grid.add(label3, 1, 3);
        grid.add(text3, 2, 3);
        grid.add(label4, 1, 4);
        grid.add(text4, 2, 4);
        newContactDialog.getDialogPane().setContent(grid);

        ButtonType buttonTypeOk = new ButtonType("Okay", ButtonBar.ButtonData.OK_DONE);
        newContactDialog.getDialogPane().getButtonTypes().add(buttonTypeOk);
        newContactDialog.setResultConverter(new Callback<ButtonType, String>() {
            @Override
            public String call(ButtonType b) {
                if (b == buttonTypeOk) {
                    registerContact(text1.getText(), text2.getText(), text3.getText(), text4.getText());
                    return "SUCCESS";
                }
                return "FAILED";
            }
        });
    }

    private void registerContact(String name, String line, String email, String telephone) {
        String temp[] = new String[1];
        temp[0] = telephone;
        contact1.registerContact(name, line, email, temp);
    }

    private void editContact() {
        editContactAndSetCallBack();
        editContactDialog.showAndWait();
        sortWithUuidAndUpdateListView();
    }

    private void editContactAndSetCallBack() {
        UserObject targetUser = Main_ListView_lv1.getSelectionModel().getSelectedItem();
        editContactDialog = new Dialog();
        editContactDialog.setTitle("Edit Contact");
        editContactDialog.setHeaderText("Please Enter new data of your contact.");
        editContactDialog.setResizable(true);
        editContactDialog.setResizable(false);

        Label label1 = new Label("Name: ");
        Label label2 = new Label("Line: ");
        Label label3 = new Label("Email: ");
        Label label4 = new Label("Phone: ");
        TextField text1 = new TextField();
        TextField text2 = new TextField();
        TextField text3 = new TextField();
        TextField text4 = new TextField();

        GridPane grid = new GridPane();
        grid.add(label1, 1, 1);
        grid.add(text1, 2, 1);
        grid.add(label2, 1, 2);
        grid.add(text2, 2, 2);
        grid.add(label3, 1, 3);
        grid.add(text3, 2, 3);
        grid.add(label4, 1, 4);
        grid.add(text4, 2, 4);

        text1.setText(targetUser.getName());
        text2.setText(targetUser.getLine());
        text3.setText(targetUser.getEmail());
        text4.setText(targetUser.getTelephone().get(0));

        editContactDialog.getDialogPane().setContent(grid);

        ButtonType buttonTypeOk = new ButtonType("Okay", ButtonBar.ButtonData.OK_DONE);
        editContactDialog.getDialogPane().getButtonTypes().add(buttonTypeOk);
        editContactDialog.setResultConverter(new Callback<ButtonType, String>() {
            @Override
            public String call(ButtonType b) {
                if (b == buttonTypeOk) {
                    editAndSaveContact(targetUser.getUuid(), text1.getText(), text2.getText(), text3.getText(), text4.getText());
                    return "SUCCESS";
                }
                return "FAILED";
            }
        });
    }

    private void editAndSaveContact(String uuid, String name, String line, String email, String telephone) {
        String temp[] = new String[1];
        temp[0] = telephone;
        contact1.editContact(uuid, name, line, email, temp);
    }

    private void deleteContact() {
        String targetID = Main_ListView_lv1.getSelectionModel().getSelectedItem().getUuid();
        contact1.removeContact(targetID);
        sortWithUuidAndUpdateListView();
    }
}