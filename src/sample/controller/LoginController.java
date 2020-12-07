package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;

public class LoginController {
    @FXML
    private JFXTextField LoginUsername;

    @FXML
    private JFXPasswordField LoginPassword;

    @FXML
    private JFXComboBox<String> LoginUsermod;

    @FXML
    private JFXButton LoginButton;



    @FXML
    void initialize() {

        // comboBox - items
        LoginUsermod.getItems().add("Receptionist");
        LoginUsermod.getItems().add("Patient");
        LoginUsermod.getItems().add("Medical Officer");
        LoginUsermod.getItems().add("Admin");

    }
}
