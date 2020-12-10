package sample.controller;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

import java.awt.event.MouseEvent;
import java.io.IOException;

public class ReceptionistDashboardController {

    @FXML
    private JFXButton RecepDashAppoinmentBtn;

    @FXML
    private BorderPane ReciptionistDashBoardPane;

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

    //@FXML
  // void show_appointment(MouseEvent event) throws IOException {
      //  Parent appointmentPane = FXMLLoader.load(getClass().getResource("/sample/view/ReceptDashAppointment.fxml"));
     //  ReceptionistDashBoardPane.setCenter(appointmentPane);
   // }


    public void show_appointment(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        Parent appointmentPane = FXMLLoader.load(getClass().getResource("/sample/view/ReceptDashAppointment.fxml"));
        ReciptionistDashBoardPane.setCenter(appointmentPane);
    }
}
