package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Kevin on 2015/10/23.
 */
class NewWindow {

    private Stage primaryStage = new Stage();

    public NewWindow(String fxmlName)  {
        createWindow(fxmlName);
    }

    public NewWindow(String fxmlName, int x, int y) {
        createWindow(fxmlName);
        setWindowSize(x, y);
    }

    private void createWindow(String fxmlName) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlName + ".fxml"));
            primaryStage.setScene(new Scene(root, 300, 300));
            primaryStage.setResizable(false);
            primaryStage.show();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    private void setWindowSize(int x, int y) {
        primaryStage.setWidth(x);
        primaryStage.setHeight(y);
    }

    public void setTitle(String title) {
        primaryStage.setTitle(title);
    }
}
