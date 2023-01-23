package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainFX extends Application {

    Button newGame;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("Scopa Game!");
        newGame = new Button();
        newGame.setOnAction(e -> startNewGame());
        newGame.setText("New Game");

        StackPane layout = new StackPane();
        layout.getChildren().add(newGame);

        Scene scene = new Scene(layout,300,250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void startNewGame(){

        Deck deck = new Deck();
        System.out.println("Test");

    }

}