package sample.controller;

import com.jfoenix.controls.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ReceptDashAppointmentController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField AddAppointmentFirstname;

    @FXML
    private JFXTextField AddAppointmentMiddlename;

    @FXML
    private JFXTextField AddAppointmentLastname;

    @FXML
    private JFXDatePicker AddAppointmentDOB;

    @FXML
    private JFXTextField AddAppointmentPhoneNumber;

    @FXML
    private JFXTextField AddAppointmentSymptoms;

    @FXML
    private JFXDatePicker AddAppointmentFromDate;

    @FXML
    private JFXDatePicker AddAppointmentAppointmentDate;

    @FXML
    private JFXTimePicker AddAppointmentAppointmentTime;

    @FXML
    private JFXTextField AddAppointmentAppointmentNumber;

    @FXML
    private JFXComboBox<?> AddAppointmentAppointmentPrefferedMO;

    @FXML
    private JFXButton AddAppointmentBtn;

    @FXML
    private JFXTextField EditAppointmentUsername;

    @FXML
    private JFXButton EditAppointmentBtn;

    @FXML
    private JFXTextField ViewAppointmentUsername;

    @FXML
    private JFXButton ViewAppointmentBtn;

    @FXML
    private BorderPane ViewAppointmentBorderPane;

    @FXML
    private JFXTextField DeleteAppointmentUsername;

    @FXML
    private JFXButton DeleteAppointmentBtn;

    @FXML
    private BorderPane DeleteAppointmentBorderPane;

    @FXML
    void View_Appointment(MouseEvent event) throws IOException {
        Parent appointmentPane = FXMLLoader.load(getClass().getResource("/sample/view/ViewAppointment.fxml"));
        ViewAppointmentBorderPane.setCenter(appointmentPane);
    }

}
