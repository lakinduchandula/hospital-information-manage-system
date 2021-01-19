package sample.controller;

import com.jfoenix.controls.JFXButton;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import sample.model.UserEditDelete;

public class PatientDashboardController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private StackPane PatientDashStackPane;

    @FXML
    private BorderPane PatientDashBorderPane;

    @FXML
    private BorderPane ViewAppointmentBorder;


    @FXML
    private JFXButton PatientDashAppointmentBtn;

    @FXML
    private JFXButton PatientDashComplaintBtn;

    @FXML
    private JFXButton PatientDashAccSetting;

    @FXML
    private JFXButton Logout;

    @FXML
    private JFXButton PatientDashHomeBtn;

    @FXML
    private Circle profileImg;

    @FXML
    private Label UserFullName;

    @FXML
    private Label UserUsername;

    @FXML
    void show_acc_setting(MouseEvent event) throws IOException {
        removeStyle();
        PatientDashAccSetting.getStyleClass().add("jfx-button-patient-vbox-dash-selected");
        Parent userSettings = FXMLLoader.load(getClass().getResource("/sample/view/PatientUserSettings.fxml"));
        PatientDashBorderPane.setCenter(userSettings);
    }

    @FXML
    void show_appointment(MouseEvent event) throws IOException {
        removeStyle();
        PatientDashAppointmentBtn.getStyleClass().add("jfx-button-patient-vbox-dash-selected");
        Parent appointment = FXMLLoader.load(getClass().getResource("/sample/view/PatientDashAppointment.fxml"));
        PatientDashBorderPane.setCenter(appointment);
    }

    @FXML
    void show_complaint(MouseEvent event) throws IOException {
        removeStyle();
        PatientDashComplaintBtn.getStyleClass().add("jfx-button-patient-vbox-dash-selected");
        Parent complaint = FXMLLoader.load(getClass().getResource("/sample/view/PatientDashComplaint.fxml"));
        PatientDashBorderPane.setCenter(complaint);
    }

    public void show_home(MouseEvent mouseEvent) throws IOException {
        removeStyle();
        PatientDashHomeBtn.getStyleClass().add("jfx-button-patient-vbox-dash-selected");
        Parent complaint = FXMLLoader.load(getClass().getResource("/sample/view/PatientDashHome.fxml"));
        PatientDashBorderPane.setCenter(complaint);
    }

    public void removeStyle(){
        PatientDashAccSetting.getStyleClass().remove("jfx-button-patient-vbox-dash-selected");
        PatientDashComplaintBtn.getStyleClass().remove("jfx-button-patient-vbox-dash-selected");
        PatientDashAppointmentBtn.getStyleClass().remove("jfx-button-patient-vbox-dash-selected");
        Logout.getStyleClass().remove("jfx-button-patient-vbox-dash-selected");
        PatientDashHomeBtn.getStyleClass().remove("jfx-button-patient-vbox-dash-selected");
    }


    @FXML
    void initialize() throws IOException {
        // instantiation
        UserEditDelete newEditProfile = new UserEditDelete(1);
        newEditProfile.UserEdit(LoginController.currentUser);
        String[] patientDetails = newEditProfile.getUserDetailArray();

        removeStyle();
        PatientDashHomeBtn.getStyleClass().add("jfx-button-patient-vbox-dash-selected");
        Parent appointment = FXMLLoader.load(getClass().getResource("/sample/view/PatientDashHome.fxml"));
        PatientDashBorderPane.setCenter(appointment);

        // set text to label under change own profile image tab
        UserFullName.setText(patientDetails[2]+" "+patientDetails[3]);
        UserUsername.setText("#"+patientDetails[0]);

        // set up the profile picture
        FileInputStream profileStream = new FileInputStream(patientDetails[13]);
        Image proImg = new Image(profileStream);
        profileImg.setFill(new ImagePattern(proImg));

        Logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Logout.getScene().getWindow().hide();
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



    public void shortcut_to_AccountSettings(MouseEvent mouseEvent) {
    }
}
