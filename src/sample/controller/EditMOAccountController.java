package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import sample.model.*;

public class EditMOAccountController {

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
    private StackPane EditMOStackPane;

    @FXML
    private AnchorPane EditMoAnchor;

    @FXML
    private BorderPane EditMOBoarderPane;

    @FXML
    private JFXButton EditUserMOSaveChange;

    @FXML
    private JFXTextField EditUserEditFirstName;

    @FXML
    private JFXTextField EditUserEditPassword;

    @FXML
    private JFXTextField EditUserEditLastName;

    @FXML
    private JFXTextField EditUserEditUsername;

    @FXML
    private JFXTextField EditUserEditPhoneNumber;

    @FXML
    private JFXTextField EditUserEditIDCardNumber;

    @FXML
    private JFXTextField EditUserEditAddLine2;

    @FXML
    private JFXTextField EditUserEditAddLine1;

    @FXML
    private JFXComboBox<String> EditUserEditMaritalStatus;

    @FXML
    private JFXTextField EditUserEditAddCity;

    @FXML
    private JFXTextField EditUserEditAddCountry;

    @FXML
    private JFXTextField EditUserEditMOEmail;

    @FXML
    private JFXComboBox<String> EditUserMOSpecificArea;

    @FXML
    void SaveChanges(MouseEvent event) {
        try{
            UserEditDelete newEditProfile = new UserEditDelete(2);
            newEditProfile.UserDelete(AdDashEditUserController.username);
            ValidationController validate = new ValidationController(EditMOStackPane, EditMoAnchor, 1);
            if(        validate.validatePhone(EditUserEditPhoneNumber)
                    && validate.validateUsername(EditUserEditUsername)
                    && validate.sameIDNo(EditUserEditIDCardNumber)
                    && validate.samePhoneNumber(EditUserEditPhoneNumber)
                    && validate.sameStaffEmail(EditUserEditMOEmail)){

                MedicalOfficer editMO = new MedicalOfficer();

                editMO.setFirstName(EditUserEditFirstName.getText().trim());
                editMO.setLastName(EditUserEditLastName.getText().trim());
                editMO.setUserName(EditUserEditUsername.getText().trim());
                editMO.setIdNo(EditUserEditIDCardNumber.getText().trim());
                editMO.setPassword(EditUserEditPassword.getText().trim());
                editMO.setGender(getUserDetailArray()[6]);
                editMO.setPhoneNumber(EditUserEditPhoneNumber.getText().trim());
                editMO.setMaritalStatus(EditUserEditMaritalStatus.getValue());
                editMO.setDOB(LocalDate.parse(getUserDetailArray()[7]));
                editMO.setAddressLine1(EditUserEditAddLine1.getText().trim());
                editMO.setAddressLine2(EditUserEditAddLine2.getText().trim());
                editMO.setCity(EditUserEditAddCity.getText().trim());
                editMO.setCountry(EditUserEditAddCountry.getText().trim());
                editMO.setProfilePicPath(getUserDetailArray()[13]);
                editMO.setStaffID(getUserDetailArray()[14]);
                editMO.setStaffEmail(EditUserEditMOEmail.getText().trim());
                editMO.setDateOfJoin(LocalDate.parse(getUserDetailArray()[16]));
                editMO.setSpecialtyArea(EditUserMOSpecificArea.getValue());

                UserAdd.writeToFile(editMO, 3);
                validate.successfulUserCreation("Medical Officer Account Successfully Updated");
                afterCreation();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void afterCreation() throws IOException {
        Parent white = FXMLLoader.load(getClass()
                .getResource("/sample/view/WhiteBlank.fxml"));
        EditMOBoarderPane.setCenter(white);
    }

    @FXML
    void initialize() {
        // combo-box items for marital status at create user account
        EditUserEditMaritalStatus.getItems().add("Unmarried");
        EditUserEditMaritalStatus.getItems().add("Married");
        EditUserEditMaritalStatus.getItems().add("Divorced");
        EditUserEditMaritalStatus.getItems().add("Widowed");
        EditUserEditMaritalStatus.getItems().add("Legally Separated");

        // add items to the medical officer specialist areas
        AdReference.readItem(EditUserMOSpecificArea, 0);

        UserEditDelete newEditProfile = new UserEditDelete(2);
        newEditProfile.UserEdit(AdDashEditUserController.username);
        String[] MODetails = newEditProfile.getUserDetailArray();
        setUserDetailArray(MODetails);
        EditUserEditUsername.setText(MODetails[0]);
        EditUserEditPassword.setText(MODetails[1]);
        EditUserEditFirstName.setText(MODetails[2]);
        EditUserEditLastName.setText(MODetails[3]);
        EditUserEditIDCardNumber.setText(MODetails[4]);
        EditUserEditPhoneNumber.setText(MODetails[5]);
        EditUserEditMaritalStatus.setValue(MODetails[8]);
        EditUserEditAddLine1.setText(MODetails[9]);
        EditUserEditAddLine2.setText(MODetails[10]);
        EditUserEditAddCity.setText(MODetails[11]);
        EditUserEditAddCountry.setText(MODetails[12]);
        EditUserEditMOEmail.setText(MODetails[15]);
        EditUserMOSpecificArea.setValue(MODetails[17]);

    }
}
