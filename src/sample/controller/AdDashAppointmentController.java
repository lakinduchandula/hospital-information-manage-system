package sample.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class AdDashAppointmentController {

    public static String appointmentID;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private StackPane AdDashAppStackPane;

    @FXML
    private JFXTabPane AppointmentTabpane;

    @FXML
    private JFXTextField ViewAppointmentID;

    @FXML
    private JFXButton ViewAppointmentBtn;

    @FXML
    private JFXButton DeleteAppointmentBtn;

    @FXML
    private JFXTextField DeleteAppointmentUsername;

    @FXML
    private BorderPane ViewAppointmentBorderPane;

    @FXML
    private BorderPane DeleteAppointmentBorderPane;

    @FXML
    private AnchorPane AdDashAppAnch;

    public AdDashAppointmentController() {
    }

    @FXML
    void view_appointment(MouseEvent event) throws IOException {
        ValidationController validate = new ValidationController(AdDashAppStackPane, AdDashAppAnch, 1);
        if(validate.validateAppointmentID(ViewAppointmentID)){
            appointmentID = ViewAppointmentID.getText().trim();
            Parent viewAppointment = FXMLLoader.load(getClass().getResource("/sample/view/AdViewAppointment.fxml"));
            ViewAppointmentBorderPane.setCenter(viewAppointment);
            ViewAppointmentID.clear();
        }
    }

    @FXML
    void initialize() {

    }
}
