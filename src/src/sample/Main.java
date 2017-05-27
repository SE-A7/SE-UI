package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main extends Application {

    private static Scene mainApplicationPage;

    private static final String emptyInputString = "Cannot render preview, you haven't something.";
    private static final String EMPTY_URL_ERROT = "No url inserted";
    private static final String INVALID_URL_ERROR = "The url you've entered is not valid";

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("XWiki Convertor");

        VBox layout = new VBox();
        layout.setAlignment(Pos.BASELINE_CENTER);
        layout.setSpacing(350);

        Text label = new Text("Welcome to XWiki Convertor");
        label.setId("welcome");
        Button okButton = new Button("Let's start");

        okButton.setOnAction(e-> primaryStage.setScene(mainApplicationPage));
        okButton.setId("ok");

        layout.getChildren().addAll(label, okButton);

        layout.setId("root");

        Scene scene = new Scene(layout, 800, 600);

        String css = this.getClass().getResource("../resources/style.css").toExternalForm();
        scene.getStylesheets().add(css);

        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);

        // main page
        BorderPane mainPage = new BorderPane();
        mainPage.setId("main-page");
        mainApplicationPage = new Scene(mainPage, 800, 600);
        mainApplicationPage.setFill(Color.OLDLACE);
        mainApplicationPage.getStylesheets().add(css);
        MenuBar menuBar = new MenuBar();
        menuBar.setId("menu-bar");

        Menu menuFile = new Menu("File");
        Menu menuOptions = new Menu("Options");


        MenuItem saveAs = new MenuItem("Save As");
        MenuItem save = new MenuItem("Save");
        MenuItem export = new MenuItem("Export");
        MenuItem search = new MenuItem("Search");
        MenuItem replace = new MenuItem("Replace");

        MenuItem syntaxVersionOptions = new MenuItem("Syntax Version Options");
        MenuItem customRulesCreator = new MenuItem("Custom Rules Creator");
        MenuItem miscellaneousOptions = new MenuItem("Miscellaneous Options");
        menuOptions.getItems().addAll(syntaxVersionOptions, customRulesCreator, miscellaneousOptions);
        menuOptions.setId("menu-options");
        menuFile.getItems().addAll(save, saveAs, export, search, replace);

        syntaxVersionOptions.setOnAction(event -> SyntaxVersionOptionsPanel.display());
        customRulesCreator.setOnAction(event -> CustomRulesCreatorPanel.display());
        miscellaneousOptions.setOnAction(event -> MiscelaneousOptionsPanel.display());

        menuBar.getMenus().addAll(menuFile, menuOptions);

        Label label2 = new Label("Code from URL:");
        label2.setId("label-code");
        label2.setContentDisplay(ContentDisplay.LEFT);

        TextField url = new TextField();
        url.setPromptText("Enter URL here");
        url.setPrefWidth(300);
        Button getUrlButton = new Button("Get from URL");

        HBox hbox = new HBox();
        hbox.setSpacing(50);
        hbox.setId("url-and-button");
        hbox.setAlignment(Pos.CENTER_LEFT);
        hbox.getChildren().addAll(label2, url, getUrlButton);

        Label label3 = new Label("Enter code here:");
        label3.setId("label-code");
        label3.setStyle("-fx-padding: 15px 0;");

        TextArea xwikiCode = new TextArea();
        xwikiCode.setFont(Font.font("Verdana", FontWeight.NORMAL, 15));
        xwikiCode.setPromptText("Or enter your code here");

        xwikiCode.setPrefRowCount(17);

        Button convertButton = new Button("Convert");
        Button previewButton = new Button("Preview");
        previewButton.setOnAction(event -> {
            if (xwikiCode.getText().length() == 0) {
                ErrorWindow.displayError(emptyInputString);
                new AppConfig().saveConfig();
            } else {
                PreviewWindow.displayPreview(XWikiToHtmlRenderer.convert(xwikiCode.getText()));
            }
        });

        getUrlButton.setOnAction(event -> {
            if (url.getText().length() == 0) {
                ErrorWindow.displayError(EMPTY_URL_ERROT);
            } else {
                try {
                    xwikiCode.setText(RemoteFileRetriever.getFile(url.getText()));
                } catch (IOException e) {
                    ErrorWindow.displayError(INVALID_URL_ERROR);
                }
            }
        });

        HBox hboxButtons = new HBox();
        hboxButtons.setAlignment(Pos.CENTER);
        hboxButtons.getChildren().addAll(convertButton, previewButton);

        hboxButtons.setSpacing(150);
        hboxButtons.setPrefHeight(80);

        VBox urlAndCode = new VBox();
        urlAndCode.setFillWidth(false);
        urlAndCode.setMargin(hbox, new Insets(50));
        urlAndCode.setAlignment(Pos.CENTER);
        urlAndCode.getChildren().addAll(hbox, label3, xwikiCode);

        mainPage.setTop(menuBar);
        mainPage.setBottom(hboxButtons);
        mainPage.setCenter(urlAndCode);

        saveAs.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();

            FileChooser.ExtensionFilter extFilterTxt  = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            FileChooser.ExtensionFilter extFilterHtml = new FileChooser.ExtensionFilter("HTML files (*.html)", "*.html");
            FileChooser.ExtensionFilter extFilterPdf  = new FileChooser.ExtensionFilter("PDF files (*.pdf)" , "*.pdf");
            fileChooser.getExtensionFilters().addAll(extFilterTxt, extFilterHtml, extFilterPdf);

            File file = fileChooser.showSaveDialog(primaryStage);
            if (file != null){
                SaveFile(xwikiCode.getText(), file);
            }
        });
        export.setOnAction(e-> ExportWindow.displayExport());

        search.setOnAction(e->System.out.println("stub"));
        replace.setOnAction(e->System.out.println("stub"));

        search.setAccelerator(new KeyCodeCombination(KeyCode.F, KeyCombination.CONTROL_DOWN));
        replace.setAccelerator(new KeyCodeCombination(KeyCode.R, KeyCombination.CONTROL_DOWN));
    }


    private void SaveFile(String content, File file){
        try {
            FileWriter fileWriter = null;

            fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
