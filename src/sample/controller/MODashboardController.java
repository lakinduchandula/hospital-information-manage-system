package sample.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MODashboardController {

    @FXML
    private BorderPane MODashBorderPane;

    @FXML
    private JFXButton PatientDashAppointment;

    @FXML
    private JFXButton PatientDashUserBtn;

    @FXML
    private JFXButton Logout;

    @FXML
    void show_Appointments(MouseEvent event) throws IOException {
        Parent complaint = FXMLLoader.load(getClass().getResource("/sample/view/MODashAppointment.fxml"));
        MODashBorderPane.setCenter(complaint);
    }

    @FXML
    void show_user_settings(MouseEvent event) throws IOException {
        Parent userSettings = FXMLLoader.load(getClass().getResource("/sample/view/MOUserSettings.fxml"));
        MODashBorderPane.setCenter(userSettings);
    }

    @FXML
    void logout(MouseEvent event) {

    }

    @FXML
    void initialize() throws IOException {

        Parent complaint = FXMLLoader.load(getClass().getResource("/sample/view/MODashAppointment.fxml"));
        MODashBorderPane.setCenter(complaint);

        Logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Logout.getScene().getWindow().hide();
                try {
                    Stage LoginInterfaceBackStage = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("/sample/view/Login.fxml"));
                    Scene scene = new Scene(root);
                    LoginInterfaceBackStage.setScene(scene);
                    LoginInterfaceBackStage.setTitle("Login");
                    LoginInterfaceBackStage.show();
                    LoginInterfaceBackStage.setResizable(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

}
