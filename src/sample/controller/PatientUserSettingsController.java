package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import sample.model.*;

public class PatientUserSettingsController {

    private String[] userDetailArray;

    public void setUserDetailArray(String[] userDetailArray) {
        this.userDetailArray = userDetailArray;
    }

    public String[] getUserDetailArray() {
        return userDetailArray;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private StackPane AccSettingsStackPane;

    @FXML
    private AnchorPane AccSettingsAnchorPane;

    @FXML
    private JFXTextField AccSettingsCity;

    @FXML
    private JFXTextField AccSettingsAddress2;

    @FXML
    private JFXTextField AccSettingsAddress1;

    @FXML
    private JFXTextField AccSettingsUserID;

    @FXML
    private JFXTextField AccSettingsPhoneNumber;

    @FXML
    private JFXTextField AccSettingsUsername;

    @FXML
    private JFXTextField AccSettingsLastName;

    @FXML
    private JFXTextField AccSettingsCountry;

    @FXML
    private JFXTextField AccSettingsFirstName;

    @FXML
    private JFXButton AccSettingsUpdateBtn;

    @FXML
    private JFXComboBox<String> AccSettingMarital;

    @FXML
    private JFXTextField AccSettingsPassword;

    @FXML
    private JFXTextArea AccSettingAllergies;

    @FXML
    private Label userFullName;

    @FXML
    private Label userUsername;

    @FXML
    private Label userStaffID;

    @FXML
    private Label userEmailAddress;

    @FXML
    private Circle UserSettingsProfile;

    private String profileImgPath;

    @FXML
    private ImageView AddImage;

    public void add_profile_pic(MouseEvent mouseEvent) throws IOException {

        UploadProfileImg patientImgEdit = new UploadProfileImg();
        profileImgPath = patientImgEdit.uploadProfilePicture(getUserDetailArray()[13]);

        FileInputStream profileStream = new FileInputStream(profileImgPath);
        Image proImg = new Image(profileStream);
        UserSettingsProfile.setFill(new ImagePattern(proImg));
    }

    @FXML
    void update_Account(MouseEvent event) {
        try {
            UploadProfileImg patientImgEdit = new UploadProfileImg();
            UserEditDelete newEditProfile = new UserEditDelete(1);
            newEditProfile.UserDelete(LoginController.currentUser);
            ValidationController validate = new ValidationController(AccSettingsStackPane, AccSettingsAnchorPane,
                    4);
            if (validate.validatePhone(AccSettingsPhoneNumber)
                    && validate.validateUsername(AccSettingsUsername)
                    && validate.validateNIC(AccSettingsUserID)
                    && validate.sameIDNo(AccSettingsUserID)
                    && validate.samePhoneNumber(AccSettingsPhoneNumber)) {

                Patient editPatientUser = new Patient();

                editPatientUser.setFirstName(AccSettingsFirstName.getText().trim());
                editPatientUser.setLastName(AccSettingsLastName.getText().trim());
                editPatientUser.setUserName(AccSettingsUsername.getText().trim());
                editPatientUser.setIdNo(AccSettingsUserID.getText().trim());
                editPatientUser.setPassword(AccSettingsPassword.getText().trim());
                editPatientUser.setGender(getUserDetailArray()[6]);
                editPatientUser.setPhoneNumber(AccSettingsPhoneNumber.getText().trim());
                editPatientUser.setMaritalStatus(AccSettingMarital.getValue());
                editPatientUser.setDOB(LocalDate.parse(getUserDetailArray()[7]));
                editPatientUser.setAddressLine1(AccSettingsAddress1.getText().trim());
                editPatientUser.setAddressLine2(AccSettingsAddress2.getText().trim());
                editPatientUser.setCity(AccSettingsCity.getText().trim());
                editPatientUser.setCountry(AccSettingsCountry.getText().trim());
                editPatientUser.setProfilePicPath(profileImgPath);
                editPatientUser.setAllergies(GetSetTextArea.getText(AccSettingAllergies.getText().trim()));
                editPatientUser.setGhostUniqueID(getUserDetailArray()[16]);
                editPatientUser.setBloodGroup(getUserDetailArray()[11]);
                UserDetailsTop();

                UserAdd.writeToFile(editPatientUser, 2);
                validate.successfulUserCreation("Patient Account Successfully Updated");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() throws FileNotFoundException {
        // instantiation
        UserEditDelete newEditProfile = new UserEditDelete(1);
        newEditProfile.UserEdit(LoginController.currentUser);
        String[] patientDetails = newEditProfile.getUserDetailArray();
        setUserDetailArray(patientDetails);

        // set up the profile picture
        profileImgPath = patientDetails[13];
        FileInputStream profileStream = new FileInputStream(profileImgPath);
        Image proImg = new Image(profileStream);
        UserSettingsProfile.setFill(new ImagePattern(proImg));

        // combo-box items for marital status at create user account
        AccSettingMarital.getItems().add("Unmarried");
        AccSettingMarital.getItems().add("Married");
        AccSettingMarital.getItems().add("Divorced");
        AccSettingMarital.getItems().add("Widowed");
        AccSettingMarital.getItems().add("Legally Separated");

        String[] PatientDetails = newEditProfile.getUserDetailArray();
        setUserDetailArray(PatientDetails);

        AccSettingsUsername.setText(PatientDetails[0]);
        AccSettingsPassword.setText(PatientDetails[1]);
        AccSettingsFirstName.setText(PatientDetails[2]);
        AccSettingsLastName.setText(PatientDetails[3]);
        AccSettingsUserID.setText(PatientDetails[4]);
        AccSettingsPhoneNumber.setText(PatientDetails[5]);
        AccSettingMarital.setValue(PatientDetails[8]);
        AccSettingsAddress1.setText(PatientDetails[9]);
        AccSettingsAddress2.setText(PatientDetails[10]);
        AccSettingsCity.setText(PatientDetails[11]);
        AccSettingsCountry.setText(PatientDetails[12]);
        AccSettingAllergies.setText(GetSetTextArea.setText(PatientDetails[15]));

        userStaffID.setText(AccSettingsUserID.getText());
        userEmailAddress.setText(AccSettingsPhoneNumber.getText());


        UserDetailsTop();
    }

    public void UserDetailsTop() {
        // set text to label under change own profile image tab
        userFullName.setText(AccSettingsFirstName.getText().trim() + " " + AccSettingsLastName.getText().trim());
        userUsername.setText("#" + AccSettingsUsername.getText().trim());

    }
}
