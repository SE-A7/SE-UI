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

    private static RulesContainer container = RulesContainer.getInstance();
    private static TextArea[] ruleList = new TextArea[10];
    private static TextArea[] roleList = new TextArea[10];

    private static int counter = 0;

    public static void display(){
        Stage window = new Stage();
        Scene scene;

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
        ruleInput.setPrefColumnCount(20);
        ruleInput.setPrefRowCount(2);

        TextArea roleInput = new TextArea();
        roleInput.setPrefColumnCount(20);
        roleInput.setPrefRowCount(2);

        Button addbtn = new Button();
        addbtn.setOnAction(event -> {
            container.add(new Rules(ruleInput.getText(),roleInput.getText()));
            for(int i = 0; i<ruleList.length; i++) {
                container.add(new Rules(ruleList[i].getText(),roleList[i].getText()));
            }
            ErrorWindow.displayError("This is a test error!");
        });
        addbtn.setText("Add");

        Button cancelbtn = new Button();
        cancelbtn.setOnAction(event -> window.close());
        cancelbtn.setText("Cancel");

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

        VBox row_1 = new VBox();
        row_1.setSpacing(25);
        row_1.getChildren().add(txthb);
        row_1.getChildren().add(hb);
        row_1.setAlignment(Pos.CENTER);

        VBox row_2 = new VBox();
        row_2.setSpacing(25);
        row_2.getChildren().add(txthb2);
        row_2.getChildren().add(hb2);
        row_2.setAlignment(Pos.CENTER);

        HBox content = new HBox();
        content.setSpacing(30);
        content.setAlignment(Pos.CENTER);
        content.getChildren().addAll(row_1,row_2);

        VBox layout = new VBox();
        layout.setId("main-page");
        layout.setSpacing(30);
        layout.getChildren().add(content);

        Button newRule = new Button();
        newRule.setOnAction(event -> {
            if(counter < 4) {
                window.setHeight(window.getHeight()+75);
                TextArea rule = new TextArea();
                rule.setPrefColumnCount(20);
                rule.setPrefRowCount(2);

                TextArea role = new TextArea();
                role.setPrefColumnCount(20);
                role.setPrefRowCount(2);

                HBox box1 = new HBox();
                box1.setSpacing(50);
                box1.getChildren().add(rule);
                box1.setAlignment(Pos.CENTER);

                HBox box2 = new HBox();
                box2.setSpacing(50);
                box2.getChildren().add(role);
                box2.setAlignment(Pos.CENTER);

                HBox content2 = new HBox();
                content2.setSpacing(30);
                content2.setAlignment(Pos.CENTER);
                content2.getChildren().addAll(box1,box2);
                ruleList[counter] = rule;
                roleList[counter] = role;
                layout.getChildren().add(layout.getChildren().size()-2,content2);
                counter++;
            }
        });
        newRule.setText("+");

        HBox hbRule = new HBox();
        hbRule.setSpacing(50);
        hbRule.getChildren().add(newRule);
        hbRule.setAlignment(Pos.CENTER);

        layout.getChildren().add(hbRule);
        layout.getChildren().add(hb3);

        scene = new Scene(layout, 550, 275);
        String css = CustomRulesCreatorPanel.class.getResource("../resources/style.css").toExternalForm();
        scene.getStylesheets().add(css);

        window.setTitle("Custom Rules Creator");
        window.setResizable(false);
        window.setScene(scene);
        window.show();
    }
}
