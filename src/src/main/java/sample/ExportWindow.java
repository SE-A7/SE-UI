package sample;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;

public class ExportWindow {

    public static void displayExport(){
        Stage window = new Stage();
        window.setTitle("File Export");
        Button button = new Button("Save");

        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll(
                "PDF",
                "ODT",
                "HTML"
        );
        comboBox.setPromptText("Choose a format..");

        button.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();

            FileChooser.ExtensionFilter extFilter = null;
            if(comboBox.getValue().equals("PDF")) {
                extFilter = new FileChooser.ExtensionFilter("PDF (*.pdf");
            }
            if(comboBox.getValue().equals("ODT")) {
                extFilter = new FileChooser.ExtensionFilter("OpenDocument Text (.odt)");
            }
            if(comboBox.getValue().equals("HTML")) {
                extFilter = new FileChooser.ExtensionFilter("Web Page (*.html)");
            }

            fileChooser.getExtensionFilters().add(extFilter);
            File file = fileChooser.showSaveDialog(window);
        });

        HBox dropdown = new HBox();
        dropdown.getChildren().addAll(comboBox);
        dropdown.setMargin(comboBox, new Insets(50, 0, 0, 0));
        dropdown.setAlignment(Pos.TOP_CENTER);

        HBox btn = new HBox();
        btn.getChildren().addAll(button);
        btn.setMargin(button, new Insets(20, 0, 0, 0));
        btn.setAlignment(Pos.TOP_CENTER);

        VBox layout = new VBox();
        layout.getChildren().addAll(dropdown, btn);
        layout.setAlignment(Pos.TOP_CENTER);
        layout.setId("main-page");

        Scene scene = new Scene(layout, 250, 175);
        String css = CustomRulesCreatorPanel.class.getResource("../resources/style.css").toExternalForm();
        scene.getStylesheets().add(css);
        window.setScene(scene);
        window.showAndWait();
    }
}
