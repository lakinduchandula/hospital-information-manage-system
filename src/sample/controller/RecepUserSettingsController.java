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
import sample.model.Receptionist;
import sample.model.UploadProfileImg;
import sample.model.UserAdd;
import sample.model.UserEditDelete;

public class RecepUserSettingsController {

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
    private JFXTextField AccSettingsPassword;


    @FXML
    private JFXComboBox<String> AccSettingMarital;

    @FXML
    private Circle UserSettingsProfile;

    private String profileImgPath;

    @FXML
    private ImageView AddImage;

    @FXML
    private Label userFullName;

    @FXML
    private Label userUsername;

    @FXML
    private Label userStaffID;

    @FXML
    private Label userEmailAddress;

    public void add_profile_pic(MouseEvent mouseEvent) throws IOException {

        UploadProfileImg receptionistImg = new UploadProfileImg();
        profileImgPath = receptionistImg.uploadProfilePicture(getUserDetailArray()[13]);

        FileInputStream profileStream = new FileInputStream(profileImgPath);
        Image proImg = new Image(profileStream);
        UserSettingsProfile.setFill(new ImagePattern(proImg));
    }

    @FXML
    void update_Account(MouseEvent event) {
        try{
            UploadProfileImg receptionistImgEdit = new UploadProfileImg();
            UserEditDelete newEditProfile = new UserEditDelete(0);
            receptionistImgEdit.deleteOldProfileImg(getUserDetailArray()[13]);
            newEditProfile.UserDelete(LoginController.currentUser);
            ValidationController validate = new ValidationController(AccSettingsStackPane, AccSettingsAnchorPane,
                    4);
            if(        validate.validatePhone(AccSettingsPhoneNumber)
                    && validate.validateUsername(AccSettingsUsername)
                    && validate.validateNIC(AccSettingsUserID)
                    && validate.sameIDNo(AccSettingsUserID)
                    && validate.samePhoneNumber(AccSettingsPhoneNumber)){

                Receptionist editReceptionistUser = new Receptionist();

                editReceptionistUser.setFirstName(AccSettingsFirstName.getText().trim());
                editReceptionistUser.setLastName(AccSettingsLastName.getText().trim());
                editReceptionistUser.setUserName(AccSettingsUsername.getText().trim());
                editReceptionistUser.setIdNo(AccSettingsUserID.getText().trim());
                editReceptionistUser.setPassword(AccSettingsPassword.getText().trim());
                editReceptionistUser.setGender(getUserDetailArray()[6]);
                editReceptionistUser.setPhoneNumber(AccSettingsPhoneNumber.getText().trim());
                editReceptionistUser.setMaritalStatus(AccSettingMarital.getValue());
                editReceptionistUser.setDOB(LocalDate.parse(getUserDetailArray()[7]));
                editReceptionistUser.setAddressLine1(AccSettingsAddress1.getText().trim());
                editReceptionistUser.setAddressLine2(AccSettingsAddress2.getText().trim());
                editReceptionistUser.setCity(AccSettingsCity.getText().trim());
                editReceptionistUser.setCountry(AccSettingsCountry.getText().trim());
                editReceptionistUser.setProfilePicPath(profileImgPath);
                editReceptionistUser.setStaffID(getUserDetailArray()[14]);
                editReceptionistUser.setStaffEmail(getUserDetailArray()[15]);
                editReceptionistUser.setDateOfJoin(LocalDate.parse(getUserDetailArray()[16]));
                UserDetailsTop();

                UserAdd.writeToFile(editReceptionistUser, 1);
                validate.successfulUserCreation("Receptionist Account Successfully Updated");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() throws FileNotFoundException {
        // instantiation
        UserEditDelete newEditProfile = new UserEditDelete(0);
        newEditProfile.UserEdit(LoginController.currentUser);
        String[] RecepDetails = newEditProfile.getUserDetailArray();
        setUserDetailArray(RecepDetails);

        // set up the profile picture
        profileImgPath = RecepDetails[13];
        FileInputStream profileStream = new FileInputStream(profileImgPath);
        Image proImg = new Image(profileStream);
        UserSettingsProfile.setFill(new ImagePattern(proImg));

        // combo-box items for marital status at create user account
        AccSettingMarital.getItems().add("Unmarried");
        AccSettingMarital.getItems().add("Married");
        AccSettingMarital.getItems().add("Divorced");
        AccSettingMarital.getItems().add("Widowed");
        AccSettingMarital.getItems().add("Legally Separated");

        // set text to label under change own profile image tab
        userFullName.setText(RecepDetails[2]+" "+RecepDetails[3]);
        userUsername.setText("#"+RecepDetails[0]);
        userStaffID.setText(RecepDetails[14]);
        userEmailAddress.setText(RecepDetails[15]);

        AccSettingsUsername.setText(RecepDetails[0]);
        AccSettingsPassword.setText(RecepDetails[1]);
        AccSettingsFirstName.setText(RecepDetails[2]);
        AccSettingsLastName.setText(RecepDetails[3]);
        AccSettingsUserID.setText(RecepDetails[4]);
        AccSettingsPhoneNumber.setText(RecepDetails[5]);
        AccSettingMarital.setValue(RecepDetails[8]);
        AccSettingsAddress1.setText(RecepDetails[9]);
        AccSettingsAddress2.setText(RecepDetails[10]);
        AccSettingsCity.setText(RecepDetails[11]);
        AccSettingsCountry.setText(RecepDetails[12]);

        UserDetailsTop();
    }

    public void UserDetailsTop(){
        // set text to label under change own profile image tab
        userFullName.setText(AccSettingsFirstName.getText().trim()+" "+AccSettingsLastName.getText().trim());
        userUsername.setText("#"+AccSettingsUsername.getText().trim());
    }
}
