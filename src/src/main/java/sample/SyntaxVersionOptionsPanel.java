package main.java.sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


public class SyntaxVersionOptionsPanel  {

    public static void display() {
        Stage stage = new Stage();
        Button button;

        Text text = new Text();
        Text text2 = new Text();

        VBox root = new VBox();
        root.setId("main-page");

        text.setText("Choose the current xWiki version");

        text2.setText("Choose the preffered xWiki version");

        text.setFont(Font.font("verdana", FontPosture.REGULAR, 15));
        text.setFill(Color.BLACK);
        text.setStrokeWidth(2);

        text2.setFont(Font.font("verdana", FontPosture.REGULAR, 15));
        text2.setFill(Color.BLACK);
        text2.setStrokeWidth(2);

        Button savebtn = new Button();
        savebtn.setText("Save");

        Button cancelbtn = new Button();
        cancelbtn.setOnAction(event -> stage.close());
        cancelbtn.setText("Cancel");

        ToggleGroup tg = new ToggleGroup();
        ToggleGroup tg1 = new ToggleGroup();

        RadioButton xWiki1 = new RadioButton("xWiki 1.0");
        RadioButton xWiki2 = new RadioButton("xWiki 1.1");

        RadioButton xWiki3 = new RadioButton("xWiki 2.0");
        RadioButton xWiki4 = new RadioButton("xWiki 2.1");

        xWiki1.setToggleGroup(tg);
        xWiki2.setToggleGroup(tg);

        xWiki3.setToggleGroup(tg1);
        xWiki4.setToggleGroup(tg1);

        HBox hbox = new HBox();
        HBox hbox1 = new HBox();
        HBox hbox2 = new HBox();
        HBox hboxText1 = new HBox();
        HBox hboxText2 = new HBox();

        hbox.getChildren().addAll(xWiki1 , xWiki2);

        hbox.setSpacing(50);
        hbox.setAlignment(Pos.CENTER);
        hbox.setMargin(xWiki1, new Insets(10, 0, 10, 35));
        hbox.setMargin(xWiki2, new Insets(10, 0, 10, 35));

        hbox1.setSpacing(50);
        hbox1.setAlignment(Pos.CENTER);
        hbox1.setMargin(xWiki3, new Insets(10, 0, 10, 35));
        hbox1.setMargin(xWiki4, new Insets(10, 0, 10, 35));

        hbox1.getChildren().addAll(xWiki3 , xWiki4);

        hbox2.getChildren().addAll(cancelbtn , savebtn);

        hbox2.setAlignment(Pos.CENTER);
        hbox2.setMargin(savebtn , new Insets(20, 0, 0, 30));
        hbox2.setMargin(cancelbtn , new Insets(20, 0, 0, 0));

        hboxText1.setAlignment(Pos.CENTER);
        hboxText1.getChildren().add(text);
        hboxText1.setMargin(text, new Insets(20, 0, 0, 0));

        hboxText2.setAlignment(Pos.CENTER);
        hboxText2.getChildren().add(text2);
        hboxText2.setMargin(text2, new Insets(20, 0, 0, 0));

        root.getChildren().addAll(hboxText1, hbox, hboxText2, hbox1, hbox2);

        Scene scene = new Scene(root, 350, 220);
        String css = SyntaxVersionOptionsPanel.class.getResource("../resources/style.css").toExternalForm();

        stage.setTitle("Syntax options");

        stage.setScene(scene);
        stage.setResizable(false);
        scene.getStylesheets().add(css);
        stage.show();
    }
}
