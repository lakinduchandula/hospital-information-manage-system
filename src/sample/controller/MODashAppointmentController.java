package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.model.Appointment;

public class MODashAppointmentController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Appointment> TableAppointmentList;

    @FXML
    private TableColumn<Appointment, String> TableAppointmentID;

    @FXML
    private TableColumn<Appointment, String> TableFirstName;

    @FXML
    private TableColumn<Appointment, String> TableLastName;

    @FXML
    private TableColumn<Appointment, String> TablePatientNIC;

    @FXML
    private TableColumn<Appointment, String> TablePhoneNumber;

    @FXML
    private TableColumn<Appointment, String> TableGender;

    @FXML
    private TableColumn<Appointment, LocalDate> TableDate;

    @FXML
    private TableColumn<Appointment, LocalTime> TableTime;

    @FXML
    private TableColumn<Appointment, String> TableSymptoms;

    @FXML
    private JFXTextField appointmentNoTextField;

    @FXML
    private JFXButton changeStatusButton;

    ObservableList<Appointment> appointmentList = FXCollections.observableArrayList(
            new Appointment("ABS12584", "Lakindu", "Chandula", "991623361V",
                    "0752094801", "Male", LocalDate.parse("2020-12-25"), LocalTime.parse("10:17"),
                    "null")
    );

    @FXML
    void initialize() {
        TableAppointmentID.setCellValueFactory(new PropertyValueFactory<>("appointmentNo"));
        TableFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        TableLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        TablePatientNIC.setCellValueFactory(new PropertyValueFactory<>("idNo"));
        TablePhoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        TableGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        TableDate.setCellValueFactory(new PropertyValueFactory<>("appointmentDate"));
        TableTime.setCellValueFactory(new PropertyValueFactory<>("appointmentTime"));
        TableSymptoms.setCellValueFactory(new PropertyValueFactory<>("symptoms"));

        TableAppointmentList.setItems(appointmentList);
    }
}
