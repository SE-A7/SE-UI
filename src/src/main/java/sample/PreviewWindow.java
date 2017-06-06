package main.java.sample;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class PreviewWindow {

    /**
     * Displays a new windows with a preview of the xwiki code that is currently
     * inserted in the input box.
     * @param htmlCode The html code that will be displayed in the preview window.
     */
    public static void displayPreview(String htmlCode) {
        Stage window = new Stage();
        VBox layout = new VBox();

        WebView browser = new WebView();
        WebEngine webEngine = browser.getEngine();
        webEngine.loadContent(htmlCode, "text/html");

        layout.getChildren().add(browser);

        Scene scene = new Scene(layout);

        window.setScene(scene);
        window.showAndWait();
    }
}
