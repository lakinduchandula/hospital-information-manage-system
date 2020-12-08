package sample.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;

public class AdDashAppointmentController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTabPane AppointmentTabpane;

    @FXML
    private JFXTextField ViewAppointmentUsername;

    @FXML
    private JFXButton ViewAppointmentBtn;

    @FXML
    private JFXButton DeleteAppointmentBtn;

    @FXML
    private JFXTextField DeleteAppointmentUsername;

    public AdDashAppointmentController() {
    }

    @FXML
    void initialize() {

    }
}
