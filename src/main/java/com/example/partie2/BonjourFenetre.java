package com.example.partie2;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class BonjourFenetre extends Application {
    //label affichant le message bienvenue
    private Label helloLabel;

    //champ de saisie
    private TextField nameField;

    //bouton declanchant la mise a jour du texte
    private Button button;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Création de conteneur avec ses éléments
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);

        //Création et ajout d'un label
        this.helloLabel = new Label("Bonjour a tous");
        vbox.getChildren().add(helloLabel);

        //Création de la scène
        Scene scene = new Scene(vbox);

        //ajout d'un champ de saisie de texte
        this.nameField = new TextField("Veuillez saisir un nom");
        nameField.setMaxWidth(180.0d);
        nameField.setFont(Font.font("Courier", FontWeight.NORMAL, 12));

        nameField.setOnAction(actionEvent -> handleButtonClick(actionEvent));

        vbox.getChildren().add(nameField);

        //Ajout d'un bouton
        this.button = new Button();
        vbox.getChildren().add(button);

        //chargement image
        Image image = new Image(BonjourFenetre.class.getResource("silver_button.png").toString());

        //création d'un composant avec l'image
        ImageView iv = new ImageView();
        iv.setImage(image);

        //intégartion del'image dans le bouton
        button.setGraphic(iv);

        //ajout de la scène
        primaryStage.setScene(scene);

        // Changement du texte après un clic sur le bouton
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, new ButtonClickHandler(helloLabel, nameField));


        primaryStage.setWidth(400);
        primaryStage.setHeight(400);
        primaryStage.setTitle("Hello application");
        primaryStage.show();
    }

    private void handleButtonClick(Event event){
        helloLabel.setText("Boujour à toi," +nameField.getText());
    }
}
