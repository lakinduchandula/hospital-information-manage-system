package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

        LoginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(!LoginUsername.getText().toString().trim().equals("") && !LoginPassword.getText().toString().trim().equals("")){
                    switch(LoginUsermod.getValue()){
                        case "Receptionist" : {

                        }
                        case "Patient" : {

                        }
                        case "Medical Officer" : {

                        }
                        case "Admin" : {

                        }
                        default : {

                        }
                    }
                } else {
                    System.out.println("Please Enter Login Credentials");
                }

            }
        });

    }
}
