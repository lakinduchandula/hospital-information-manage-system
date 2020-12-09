package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;

public class AdDashMOApplicationController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView appointmentIconMO;

    @FXML
    private Label approvedAppointmentLblMO;

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
    private JFXTextField appointmentNoTxtF;

    @FXML
    private JFXButton seeDetailsBttn;


    @FXML
    private Label patientLbl;

    @FXML
    private Label dateLbl;

    @FXML
    private Label timeLbl;

    @FXML
    private Label symptomsLbl;

    @FXML
    private Label medicalOfficerLbl;

    @FXML
    private JFXButton changeStatusBtn;

    
    @FXML
    void initialize() {

    }
}
