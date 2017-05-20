package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CustomRulesCreatorPanel {

    public static void display(){
        Stage window = new Stage();

        Text text = new Text();
        text.setText("\nInsert your new xWiki rule:");
        text.setFont(Font.font("verdana", FontPosture.REGULAR, 15));
        text.setFill(Color.BLACK);
        text.setStrokeWidth(2);

        Text text2 = new Text();
        text2.setText("\nInsert rule's purpose:");
        text2.setFont(Font.font("verdana", FontPosture.REGULAR, 15));
        text2.setFill(Color.BLACK);
        text2.setStrokeWidth(2);

        TextArea ruleInput = new TextArea();
        ruleInput.setPrefColumnCount(30);
        ruleInput.setPrefRowCount(6);

        TextArea roleInput = new TextArea();
        roleInput.setPrefColumnCount(30);
        roleInput.setPrefRowCount(2);

        Button addbtn = new Button();
        addbtn.setOnAction(event -> ErrorWindow.displayError("This is a test error!"));
        addbtn.setText("Add");

        Button cancelbtn = new Button();
        cancelbtn.setOnAction(event -> window.close());
        cancelbtn.setText("Cancel");

        VBox layout = new VBox();
        layout.setId("main-page");

        HBox txthb = new HBox();
        txthb.setSpacing(25);
        txthb.getChildren().add(text);
        txthb.setAlignment(Pos.CENTER);

        HBox txthb2 = new HBox();
        txthb2.setSpacing(25);
        txthb2.getChildren().add(text2);
        txthb2.setAlignment(Pos.CENTER);

        HBox hb = new HBox();
        hb.setSpacing(50);
        hb.getChildren().add(ruleInput);
        hb.setAlignment(Pos.CENTER);

        HBox hb2 = new HBox();
        hb2.setSpacing(50);
        hb2.getChildren().add(roleInput);
        hb2.setAlignment(Pos.CENTER);

        HBox hb3 = new HBox();
        hb3.setSpacing(50);
        hb3.getChildren().addAll(addbtn,cancelbtn);
        hb3.setAlignment(Pos.CENTER);

        layout.setSpacing(30);
        layout.getChildren().addAll(txthb,hb,txthb2,hb2,hb3);

        Scene scene = new Scene(layout, 600, 400);
        String css = CustomRulesCreatorPanel.class.getResource("../resources/style.css").toExternalForm();
        scene.getStylesheets().add(css);

        window.setTitle("Custom Rules Creator");
        window.setResizable(false);
        window.setScene(scene);
        window.show();
    }
}
