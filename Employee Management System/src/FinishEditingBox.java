import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.Serializable;


public class FinishEditingBox implements Serializable {



    public static void display(){
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setMinHeight(150);
        stage.setMinWidth(250);
        stage.setTitle("Please fill out all fields");

        String errorSound = "C:\\Users\\Jack Hess\\IdeaProjects\\Employee Management System\\src\\Windows XP Error Sound Effect.mp3";

        Media sound = new Media(new File(errorSound).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);


        Label label = new Label("Please fill out all fields");
        label.setFont(Font.font("Verdana", 18));


        Button button = new Button("Okay");
        button.setFont(Font.font("Verdana", 15));

        button.setOnAction(event -> stage.close());

        VBox vbox = new VBox();

        vbox.getChildren().addAll(label, button);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(15);

        Scene scene = new Scene(vbox);

        stage.setScene(scene);

        mediaPlayer.play();
        stage.showAndWait();
        stage.setOnCloseRequest(event -> mediaPlayer.stop());


    }
}
