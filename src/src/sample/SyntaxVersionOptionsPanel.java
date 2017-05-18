package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class SyntaxVersionOptionsPanel extends Application {

    Button button;

    @Override
    public void start(Stage stage) {

         Text text = new Text();
         Text text2 = new Text();

         VBox root = new VBox();
         root.setId("main-page");

        text.setText("    \n     Choose the current xWiki version");
        text2.setText("    \n     Choose the preffered xWiki version");


        text.setFont(Font.font("verdana", FontPosture.REGULAR, 15));
        text.setFill(Color.BLACK);
        text.setStrokeWidth(2);

        text2.setFont(Font.font("verdana", FontPosture.REGULAR, 15));
        text2.setFill(Color.BLACK);
        text2.setStrokeWidth(2);

        Button savebtn = new Button();
        savebtn.setText("Save");

        Button cancelbtn = new Button();
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

        hbox.getChildren().addAll(xWiki1 , xWiki2);

        hbox.setSpacing(50);
        hbox.setMargin(xWiki1 , new Insets(10 , 0 , 10 , 35));
        hbox.setMargin(xWiki2 , new Insets(10 , 0 , 10 , 35));
        hbox1.setSpacing(50);
        hbox1.setMargin(xWiki3 , new Insets(10 , 0 , 10 , 35));
        hbox1.setMargin(xWiki4 , new Insets(10 , 0 , 10 , 35));

        hbox1.getChildren().addAll(xWiki3 , xWiki4);

        hbox2.getChildren().addAll(cancelbtn , savebtn);

        hbox2.setAlignment(Pos.CENTER);
        hbox2.setMargin(savebtn , new Insets(20 , 0 , 0 ,70));
        hbox2.setMargin(cancelbtn , new Insets(20 , 0 , 0 , 0));

        root.getChildren().addAll(text , hbox , text2 , hbox1 , hbox2);



        Scene scene = new Scene(root, 300, 210);
        String css = this.getClass().getResource("../resources/style.css").toExternalForm();


        stage.setTitle("Syntax options");

        stage.setScene(scene);
        stage.setResizable(false);
        scene.getStylesheets().add(css);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
