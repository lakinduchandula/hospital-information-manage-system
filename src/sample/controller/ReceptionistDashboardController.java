package sample.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import sample.model.UserEditDelete;

import java.io.FileInputStream;
import java.io.IOException;

public class ReceptionistDashboardController {

    @FXML
    private JFXButton RecepDashAppointmentBtn;

    @FXML
    private JFXButton RecepDashComplaintBtn;

    @FXML
    private JFXButton RecepDashPostalBtn;

    @FXML
    private JFXButton RecepDashVisitorBtn;

    @FXML
    private JFXButton RecepDashPatientBtn;

    @FXML
    private JFXButton RecepDashUserBtn;

    @FXML
    private BorderPane RecepDashBoarderPane;

    @FXML
    private JFXButton Logout;

    @FXML
    private JFXButton AdDashHomeBtn;

    private String profile;

    @FXML
    private Circle profileImg;

    @FXML
    private Label UserFullName;

    @FXML
    private Label UserUsername;

    @FXML
    void shortcut_to_AccountSettings(MouseEvent event) throws IOException {
        removeStyle();
        RecepDashUserBtn.getStyleClass().add("jfx-button-recep-vbox-dash-selected");
        Parent visitorRecords = FXMLLoader.load(getClass().getResource("/sample/view/RecepUserSettings.fxml"));
        RecepDashBoarderPane.setCenter(visitorRecords);
    }

    @FXML
    void show_home(MouseEvent event) throws IOException {
        removeStyle();
        AdDashHomeBtn.getStyleClass().add("jfx-button-recep-vbox-dash-selected");
        Parent appointmentPane = FXMLLoader.load(getClass().getResource("/sample/view/RecepDashHome.fxml"));
        RecepDashBoarderPane.setCenter(appointmentPane);
    }

    @FXML
    void show_appointment(MouseEvent event) throws IOException {
        removeStyle();
        RecepDashAppointmentBtn.getStyleClass().add("jfx-button-recep-vbox-dash-selected");
        Parent appointmentPane = FXMLLoader.load(getClass().getResource("/sample/view/ReceptDashAppointment.fxml"));
        RecepDashBoarderPane.setCenter(appointmentPane);
    }
    @FXML
    void show_complaint(MouseEvent event) throws IOException {
        removeStyle();
        RecepDashComplaintBtn.getStyleClass().add("jfx-button-recep-vbox-dash-selected");
        Parent complaintPane = FXMLLoader.load(getClass().getResource("/sample/view/ReceptDashComplaint.fxml"));
        RecepDashBoarderPane.setCenter(complaintPane);
    }
    @FXML
    void show_postalMail(MouseEvent event) throws IOException {
        removeStyle();
        RecepDashPostalBtn.getStyleClass().add("jfx-button-recep-vbox-dash-selected");
        Parent postalMailPane = FXMLLoader.load(getClass().getResource("/sample/view/ReceptDashPostalMail.fxml"));
        RecepDashBoarderPane.setCenter(postalMailPane);
    }

    @FXML
    void show_patientRecords(MouseEvent event) throws IOException {
        removeStyle();
        RecepDashPatientBtn.getStyleClass().add("jfx-button-recep-vbox-dash-selected");
        Parent patientRecords = FXMLLoader.load(getClass().getResource("/sample/view/ReceptDashPatientRecords.fxml"));
        RecepDashBoarderPane.setCenter(patientRecords);
    }
    @FXML
    void show_visitorRecords(MouseEvent event) throws IOException {
        removeStyle();
        RecepDashVisitorBtn.getStyleClass().add("jfx-button-recep-vbox-dash-selected");
        Parent visitorRecords = FXMLLoader.load(getClass().getResource("/sample/view/ReceptDashVisitorRecords.fxml"));
        RecepDashBoarderPane.setCenter(visitorRecords);
    }

    @FXML
    void show_acc_settings(MouseEvent event) throws IOException {
        removeStyle();
        RecepDashUserBtn.getStyleClass().add("jfx-button-recep-vbox-dash-selected");
        Parent visitorRecords = FXMLLoader.load(getClass().getResource("/sample/view/RecepUserSettings.fxml"));
        RecepDashBoarderPane.setCenter(visitorRecords);
    }

    public void removeStyle(){
        RecepDashVisitorBtn.getStyleClass().remove("jfx-button-recep-vbox-dash-selected");
        RecepDashUserBtn.getStyleClass().remove("jfx-button-recep-vbox-dash-selected");
        RecepDashComplaintBtn.getStyleClass().remove("jfx-button-recep-vbox-dash-selected");
        RecepDashPatientBtn.getStyleClass().remove("jfx-button-recep-vbox-dash-selected");
        RecepDashAppointmentBtn.getStyleClass().remove("jfx-button-recep-vbox-dash-selected");
        Logout.getStyleClass().remove("jfx-button-recep-vbox-dash-selected");
        RecepDashPostalBtn.getStyleClass().remove("jfx-button-recep-vbox-dash-selected");
        AdDashHomeBtn.getStyleClass().remove("jfx-button-recep-vbox-dash-selected");
    }

    @FXML
    void initialize() throws IOException {
        // instantiation
        UserEditDelete newEditProfile = new UserEditDelete(0);
        newEditProfile.UserEdit(LoginController.currentUser);
        String[] RecepDetails = newEditProfile.getUserDetailArray();

        // set up the profile picture
        FileInputStream profileStream = new FileInputStream(RecepDetails[13]);
        Image proImg = new Image(profileStream);
        profileImg.setFill(new ImagePattern(proImg));

        // set text to label under change own profile image tab
        UserFullName.setText(RecepDetails[2]+" "+RecepDetails[3]);
        UserUsername.setText("#"+RecepDetails[0]);

//        // set up the profile picture
//        profile = "src/sample/app/profile/harry.jpg";
//        FileInputStream profileStream = new FileInputStream(profile);
//        Image proImg = new Image(profileStream);
//        profileImg.setFill(new ImagePattern(proImg));

        removeStyle();
        AdDashHomeBtn.getStyleClass().add("jfx-button-recep-vbox-dash-selected");
        Parent appointmentPane = FXMLLoader.load(getClass().getResource("/sample/view/RecepDashHome.fxml"));
        RecepDashBoarderPane.setCenter(appointmentPane);

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

}
