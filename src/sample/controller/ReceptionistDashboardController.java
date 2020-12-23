package sample.controller;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class ReceptionistDashboardController {

    @FXML
    private JFXButton RecepDashAppoinmentBtn;

    @FXML
    private JFXButton RecepDashComplaintBtn;

    @FXML
    private JFXButton RecepDashPostalBtn;

    @FXML
    private JFXButton RecepDashVisitorBtn;

    @FXML
    private JFXButton RecepDashPatientBtn;

    @FXML
    private JFXButton RecepDashUserBtn;

    @FXML
    private BorderPane ReceptDashBoarderPane;

    @FXML
    void show_appointment(MouseEvent event) throws IOException {
        Parent appointmentPane = FXMLLoader.load(getClass().getResource("/sample/view/ReceptDashAppointment.fxml"));
        ReceptDashBoarderPane.setCenter(appointmentPane);
    }
    @FXML
    void show_complaint(MouseEvent event) throws IOException {
        Parent complaintPane = FXMLLoader.load(getClass().getResource("/sample/view/ReceptDashComplaint.fxml"));
        ReceptDashBoarderPane.setCenter(complaintPane);
    }
    @FXML
    void show_postalMail(MouseEvent event) throws IOException {
        Parent postalMailPane = FXMLLoader.load(getClass().getResource("/sample/view/ReceptDashPostalMail.fxml"));
        ReceptDashBoarderPane.setCenter(postalMailPane);
    }

    @FXML
    void show_patientRecords(MouseEvent event) throws IOException {
        Parent patientRecords = FXMLLoader.load(getClass().getResource("/sample/view/ReceptDashPatientRecords.fxml"));
        ReceptDashBoarderPane.setCenter(patientRecords);
    }
    @FXML
    void show_visitorRecords(MouseEvent event) throws IOException {
        Parent visitorRecords = FXMLLoader.load(getClass().getResource("/sample/view/ReceptDashVisitorRecords.fxml"));
        ReceptDashBoarderPane.setCenter(visitorRecords);
    }

}
