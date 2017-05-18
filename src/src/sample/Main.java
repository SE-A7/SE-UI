package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

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

        okButton.setOnAction(e-> System.out.println("Switch scene"));
        okButton.setId("ok");
        layout.getChildren().addAll(label, okButton);


        layout.setId("root");

        Scene scene = new Scene(layout, 800, 600);

        String css = this.getClass().getResource("../resources/style.css").toExternalForm();
        scene.getStylesheets().add(css);

        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
