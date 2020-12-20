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
import sample.model.Receptionist;
import sample.model.UserAdd;
import sample.model.UserEditDelete;

public class EditReceptionistAccountController {


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
    private StackPane EditRecepAccStackPane;

    @FXML
    private BorderPane EditUserBoarderPane;

    @FXML
    private AnchorPane RecepMainAnchor;

    @FXML
    private JFXTextField EditUserEditFirstName;

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
    private JFXButton EditUserSaveChange;

    @FXML
    private JFXTextField EditUserEditPassword;

    @FXML
    private JFXTextField EditUserEditStaffEmail;

    @FXML
    void SaveChanges(MouseEvent event) {
        try{
            UserEditDelete newEditProfile = new UserEditDelete(0);
            newEditProfile.UserDelete(AdDashEditUserController.username);
            ValidationController validate = new ValidationController(EditRecepAccStackPane, RecepMainAnchor, 1);
            if(        validate.validEmail(EditUserEditStaffEmail)
                    && validate.validatePhone(EditUserEditPhoneNumber)
                    && validate.validateUsername(EditUserEditUsername)
                    && validate.sameIDNo(EditUserEditIDCardNumber)
                    && validate.samePhoneNumber(EditUserEditPhoneNumber)
                    && validate.sameStaffEmail(EditUserEditStaffEmail)){
                Receptionist editReceptionist = new Receptionist();

                editReceptionist.setFirstName(EditUserEditFirstName.getText().trim());
                editReceptionist.setLastName(EditUserEditLastName.getText().trim());
                editReceptionist.setUserName(EditUserEditUsername.getText().trim());
                editReceptionist.setIdNo(EditUserEditIDCardNumber.getText().trim());
                editReceptionist.setPassword(EditUserEditPassword.getText().trim());
                editReceptionist.setGender(getUserDetailArray()[6]);
                editReceptionist.setPhoneNumber(EditUserEditPhoneNumber.getText().trim());
                editReceptionist.setMaritalStatus(EditUserEditMaritalStatus.getValue());
                editReceptionist.setDOB(LocalDate.parse(getUserDetailArray()[7]));
                editReceptionist.setAddressLine1(EditUserEditAddLine1.getText().trim());
                editReceptionist.setAddressLine2(EditUserEditAddLine2.getText().trim());
                editReceptionist.setCity(EditUserEditAddCity.getText().trim());
                editReceptionist.setCountry(EditUserEditAddCountry.getText().trim());
                editReceptionist.setStaffID(getUserDetailArray()[13]);
                editReceptionist.setStaffEmail(EditUserEditStaffEmail.getText().trim());
                editReceptionist.setDateOfJoin(LocalDate.parse(getUserDetailArray()[15]));

                UserAdd.writeToFile(editReceptionist, 1);
                validate.successfulUserCreation("Receptionist Account Successfully Updated");
                afterCreation();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void afterCreation() throws IOException {
        Parent white = FXMLLoader.load(getClass()
                .getResource("/sample/view/WhiteBlank.fxml"));
        EditUserBoarderPane.setCenter(white);
    }

    @FXML
    void initialize() {

        // combo-box items for marital status at create user account
        EditUserEditMaritalStatus.getItems().add("Unmarried");
        EditUserEditMaritalStatus.getItems().add("Married");
        EditUserEditMaritalStatus.getItems().add("Divorced");
        EditUserEditMaritalStatus.getItems().add("Widowed");
        EditUserEditMaritalStatus.getItems().add("Legally Separated");

        UserEditDelete newEditProfile = new UserEditDelete(0);
        newEditProfile.UserEdit(AdDashEditUserController.username);
        String[] RecepDetails = newEditProfile.getUserDetailArray();
        setUserDetailArray(RecepDetails);
        EditUserEditUsername.setText(RecepDetails[0]);
        EditUserEditPassword.setText(RecepDetails[1]);
        EditUserEditFirstName.setText(RecepDetails[2]);
        EditUserEditLastName.setText(RecepDetails[3]);
        EditUserEditIDCardNumber.setText(RecepDetails[4]);
        EditUserEditPhoneNumber.setText(RecepDetails[5]);
        EditUserEditMaritalStatus.setValue(RecepDetails[8]);
        EditUserEditAddLine1.setText(RecepDetails[9]);
        EditUserEditAddLine2.setText(RecepDetails[10]);
        EditUserEditAddCity.setText(RecepDetails[11]);
        EditUserEditAddCountry.setText(RecepDetails[12]);
        EditUserEditStaffEmail.setText(RecepDetails[14]);


    }

}
