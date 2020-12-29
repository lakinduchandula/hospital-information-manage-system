package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import sample.model.*;

import java.io.IOException;
import java.time.LocalDate;

import static java.time.LocalDate.parse;

public class RecepEditPatientController {
    @FXML
    private StackPane EditPatientStackPane;

    @FXML
    private BorderPane EditPatientBorderPane;

    @FXML
    private AnchorPane EditPatientAnchorPane;

    @FXML
    private JFXTextField EditPatientFirstName;

    @FXML
    private JFXTextField EditPatientLastName;

    @FXML
    private JFXComboBox<String> EditPatientGender;

    @FXML
    private JFXTextField EditPatientIDCardNumber;

    @FXML
    private JFXComboBox<String> EditPatientMaritalStatus;

    @FXML
    private JFXTextField EditPatientPhoneNumber;

    @FXML
    private JFXTextField EditPatientAddressLine1;

    @FXML
    private JFXTextField EditPatientAddressLine2;

    @FXML
    private JFXTextField EditPatientCity;

    @FXML
    private JFXDatePicker EditPatientDOB;

    @FXML
    private JFXComboBox<String> EditPatientBloodGroup;

    @FXML
    private JFXTextField EditPatientAllergies;

    @FXML
    private JFXButton EditPatientSaveChange;

    @FXML
    void SaveChanges(MouseEvent event) {
        try{

            ValidationController validate = new ValidationController(EditPatientStackPane, EditPatientAnchorPane, 1);
            if(        validate.validatePhone(EditPatientPhoneNumber)
                    && validate.validateNIC(EditPatientIDCardNumber))
                   {

                       RecepPatient editRecepPatient = new RecepPatient();

                       editRecepPatient.setFirstName(EditPatientFirstName.getText().trim());
                       editRecepPatient.setLastName(EditPatientLastName.getText().trim());
                       editRecepPatient.setIdCardNo(EditPatientIDCardNumber.getText().trim());
                       editRecepPatient.setGender(EditPatientGender.getValue());
                       editRecepPatient.setPhoneNumber(EditPatientPhoneNumber.getText().trim());
                       editRecepPatient.setMaritalStatus(EditPatientMaritalStatus.getValue());
                       editRecepPatient.setdOB(EditPatientDOB.getValue());
                       editRecepPatient.setAddressLine1(EditPatientAddressLine1.getText().trim());
                       editRecepPatient.setAddressLine2(EditPatientAddressLine2.getText().trim());
                       editRecepPatient.setCity(EditPatientCity.getText().trim());
                       editRecepPatient.setBloodGroup(EditPatientBloodGroup.getValue());
                       editRecepPatient.setAllergies(EditPatientAllergies.getText().trim());

                RecepAddPatient.writeToFile(editRecepPatient);
                validate.successfulUserCreation("Patient Record Successfully Updated");
                afterCreation();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void afterCreation() throws IOException {
        Parent white = FXMLLoader.load(getClass()
                .getResource("/sample/view/WhiteBlank.fxml"));
        EditPatientBorderPane.setCenter(white);
    }

    @FXML
    void initialize() {
        // combo-box items for marital status at edit account
        EditPatientMaritalStatus.getItems().add("Unmarried");
        EditPatientMaritalStatus.getItems().add("Married");
        EditPatientMaritalStatus.getItems().add("Divorced");
        EditPatientMaritalStatus.getItems().add("Widowed");
        EditPatientMaritalStatus.getItems().add("Legally Separated");


        // combo-box items for blood-group status at edit account
        EditPatientBloodGroup.getItems().add("A+");
        EditPatientBloodGroup.getItems().add("A-");
        EditPatientBloodGroup.getItems().add("B+");
        EditPatientBloodGroup.getItems().add("B-");
        EditPatientBloodGroup.getItems().add("O+");
        EditPatientBloodGroup.getItems().add("O-");
        EditPatientBloodGroup.getItems().add("AB+");
        EditPatientBloodGroup.getItems().add("AB-");

        // combo-box items for gender at edit patient
        EditPatientGender.getItems().add("Male");
        EditPatientGender.getItems().add("Female");

        RecepPatient editRecepPatient = new RecepPatient();
        editRecepPatient.getRecepPatientDetailsArray(ReceptDashPatientRecordsController.PatientIDGlobal);
        String[] PatientDetails = editRecepPatient.getRecepPatientDetails();
        editRecepPatient.setRecepPatientDetails(PatientDetails);


        EditPatientIDCardNumber.setText(PatientDetails[0]);
        EditPatientFirstName.setText(PatientDetails[1]);
        EditPatientLastName.setText(PatientDetails[2]);
        EditPatientGender.setValue(PatientDetails[3]);
        EditPatientDOB.setValue(parse(PatientDetails[4]));
        EditPatientPhoneNumber.setText(PatientDetails[6]);
        EditPatientMaritalStatus.setValue(PatientDetails[5]);
        EditPatientAddressLine1.setText(PatientDetails[7]);
        EditPatientAddressLine2.setText(PatientDetails[8]);
        EditPatientCity.setText(PatientDetails[9]);
        EditPatientBloodGroup.setValue(PatientDetails[10]);
        EditPatientAllergies.setText(PatientDetails[11]);


    }


}
