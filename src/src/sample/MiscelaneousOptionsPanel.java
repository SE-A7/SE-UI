package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;

import javax.swing.*;

public class MiscelaneousOptionsPanel {

    // reconsider changing the return type
    public static void display() {
        Stage window = new Stage();

        Label syntaxOnOfLabel = new Label("Switch highlighting");
        Label standardSavePath = new Label("Change the standard save path");
        Label standardExportFormat = new Label("Change standard export format");
        RadioButton syntaxHOn = new RadioButton("On");
        RadioButton syntaxHOff = new RadioButton("Off");
        ComboBox exportFormats = new ComboBox();
        Button defaultSavePathPicker = new Button("Choose");
        Button cancelButton = new Button("cancel");
        Button saveButton = new Button("Save");

        VBox layout = new VBox();

        HBox layoutSwitchSyntaxH = new HBox();
        layoutSwitchSyntaxH.getChildren().add(syntaxOnOfLabel);
        layoutSwitchSyntaxH.getChildren().add(syntaxHOn);
        layoutSwitchSyntaxH.getChildren().add(syntaxHOff);

        HBox layoutChangeSavePath = new HBox();
        layoutChangeSavePath.getChildren().add(standardSavePath);
        layoutChangeSavePath.getChildren().add(defaultSavePathPicker);

        HBox layoutChangeExportFormat = new HBox();
        layoutChangeExportFormat.getChildren().add(standardExportFormat);
        layoutChangeExportFormat.getChildren().add(exportFormats);

        HBox buttons = new HBox();
        buttons.getChildren().add(cancelButton);
        buttons.getChildren().add(saveButton);

        Scene scene = new Scene(layout);

        layout.getChildren().add(layoutSwitchSyntaxH);
        layout.getChildren().add(layoutChangeSavePath);
        layout.getChildren().add(layoutChangeExportFormat);
        layout.getChildren().add(buttons);

        window.setScene(scene);
        window.showAndWait();
    }
}
