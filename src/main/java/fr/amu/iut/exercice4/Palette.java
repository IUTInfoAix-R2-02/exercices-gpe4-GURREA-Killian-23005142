package fr.amu.iut.exercice4;

import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;
    private Label label;
    private Pane panneau;
    private HBox bas;

    private HBox haut;

    private void clickBleu(Event event){
        label.setText("Bleu choisie " + ++nbBleu + " fois");
        panneau.setStyle("-fx-background-color: #00f");
    }

    private void clickRouge(Event event){
        label.setText("Rouge choisie " + ++nbRouge + " fois");
        panneau.setStyle("-fx-background-color: #ff0000");
    }

    private void clickVert(Event event){
        label.setText("Vert choisie " + ++nbVert + " fois");
        panneau.setStyle("-fx-background-color: #1db11e");
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.root = new BorderPane();

        this.panneau = new Pane();
        root.setCenter(panneau);

        this.bas = new HBox();
        this.bas.setAlignment(Pos.BOTTOM_CENTER);

        this.haut = new HBox();
        this.haut.setAlignment(Pos.TOP_CENTER);

        this.label = new Label("click sur une couleur");
        label.setAlignment(Pos.CENTER);
        this.root.setTop(label);

        this.bleu = new Button("Bleu");
        this.rouge = new Button("Rouge");
        this.vert = new Button("Vert");

        bleu.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> clickBleu(actionEvent));
        vert.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> clickVert(actionEvent));
        rouge.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> clickRouge(actionEvent));

        bas.getChildren().addAll(vert, bleu, rouge);
        root.setBottom(bas);
        haut.getChildren().add(label);
        root.setTop(haut);

        //Création de la scène
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        primaryStage.setWidth(400);
        primaryStage.setHeight(200);
        primaryStage.setTitle("FenetreCouleur");
        primaryStage.show();
    }
    public static void main(String[] args){
        launch(args);
    }

}

