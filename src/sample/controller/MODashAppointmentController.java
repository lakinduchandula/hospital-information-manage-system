package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class MODashAppointmentController {

    @FXML
    private TableView<?> approvedAppointmentTableMO;

    @FXML
    private TableColumn<?, ?> appointmentNoColMO;

    @FXML
    private TableColumn<?, ?> patientColMO;

    @FXML
    private TableColumn<?, ?> appointmentDateColMO;

    @FXML
    private TableColumn<?, ?> appointmentTimeColMO;

    @FXML
    private TableColumn<?, ?> symptomsColMO;

    @FXML
    private TableColumn<?, ?> medicalOfficerColMO;

    @FXML
    private JFXTextField appointmentNoTextField;

    @FXML
    private JFXButton changeStatusButton;

}
