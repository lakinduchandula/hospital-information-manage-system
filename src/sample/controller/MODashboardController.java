package sample.controller;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class MODashboardController {

    @FXML
    private BorderPane MODashBorderPane;

    @FXML
    private JFXButton PatientDashAppointment;

    @FXML
    private JFXButton PatientDashUserBtn;

    @FXML
    void show_Appointments(MouseEvent event) throws IOException {
        Parent complaint = FXMLLoader.load(getClass().getResource("/sample/view/MODashAppointment.fxml"));
        MODashBorderPane.setCenter(complaint);
    }

}
