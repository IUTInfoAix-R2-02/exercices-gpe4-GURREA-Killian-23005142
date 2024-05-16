package fr.amu.iut.exercice1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class FenetreLogiciel extends Application {

    @Override
    public void start(Stage primaryStage) {
        // code de l'exercice 1
        BorderPane root = new BorderPane();

        VBox vbox = new VBox();

        Button bouton1 = new Button("Bouton 1");
        Button bouton2 = new Button("Bouton 2");
        Button bouton3 = new Button("Bouton 3");
        vbox.getChildren().addAll(bouton1, bouton2, bouton3);

        vbox.setAlignment(Pos.CENTER);
        root.setLeft(vbox);

        GridPane grid = new GridPane();

        HBox hbox = new HBox();
        HBox hbox2 = new HBox();
        HBox hbox3 = new HBox();

        Menu file = new Menu("File");
        Menu edit = new Menu("Edit");
        Menu help = new Menu("Help");
        MenuBar menuBar = new MenuBar(file, edit, help);

        MenuItem newItem = new MenuItem("New");
        MenuItem openItem = new MenuItem("Open");
        MenuItem saveItem = new MenuItem("Save");
        MenuItem closeItem = new MenuItem("Close");
        file.getItems().addAll(newItem, openItem, saveItem, closeItem);

        MenuItem cutItem = new MenuItem("Cut");
        MenuItem copyItem = new MenuItem("Copy");
        MenuItem pasteItem = new MenuItem("Paste");
        edit.getItems().addAll(cutItem, copyItem, pasteItem);

        VBox label1 = new VBox();
        VBox textfield1 = new VBox();

        Label name = new Label("Name :   ");
        TextField tf = new TextField();
        hbox.setSpacing(10);
        hbox.getChildren().addAll(name, tf);

        Label email = new Label("Email :  ");
        TextField tf2 = new TextField();
        hbox2.setSpacing(10);
        hbox2.getChildren().addAll(email, tf2);

        Label password = new Label("Password :   ");
        TextField tf3 = new TextField();
        hbox3.setSpacing(10);
        hbox3.getChildren().addAll(password, tf3);

        label1.setAlignment(Pos.CENTER);
        label1.getChildren().addAll(name, email, password);
        label1.setSpacing(10);

        textfield1.setAlignment(Pos.CENTER);
        textfield1.getChildren().addAll(tf,tf2, tf3);
        textfield1.setSpacing(10);

        hbox.setAlignment(Pos.TOP_CENTER);
        hbox2.setAlignment(Pos.CENTER);
        hbox3.setAlignment(Pos.BOTTOM_CENTER);

        grid.setAlignment(Pos.CENTER);
        grid.getChildren().addAll(hbox, hbox2, hbox3);
        root.setCenter(grid);

        root.setTop(menuBar);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        primaryStage.setTitle("Fenetre Logiciel");
        primaryStage.setWidth(500);
        primaryStage.setHeight(350);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}

