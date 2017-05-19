package sample;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ErrorWindow {

    public static void displayError(String errorMessage){
        Stage window = new Stage();
        Label errorLabel = new Label(errorMessage);
        VBox layout = new VBox();
        layout.getChildren().add(errorLabel);
        Scene scene = new Scene(layout,300, 300);
        window.setScene(scene);
        window.showAndWait();
    }
}
