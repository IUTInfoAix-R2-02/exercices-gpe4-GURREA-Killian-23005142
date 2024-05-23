package fr.amu.iut.exercice11;

import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

@SuppressWarnings("Duplicates")
public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Label texteDuHaut;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;
    private Pane panneau;
    private HBox boutons;

    private Label texteDuBas;

    private void clickBleu(Event event){
        texteDuHaut.setText("Bleu choisie " + ++nbBleu + " fois");
        panneau.setStyle("-fx-background-color: #00f");
        texteDuBas.setText("La couleur bleu est jolie !");
        texteDuBas.setTextFill(Color.BLUE);
    }

    private void clickRouge(Event event){
        texteDuHaut.setText("Rouge choisie " + ++nbRouge + " fois");
        panneau.setStyle("-fx-background-color: #ff0000");
        texteDuBas.setText("La couleur rouge est jolie !");
        texteDuBas.setTextFill(Color.RED);
    }

    private void clickVert(Event event){
        texteDuHaut.setText("Vert choisie " + ++nbVert + " fois");
        panneau.setStyle("-fx-background-color: #1db11e");
        texteDuBas.setText("La couleur vert est jolie !");
        texteDuBas.setTextFill(Color.GREEN);
    }

    @Override
    public void start(Stage primaryStage) {
        root = new BorderPane();

        texteDuHaut = new Label();
        texteDuHaut.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        BorderPane.setAlignment(texteDuHaut, Pos.CENTER);

        panneau = new Pane();
        panneau.setPrefSize(400, 200);

        VBox bas = new VBox();
        boutons = new HBox(10);
        boutons.setAlignment(Pos.CENTER);
        boutons.setPadding(new Insets(10, 5, 10, 5));
        texteDuBas = new Label();
        bas.setAlignment(Pos.CENTER_RIGHT);
        bas.getChildren().addAll(boutons, texteDuBas);

        vert = new Button("Vert");
        rouge = new Button("Rouge");
        bleu = new Button("Bleu");

        /* VOTRE CODE ICI */
        this.bleu.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, actionEvent -> clickBleu(actionEvent));
        this.vert.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, actionEvent -> clickVert(actionEvent));
        this.rouge.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> clickRouge(actionEvent));

        boutons.getChildren().addAll(vert, rouge, bleu);

        root.setCenter(panneau);
        root.setTop(texteDuHaut);
        root.setBottom(bas);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args){
        launch(args);
    }
}

