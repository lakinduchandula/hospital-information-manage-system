package sample.controller;

import com.jfoenix.controls.JFXButton;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PatientDashboardController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private StackPane PatientDashStackPane;

    @FXML
    private BorderPane PatientDashBorderPane;

    @FXML
    private BorderPane ViewAppointmentBorder;


    @FXML
    private JFXButton PatientDashAppointmentBtn;

    @FXML
    private JFXButton PatientDashComplaintBtn;

    @FXML
    private JFXButton PatientDashAccSetting;

    @FXML
    private JFXButton Logout;

    @FXML
    void show_acc_setting(MouseEvent event) throws IOException {

    }

    @FXML
    void show_appointment(MouseEvent event) throws IOException {
        Parent appointment = FXMLLoader.load(getClass().getResource("/sample/view/PatientDashAppointment.fxml"));
        PatientDashBorderPane.setCenter(appointment);
    }

    @FXML
    void show_complaint(MouseEvent event) throws IOException {
        Parent complaint = FXMLLoader.load(getClass().getResource("/sample/view/PatientDashComplaint.fxml"));
        PatientDashBorderPane.setCenter(complaint);
    }

    @FXML
    void initialize() {
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
