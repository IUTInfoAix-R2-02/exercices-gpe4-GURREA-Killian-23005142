package fr.amu.iut.exercice1;

import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FenetreLogiciel extends Application {

    @Override
    public void start(Stage primaryStage) {
        // code de l'exercice 1
        BorderPane root = new BorderPane();

        Pane pane = new Pane();
        root.setCenter(pane);

        primaryStage.setTitle("Fenetre Logiciel");
        primaryStage.setWidth(500);
        primaryStage.setHeight(350);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}

