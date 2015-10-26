package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 * Created by Kevin on 2015/10/26.
 */
public class Controller {
    static Class currentClass = new Object() { }.getClass().getEnclosingClass();

    public static Controller getController(String fxmlName) throws Exception {
            FXMLLoader fxmlLoader = new FXMLLoader();
            Parent root = fxmlLoader.load(currentClass.getResource(fxmlName).openStream());
            Controller controller = (Controller) fxmlLoader.getController();
            return controller;
    }
}
