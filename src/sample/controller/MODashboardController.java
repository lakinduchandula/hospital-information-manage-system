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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import sample.model.UserEditDelete;

import java.io.FileInputStream;
import java.io.IOException;

public class MODashboardController {


    @FXML
    private BorderPane MODashBorderPane;

    @FXML
    private Circle profileImg;

    @FXML
    private Label UserFullName;

    @FXML
    private Label UserUsername;

    @FXML
    private JFXButton MODashHome;

    @FXML
    private JFXButton PatientDashAppointment;

    @FXML
    private JFXButton PatientDashUserBtn;

    @FXML
    private JFXButton Logout;

    @FXML
    void show_account_Setting(MouseEvent event) throws IOException {
        removeStyle();
        MODashHome.getStyleClass().add("jfx-button-medical-vbox-dash-selected");
        Parent complaint = FXMLLoader.load(getClass().getResource("/sample/view/MODashHome.fxml"));
        MODashBorderPane.setCenter(complaint);
    }

    @FXML
    void show_home(MouseEvent event) throws IOException {
        removeStyle();
        MODashHome.getStyleClass().add("jfx-button-medical-vbox-dash-selected");
        Parent complaint = FXMLLoader.load(getClass().getResource("/sample/view/MODashHome.fxml"));
        MODashBorderPane.setCenter(complaint);
    }

    @FXML
    void show_Appointments(MouseEvent event) throws IOException {
        removeStyle();
        PatientDashAppointment.getStyleClass().add("jfx-button-medical-vbox-dash-selected");
        Parent complaint = FXMLLoader.load(getClass().getResource("/sample/view/MODashAppointment.fxml"));
        MODashBorderPane.setCenter(complaint);
    }

    @FXML
    void show_user_settings(MouseEvent event) throws IOException {
        removeStyle();
        PatientDashUserBtn.getStyleClass().add("jfx-button-medical-vbox-dash-selected");
        Parent userSettings = FXMLLoader.load(getClass().getResource("/sample/view/MOUserSettings.fxml"));
        MODashBorderPane.setCenter(userSettings);
    }

    @FXML
    void logout(MouseEvent event) {

    }

    public void removeStyle(){
        PatientDashAppointment.getStyleClass().remove("jfx-button-medical-vbox-dash-selected");
        PatientDashUserBtn.getStyleClass().remove("jfx-button-medical-vbox-dash-selected");
        Logout.getStyleClass().remove("jfx-button-medical-vbox-dash-selected");
        MODashHome.getStyleClass().remove("jfx-button-medical-vbox-dash-selected");
    }

    @FXML
    void initialize() throws IOException {
        removeStyle();
        MODashHome.getStyleClass().add("jfx-button-medical-vbox-dash-selected");
        Parent complaint = FXMLLoader.load(getClass().getResource("/sample/view/MODashHome.fxml"));
        MODashBorderPane.setCenter(complaint);

        UserEditDelete newEditProfile = new UserEditDelete(2);
        newEditProfile.UserEdit(LoginController.currentUser);
        String[] MODetails = newEditProfile.getUserDetailArray();

        // set up the profile picture
        FileInputStream profileStream = new FileInputStream(MODetails[13]);
        Image proImg = new Image(profileStream);
        profileImg.setFill(new ImagePattern(proImg));

        // set text to label under change own profile image tab
        UserFullName.setText(MODetails[2]+" "+MODetails[3]);
        UserUsername.setText("#"+MODetails[0]);

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
