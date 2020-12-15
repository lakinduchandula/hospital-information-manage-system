package sample.controller;

import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.model.UserLogin;

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

    private void loginUserException() {
        Stage userExceptionStage = new Stage();
        JFXDialogLayout content= new JFXDialogLayout();
        content.setHeading(new Text("Error, No selection"));
        content.setBody(new Text("No student selected"));
        StackPane stackpane = new StackPane();
        JFXDialog dialog =new JFXDialog(stackpane, content, JFXDialog.DialogTransition.CENTER);
        JFXButton button=new JFXButton("Okay");
        button.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                dialog.close();
            }
        });
        content.setActions(button);

        Scene userExceptionScene = new Scene(stackpane, 300, 250);
        userExceptionStage.setScene(userExceptionScene);
        userExceptionStage.setResizable(false);
        dialog.show();
        userExceptionStage.show();
    }
}
