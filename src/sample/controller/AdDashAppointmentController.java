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
import javafx.scene.layout.BorderPane;

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

    @FXML
    private BorderPane ViewAppointmentBorderPane;

    @FXML
    private BorderPane DeleteAppointmentBorderPane;

    public AdDashAppointmentController() {
    }

    @FXML
    void view_appointment(MouseEvent event) throws IOException {
        Parent viewAppointment = FXMLLoader.load(getClass().getResource("/sample/view/ViewAppointment.fxml"));
        ViewAppointmentBorderPane.setCenter(viewAppointment);
    }

    @FXML
    void view_before_delete(MouseEvent event) throws IOException {
        Parent viewBeforeDelete = FXMLLoader.load(getClass().getResource("/sample/view/DeleteAppointment.fxml"));
        DeleteAppointmentBorderPane.setCenter(viewBeforeDelete);
    }

    @FXML
    void initialize() {

    }
}
