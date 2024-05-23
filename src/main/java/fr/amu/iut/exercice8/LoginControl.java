package fr.amu.iut.exercice8;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;

import java.awt.*;

public class LoginControl extends GridPane {
    @FXML
    private Button ok;
    @FXML
    private Button cancel;
    @FXML
    private TextField user;
    @FXML
    private PasswordField pwd;
    @FXML
    private Label err;
    @FXML
    private void okClicked() {
        String usr = user.getText();
        String pass = pwd.getText();

        if (usr.isEmpty() || pass.isEmpty()) {
            err.setText("User or Password is empty");
        }
        else{
            System.out.println(usr);
            err.setText("User or Password is false");
        }
    }
    @FXML
    private void cancelClicked() {
        //user.clear();
        pwd.clear();
    }
}