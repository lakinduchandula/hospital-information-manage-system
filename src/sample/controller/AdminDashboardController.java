package sample.controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

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
    private JFXButton AdminDashLogOutBtn;

    @FXML
    private StackPane AdminDashStackPane;

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
    void show_referenceRec(MouseEvent event) throws IOException {
        Parent userComplaintPane = FXMLLoader.load(getClass().getResource("/sample/view/AdDashReferenceRecords.fxml"));
        AdminDashBorderpane.setCenter(userComplaintPane);
    }

    @FXML
    void show_reports(MouseEvent event) throws IOException {
        Parent userComplaintPane = FXMLLoader.load(getClass().getResource("/sample/view/AdReportsModule.fxml"));
        AdminDashBorderpane.setCenter(userComplaintPane);
    }



    @FXML
    void initialize() {
        AdminDashLogOutBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                AdminDashLogOutBtn.getScene().getWindow().hide();
                try {
                    Stage LoginInterfaceBackStage = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("/sample/view/Login.fxml"));
                    Scene scene = new Scene(root);
                    LoginInterfaceBackStage.setScene(scene);
                    LoginInterfaceBackStage.setTitle("Login");
                    LoginInterfaceBackStage.show();
                    LoginInterfaceBackStage.setResizable(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }



}
