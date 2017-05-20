package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MiscelaneousOptionsPanel {

    public static void display() {
        Stage window = new Stage();

        Text syntaxOnOfLabel = new Text("Switch highlighting");
        Text standardSavePath = new Text("Change the standard save path");
        Text standardExportFormat = new Text("Change standard export format");

        syntaxOnOfLabel.setFont(Font.font("verdana", FontPosture.REGULAR, 15));
        syntaxOnOfLabel.setFill(Color.BLACK);

        standardSavePath.setFont(Font.font("verdana", FontPosture.REGULAR, 15));
        standardSavePath.setFill(Color.BLACK);

        standardExportFormat.setFont(Font.font("verdana", FontPosture.REGULAR, 15));
        standardExportFormat.setFill(Color.BLACK);

        RadioButton syntaxHOn = new RadioButton("On");
        RadioButton syntaxHOff = new RadioButton("Off");
        ToggleGroup toggleGroup = new ToggleGroup();
        syntaxHOff.setToggleGroup(toggleGroup);
        syntaxHOn.setToggleGroup(toggleGroup);

        ComboBox exportFormats = new ComboBox();
        Button defaultSavePathPicker = new Button("Choose");
        Button cancelButton = new Button("cancel");
        cancelButton.setOnAction(event -> window.close());
        Button saveButton = new Button("Save");

        VBox layout = new VBox();

        HBox layoutSwitchSyntaxH = new HBox();
        layoutSwitchSyntaxH.getChildren().add(syntaxOnOfLabel);
        layoutSwitchSyntaxH.getChildren().add(syntaxHOn);
        layoutSwitchSyntaxH.getChildren().add(syntaxHOff);
        layoutSwitchSyntaxH.setSpacing(50);
        layoutSwitchSyntaxH.setMargin(syntaxOnOfLabel, new Insets(20, 20, 20, 20));
        layoutSwitchSyntaxH.setMargin(syntaxHOff, new Insets(20, 0, 0, 0));
        layoutSwitchSyntaxH.setMargin(syntaxHOn, new Insets(20, 0, 0, 0));

        HBox layoutChangeSavePath = new HBox();
        layoutChangeSavePath.getChildren().add(standardSavePath);
        layoutChangeSavePath.getChildren().add(defaultSavePathPicker);
        layoutChangeSavePath.setSpacing(50);
        layoutChangeSavePath.setMargin(standardSavePath, new Insets(20, 20, 20, 20));
        layoutChangeSavePath.setMargin(defaultSavePathPicker, new Insets(20, 0, 0, 0));

        HBox layoutChangeExportFormat = new HBox();
        layoutChangeExportFormat.getChildren().add(standardExportFormat);
        layoutChangeExportFormat.getChildren().add(exportFormats);
        layoutChangeExportFormat.setSpacing(50);
        layoutChangeExportFormat.setMargin(standardExportFormat, new Insets(20, 20, 20, 20));
        layoutChangeExportFormat.setMargin(exportFormats, new Insets(20, 0, 0, 20));

        HBox buttons = new HBox();
        buttons.getChildren().add(cancelButton);
        buttons.getChildren().add(saveButton);
        buttons.setSpacing(50);
        buttons.setMargin(cancelButton, new Insets(63, 10, 10, 100));
        buttons.setMargin(saveButton, new Insets(63, 10, 10, 70));

        Scene scene = new Scene(layout);
        layout.getChildren().add(layoutSwitchSyntaxH);
        layout.getChildren().add(layoutChangeSavePath);
        layout.getChildren().add(layoutChangeExportFormat);
        layout.getChildren().add(buttons);

        String css = MiscelaneousOptionsPanel.class.getResource("../resources/style.css").toExternalForm();

        window.setResizable(false);
        window.setWidth(500);
        window.setHeight(300);
        scene.getStylesheets().add(css);
        window.setScene(scene);
        window.show();
    }
}
