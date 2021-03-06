package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
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

public class MOUserSettingsController {

    private String[] userDetailArray ;

    public void setUserDetailArray(String[] userDetailArray){
        this.userDetailArray = userDetailArray;
    }

    public String[] getUserDetailArray(){
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
    private JFXComboBox<String> AccSettingsSpeciality;

    @FXML
    private JFXTextField AccSettingsPassword;

    @FXML
    private Circle UserSettingsProfile;

    @FXML
    private ImageView AddImage;

    @FXML
    private Label userFullName;

    @FXML
    private Label userUsername;

    @FXML
    private Label userStaffID;

    @FXML
    private Label userSpecialArea;

    String profileImgPath;


    @FXML
    void update_Account(MouseEvent event) {
        try{
            UploadProfileImg MOImgEdit = new UploadProfileImg();
            UserEditDelete newEditProfile = new UserEditDelete(2);
            MOImgEdit.deleteOldProfileImg(getUserDetailArray()[13]);
            newEditProfile.UserDelete(LoginController.currentUser);
            ValidationController validate = new ValidationController(AccSettingsStackPane, AccSettingsAnchorPane,
                    2);
            if(        validate.validatePhone(AccSettingsPhoneNumber)
                    && validate.validateNIC(AccSettingsUserID)
                    && validate.validateUsername(AccSettingsUsername)
                    && validate.sameIDNo(AccSettingsUserID)
                    && validate.samePhoneNumber(AccSettingsPhoneNumber)){

                MedicalOfficer editMOUserSettings = new MedicalOfficer();

                editMOUserSettings.setFirstName(AccSettingsFirstName.getText().trim());
                editMOUserSettings.setLastName(AccSettingsLastName.getText().trim());
                editMOUserSettings.setUserName(AccSettingsUsername.getText().trim());
                editMOUserSettings.setIdNo(AccSettingsUserID.getText().trim());
                editMOUserSettings.setPassword(AccSettingsPassword.getText().trim());
                editMOUserSettings.setGender(getUserDetailArray()[6]);
                editMOUserSettings.setPhoneNumber(AccSettingsPhoneNumber.getText().trim());
                editMOUserSettings.setMaritalStatus(AccSettingMarital.getValue());
                editMOUserSettings.setDOB(LocalDate.parse(getUserDetailArray()[7]));
                editMOUserSettings.setAddressLine1(AccSettingsAddress1.getText().trim());
                editMOUserSettings.setAddressLine2(AccSettingsAddress2.getText().trim());
                editMOUserSettings.setCity(AccSettingsCity.getText().trim());
                editMOUserSettings.setCountry(AccSettingsCountry.getText().trim());
                editMOUserSettings.setProfilePicPath(profileImgPath);
                editMOUserSettings.setStaffID(getUserDetailArray()[14]);
                editMOUserSettings.setStaffEmail(getUserDetailArray()[15]);
                editMOUserSettings.setDateOfJoin(LocalDate.parse(getUserDetailArray()[16]));
                editMOUserSettings.setSpecialtyArea(AccSettingsSpeciality.getValue());
                UserDetailsTop();

                UserAdd.writeToFile(editMOUserSettings, 3);
                validate.successfulUserCreation("Medical Officer Account Successfully Updated");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void add_profile_pic(MouseEvent mouseEvent) throws IOException {

        UploadProfileImg receptionistImg = new UploadProfileImg();
        profileImgPath = receptionistImg.uploadProfilePicture(getUserDetailArray()[13]);

        FileInputStream profileStream = new FileInputStream(profileImgPath);
        Image proImg = new Image(profileStream);
        UserSettingsProfile.setFill(new ImagePattern(proImg));
    }

    @FXML
    void initialize() throws FileNotFoundException {
        // combo-box items for marital status at create user account
        AccSettingMarital.getItems().add("Unmarried");
        AccSettingMarital.getItems().add("Married");
        AccSettingMarital.getItems().add("Divorced");
        AccSettingMarital.getItems().add("Widowed");
        AccSettingMarital.getItems().add("Legally Separated");

        // add items to the medical officer specialist areas
        AdReference.readItem(AccSettingsSpeciality, 0);

        UserEditDelete newEditProfile = new UserEditDelete(2);
        newEditProfile.UserEdit(LoginController.currentUser);
        String[] MODetails = newEditProfile.getUserDetailArray();
        setUserDetailArray(MODetails);

        AccSettingsUsername.setText(MODetails[0]);
        AccSettingsPassword.setText(MODetails[1]);
        AccSettingsFirstName.setText(MODetails[2]);
        AccSettingsLastName.setText(MODetails[3]);
        AccSettingsUserID.setText(MODetails[4]);
        AccSettingsPhoneNumber.setText(MODetails[5]);
        AccSettingMarital.setValue(MODetails[8]);
        AccSettingsAddress1.setText(MODetails[9]);
        AccSettingsAddress2.setText(MODetails[10]);
        AccSettingsCity.setText(MODetails[11]);
        AccSettingsCountry.setText(MODetails[12]);
        AccSettingsSpeciality.setValue(MODetails[17]);

        // set text to label under change own profile image tab
        userFullName.setText(MODetails[2]+" "+MODetails[3]);
        userUsername.setText("#"+MODetails[0]);
        userStaffID.setText(MODetails[14]);
        userSpecialArea.setText(MODetails[17]);

        // set up the profile picture
        profileImgPath = MODetails[13];
        FileInputStream profileStream = new FileInputStream(profileImgPath);
        Image proImg = new Image(profileStream);
        UserSettingsProfile.setFill(new ImagePattern(proImg));
    }

    public void UserDetailsTop(){
        // set text to label under change own profile image tab
        userFullName.setText(AccSettingsFirstName.getText().trim()+" "+AccSettingsLastName.getText().trim());
        userUsername.setText("#"+AccSettingsUsername.getText().trim());
        userSpecialArea.setText(AccSettingsSpeciality.getValue());
    }
}
