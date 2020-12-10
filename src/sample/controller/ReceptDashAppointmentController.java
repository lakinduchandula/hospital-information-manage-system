package sample.controller;

import com.jfoenix.controls.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

import java.awt.event.MouseEvent;
import java.io.IOException;

public class ReceptDashAppointmentController {

    @FXML
    private JFXTabPane mainEditUserTabPane;

    @FXML
    private JFXTextField AddAppointmentFirstname;

    @FXML
    private JFXTextField AddAppointmentSecondname;

    @FXML
    private JFXTextField AddAppointmentLastname;

    @FXML
    private JFXTextField AddAppointmentPhoneNumber;

    @FXML
    private JFXDatePicker AddAppointmentDOB;

    @FXML
    private JFXTextField AddAppointmentSymptoms;

    @FXML
    private JFXDatePicker AddAppointmentFromDate;

    @FXML
    private Label AddAppointmentAppointmentDate;

    @FXML
    private JFXDatePicker EditUserDOB11;

    @FXML
    private JFXTimePicker AddAppointmentAppointmentTime;

    @FXML
    private JFXTextField AddAppointmentAppointmentNumber;

    @FXML
    private JFXComboBox<?> AddAppointmentAppointmentPrefferedMO;

    @FXML
    private JFXTextField EditAppointmentUsername;

    @FXML
    private JFXTextField ViewAppointmentUsername1;

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
    private JFXTextField ViewAppointmentUsername11;

    @FXML
    private JFXButton DeleteAppointmentBtn;

    @FXML
    private BorderPane DeleteAppointmentBorderPane;

   // @FXML
   // void Delete_Appointment(MouseEvent event) throws IOException {
    //    Parent appointmentPane = FXMLLoader.load(getClass().getResource("/sample/view/DeleteAppointment.fxml"));
     //   DeleteAppointmentBorderPane.setCenter(appointmentPane);
   // }

 //   @FXML
 //   void View_Appointment(MouseEvent event)  throws IOException {
  //      Parent appointmentPane = FXMLLoader.load(getClass().getResource("/sample/view/ ViewAppointment.fxml"));
  //      ViewAppointmentBorderPane.setCenter(appointmentPane);
   // }

    public void View_Appointment(javafx.scene.input.MouseEvent mouseEvent)  throws IOException{
        Parent appointmentPane = FXMLLoader.load(getClass().getResource("/sample/view/DeleteAppointment.fxml"));
        ViewAppointmentBorderPane.setCenter(appointmentPane);
    }

    public void Delete_Appointment(javafx.scene.input.MouseEvent mouseEvent)  throws IOException{
        Parent appointmentPane = FXMLLoader.load(getClass().getResource("/sample/view/ ViewAppointment.fxml"));
        DeleteAppointmentBorderPane.setCenter(appointmentPane);
    }
}
