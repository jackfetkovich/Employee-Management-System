import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.Serializable;

public class ConfirmBox implements Serializable {


    public static void display(String title, String message){
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(title);
        stage.setMinWidth(250);
        stage.setMinHeight(250);

        Label messageLabel = new Label(message);
        messageLabel.setFont(Font.font("Times New Roman", 15));

        Button confirmExit = new Button(" Exit");
        Button continueEditing = new Button("Continue Editing");

        confirmExit.setOnAction(event -> {
            Interface.resWindow();
            stage.close();
        });

        continueEditing.setOnAction(event -> stage.close());


        VBox vbox = new VBox();


        vbox.setSpacing(20);
        vbox.getChildren().addAll(messageLabel, continueEditing, confirmExit);
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox);

        stage.setScene(scene);
        stage.showAndWait();







    }

}
