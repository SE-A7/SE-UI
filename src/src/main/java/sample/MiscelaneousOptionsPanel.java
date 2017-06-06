package main.java.sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;

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
        exportFormats.getItems().addAll("PDF", "ODT", "HTML");
        exportFormats.setPromptText("Choose");


        Button defaultSavePathPicker = new Button("Choose");
        Button cancelButton = new Button("cancel");
        cancelButton.setOnAction(event -> window.close());
        Button saveButton = new Button("Save");

        VBox layout = new VBox();
        layout.setId("main-page");

        HBox layoutSwitchSyntaxH = new HBox();
        layoutSwitchSyntaxH.getChildren().add(syntaxOnOfLabel);
        layoutSwitchSyntaxH.getChildren().add(syntaxHOn);
        layoutSwitchSyntaxH.getChildren().add(syntaxHOff);
        layoutSwitchSyntaxH.setSpacing(50);
        layoutSwitchSyntaxH.setSpacing(50);
        layoutSwitchSyntaxH.setPrefHeight(50);
        layoutSwitchSyntaxH.setAlignment(Pos.CENTER_LEFT);
        layoutSwitchSyntaxH.setMargin(syntaxOnOfLabel, new Insets(0, 0, 0, 15));

        HBox layoutChangeSavePath = new HBox();
        layoutChangeSavePath.getChildren().add(standardSavePath);
        layoutChangeSavePath.getChildren().add(defaultSavePathPicker);
        layoutChangeSavePath.setSpacing(50);
        layoutChangeSavePath.setPrefHeight(50);
        layoutChangeSavePath.setAlignment(Pos.CENTER_LEFT);
        layoutChangeSavePath.setMargin(standardSavePath, new Insets(0, 0, 0, 15));

        HBox layoutChangeExportFormat = new HBox();
        layoutChangeExportFormat.getChildren().add(standardExportFormat);
        layoutChangeExportFormat.getChildren().add(exportFormats);
        layoutChangeExportFormat.setSpacing(50);
        layoutChangeExportFormat.setPrefHeight(50);
        layoutChangeExportFormat.setAlignment(Pos.CENTER_LEFT);
        layoutChangeExportFormat.setMargin(standardExportFormat, new Insets(0, 0, 0, 15));

        HBox buttons = new HBox();
        buttons.getChildren().add(cancelButton);
        buttons.getChildren().add(saveButton);
        buttons.setSpacing(50);

        Scene scene = new Scene(layout);
        layout.getChildren().add(layoutSwitchSyntaxH);
        layout.getChildren().add(layoutChangeSavePath);
        layout.getChildren().add(layoutChangeExportFormat);
        buttons.setAlignment(Pos.CENTER);
        buttons.setPrefHeight(80);
        layout.getChildren().add(buttons);


        defaultSavePathPicker.setOnAction(e -> {
            DirectoryChooser chooser = new DirectoryChooser();
            chooser.setTitle("Choose default save path");

            File selectedDirectory = chooser.showDialog(window);

        });


        String css = MiscelaneousOptionsPanel.class.getResource("../resources/style.css").toExternalForm();

        window.setResizable(false);

        window.setTitle("Miscelaneous Options");
        scene.getStylesheets().add(css);
        window.setScene(scene);
        window.show();
    }
}
