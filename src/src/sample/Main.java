package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.print.DocFlavor;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;

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

        Menu menuFile = new Menu("File");
        Menu menuSave = new Menu("Save");
        Menu menuSaveAs = new Menu("Save as");
        Menu menuExport = new Menu("Export");
        Menu menuOptions = new Menu("Options");

        onAction(menuSaveAs);
        menuSaveAs.setOnAction(e->{
            FileChooser fileChooser = new FileChooser();

            FileChooser.ExtensionFilter extFilterTxt  = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            FileChooser.ExtensionFilter extFilterHtml = new FileChooser.ExtensionFilter("HTML files (*.html)", "*.html");
            FileChooser.ExtensionFilter extFilterPdf  = new FileChooser.ExtensionFilter("PDF files (*.pdf)" , "*.pdf");
            fileChooser.getExtensionFilters().addAll(extFilterTxt, extFilterHtml, extFilterPdf);

            File file = fileChooser.showSaveDialog(primaryStage);
            if(file != null){
                SaveFile("heicf", file);
            }
        });


        MenuItem syntaxVersionOptions = new MenuItem("Syntax Version Options");
        MenuItem customRulesCreator = new MenuItem("Custom Rules Creator");
        MenuItem miscellaneousOptions = new MenuItem("Miscellaneous Options");
        menuOptions.getItems().addAll(syntaxVersionOptions, customRulesCreator, miscellaneousOptions);

        syntaxVersionOptions.setOnAction(event -> SyntaxVersionOptionsPanel.display());
        miscellaneousOptions.setOnAction(event -> MiscelaneousOptionsPanel.display());

        menuBar.getMenus().addAll(menuFile, menuSave, menuSaveAs, menuExport, menuOptions);

        TextField url = new TextField();
        url.setPromptText("Enter URL here");
        url.setPrefWidth(300);
        Button getUrlButton = new Button("Get from URL");

        HBox hbox = new HBox();
        hbox.setSpacing(100);
        hbox.setId("url-and-button");
        hbox.setMargin(url, new Insets(0, 0, 0, 150));
        hbox.getChildren().addAll(url, getUrlButton);

        TextArea xwikiCode = new TextArea();
        xwikiCode.setPromptText("Or enter your code here");
        xwikiCode.setPrefColumnCount(55);
        xwikiCode.setPrefRowCount(17);

        Button convertButton = new Button("Convert");
        Button previewButton = new Button("Preview");
        previewButton.setOnAction(event -> {
            if (xwikiCode.getText().length() == 0) {
                ErrorWindow.displayError(emptyInputString);
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
        hboxButtons.setMargin(convertButton, new Insets(0, 0, 20, 0));
        hboxButtons.setMargin(previewButton, new Insets(0, 0, 20, 0));
        hboxButtons.setSpacing(100);

        VBox urlAndCode = new VBox();
        urlAndCode.setFillWidth(false);
        urlAndCode.setMargin(hbox, new Insets(50, 50, 50, 50));
        urlAndCode.setAlignment(Pos.CENTER);
        urlAndCode.getChildren().addAll(hbox, xwikiCode);

        mainPage.setTop(menuBar);
        mainPage.setBottom(hboxButtons);
        mainPage.setCenter(urlAndCode);

    }

    public static void onAction(Menu menu) {
        final MenuItem menuItem = new MenuItem();

        menu.getItems().add(menuItem);
        menu.addEventHandler(Menu.ON_SHOWN, event -> menu.hide());
        menu.addEventHandler(Menu.ON_SHOWING, event -> menu.fire());
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
