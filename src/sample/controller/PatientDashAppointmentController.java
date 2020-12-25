package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class PatientDashAppointmentController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private StackPane PatientDashComplaint;

    @FXML
    private Label AppointmentAddUsername;

    @FXML
    private Label AppointmentAddFirstName;

    @FXML
    private Label AppointmentAddUserID;

    @FXML
    private Label AppointmentAddLastName;

    @FXML
    private Label AppointmentAddUserPhone;

    @FXML
    private JFXDatePicker AppointmentAddDate;

    @FXML
    private JFXTextArea AppointmentAddSymptoms;

    @FXML
    private JFXButton MakeAnAppointment;

    @FXML
    private JFXTimePicker AppointmentAddTime;

    @FXML
    private JFXComboBox<?> AppointmentAddSpecial;

    @FXML
    private JFXComboBox<?> AppointmentAddMO;

    @FXML
    private JFXTextField EditUserEditUsername;

    @FXML
    private JFXButton AppointmentView;

    @FXML
    private BorderPane ViewAppointmentBorder;

    @FXML
    void Info_tip(MouseEvent event) {

    }

    @FXML
    void ViewAppointment(MouseEvent event) throws IOException {
        Parent viewAppointment = FXMLLoader.load(getClass().getResource("/sample/view/ViewAppointment.fxml"));
        ViewAppointmentBorder.setCenter(viewAppointment);
    }

    @FXML
    void makeAnAppointment(MouseEvent event) {

    }

    @FXML
    void initialize() {


    }
}
