package fr.amu.iut.exercice7;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class CounterController implements Initializable {

    private int counter = 0;

    @FXML
    Label counterLabel;

    @FXML
    Button incrementButton;

    @FXML
    Button decrementButton;

    public void increment() {
        counterLabel.setText(String.valueOf(counter++));
    }

    public void decrement() {
        counterLabel.setText(String.valueOf(counter--));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Initializing CounterController...");
    }
}
