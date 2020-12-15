package sample.controller;

import com.jfoenix.controls.*;
import com.jfoenix.controls.events.JFXDialogEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.model.UserLogin;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

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
    private StackPane loginRootStack;

    @FXML
    private AnchorPane loginRootAnchorPane;


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
                if (!LoginUsername.getText().toString().trim().equals("") && !LoginPassword.getText().toString().trim().equals("")) {
                    switch (LoginUsermod.getValue()) {
                        case "Receptionist": {
                            UserLogin receptionistLogin = new UserLogin(LoginUsername.getText().trim(),
                                    LoginPassword.getText().trim(), 1);

                            // call checkLoginValidation to validate the credentials
                            receptionistLogin.checkLoginValidation();

                            // if login credentials are validate
                            if (receptionistLogin.getUserValidation()) {
                                loginUser(1);
                            } else {
                                JFXButton button = new JFXButton("Close");
                                loginUserException(loginRootStack, loginRootAnchorPane, Collections.singletonList(button));
                            }
                            break;
                        }
                        case "Patient": {
                            UserLogin patientLogin = new UserLogin(LoginUsername.getText().trim(),
                                    LoginPassword.getText().trim(), 2);

                            // call checkLoginValidation to validate the credentials
                            patientLogin.checkLoginValidation();

                            if (patientLogin.getUserValidation()) {
                                loginUser(2);
                            } else {
                                JFXButton button = new JFXButton("Close");
                                loginUserException(loginRootStack, loginRootAnchorPane, Collections.singletonList(button));
                            }
                            break;
                        }
                        case "Medical Officer": {
                            UserLogin MedicalOfficerLogin = new UserLogin(LoginUsername.getText().trim(),
                                    LoginPassword.getText().trim(), 3);

                            // call checkLoginValidation to validate the credentials
                            MedicalOfficerLogin.checkLoginValidation();

                            if (MedicalOfficerLogin.getUserValidation()) {
                                loginUser(3);
                            } else {
                                JFXButton button = new JFXButton("Close");
                                loginUserException(loginRootStack, loginRootAnchorPane, Collections.singletonList(button));
                            }
                            break;

                        }
                        case "Admin": {
                            UserLogin AdminLogin = new UserLogin(LoginUsername.getText().trim(),
                                    LoginPassword.getText().trim(), 0);

                            // call checkLoginValidation to validate the credentials
                            AdminLogin.checkLoginValidation();

                            if (AdminLogin.getUserValidation()) {
                                loginUser(0);
                            } else {
                                JFXButton button = new JFXButton("Close");
                                loginUserException(loginRootStack, loginRootAnchorPane, Collections.singletonList(button));
                            }
                            break;
                        }
                    }
                } else {
                    System.out.println("Please Enter Login Credentials");
                }

            }
        });
    }

    private void loginUser(int LocationIndex) {
        LoginButton.getScene().getWindow().hide();

        // array of file paths of the dashboard of the main users
        String[] dashboardFileLocation = {"/sample/view/AdminDashboard.fxml", "/sample/view/ReceptionistDashboard.fxml",
                "/sample/view/PatientDashboard.fxml", "/sample/view/MODashboard.fxml"};
        // dashboardTitle will hold the title names
        String[] dashboardTitle = {"Admin Dashboard", "Receptionist Dashboard",
                "Patient Dashboard", "Medical Officer Dashboard"};
        try {
            Stage DashboardStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource(dashboardFileLocation[LocationIndex]));
            Scene scene = new Scene(root);
            DashboardStage.setScene(scene);
            DashboardStage.setTitle(dashboardTitle[LocationIndex]);
            DashboardStage.show();
            DashboardStage.setResizable(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loginUserException(StackPane userStackPane, Node nodeToBeBlurred, List<JFXButton> controls) {
        BoxBlur blur = new BoxBlur(3,3,3);

        JFXDialogLayout dialogLayout = new JFXDialogLayout();


        JFXDialog dialog = new JFXDialog(userStackPane, dialogLayout, JFXDialog.DialogTransition.TOP);

        for (JFXButton controlButton : controls) {
            controlButton.getStyleClass().add("button-raised");
            controlButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent mouseEvent) -> dialog.close());
        }

        // label for dialog box heading and it's styles
        Label dialogBoxHeading = new Label("Access Denied");
        dialogBoxHeading.setStyle("-fx-font-size: 14px");
        dialogLayout.setHeading(dialogBoxHeading);

        // Text for dialog box body and it's styles
        Text dialogBoxBody = new Text("""
                Sorry, we couldn't find an account with that user credentials.\s
                Please contact administrator.""");
        dialogBoxBody.setStyle("-fx-font-size: 14px");
        dialogLayout.setBody(dialogBoxBody);

        dialogLayout.setActions(controls);
        dialog.show();

        // blur outer background
        dialog.setOnDialogClosed((JFXDialogEvent event) -> {
            nodeToBeBlurred.setEffect(null);
        });
        nodeToBeBlurred.setEffect(blur);
    }
}
