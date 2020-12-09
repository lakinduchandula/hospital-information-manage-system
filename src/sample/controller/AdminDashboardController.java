package sample.controller;

import com.jfoenix.controls.JFXButton;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class AdminDashboardController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BorderPane AdminDashBorderpane;

    @FXML
    private JFXButton AdminDashAppointmentBtn;

    @FXML
    private JFXButton AdminDashComplaintBtn;

    @FXML
    private JFXButton AdminDashEditUserBtn;

    @FXML
    private JFXButton AdminDashReportsBtn;

    @FXML
    private JFXButton AdminDashUserBtn;

    @FXML
    void show_appointments(MouseEvent event) throws IOException {
        Parent appointmentPane = FXMLLoader.load(getClass().getResource("/sample/view/AdDashAppointment.fxml"));
        AdminDashBorderpane.setCenter(appointmentPane);
    }

    @FXML
    void show_editUser(MouseEvent event) throws IOException {
        Parent userEditPane = FXMLLoader.load(getClass().getResource("/sample/view/AdDashEditUser.fxml"));
        AdminDashBorderpane.setCenter(userEditPane);
    }

    @FXML
    void show_complaint(MouseEvent event) throws IOException {
        Parent userComplaintPane = FXMLLoader.load(getClass().getResource("/sample/view/AdDashComplaint.fxml"));
        AdminDashBorderpane.setCenter(userComplaintPane);
    }

    @FXML
    void initialize() {


    }
}
