package sample;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class NewContactController extends Controller implements Initializable {
    @FXML private TextField Main_TextField_name;
    @FXML private TextField Main_TextField_line;
    @FXML private TextField Main_TextField_email;
    @FXML private TextField Main_TextField_phone;
    @FXML private Button Main_Button_yes;
    @FXML private Button Main_Button_cancel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setAllEventAction();
    }

    private void setAllEventAction() {
        Main_Button_yes.setOnAction(event -> {
            clickOnYes();
        });
    }

    private void clickOnYes() {
        String[] tempPhone = new String[1];
        tempPhone[0] = Main_TextField_phone.getText();

        try {
            MainController controller = (MainController) Controller.getController("Main.fxml");
            JsonContact contact = controller.getContact();
            contact.registerContact(Main_TextField_name.getText(), Main_TextField_line.getText(), Main_TextField_email.getText(), tempPhone);
            controller.updateListView();
        } catch (Exception e ) {

        }

    }

}