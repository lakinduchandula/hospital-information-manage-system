package sample.controller;

import com.jfoenix.controls.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import sample.model.*;

import javax.print.DocFlavor;
import java.io.IOException;

public class ReceptDashPatientRecordsController {

    public static String PatientIDGlobal;

    @FXML
    private StackPane RecepAddPatientStackPane;

    @FXML
    private AnchorPane RecepAddPatientAnchorPane;

    @FXML
    private JFXTextField AddPatientFirstName;

    @FXML
    private JFXTextField AddPatientUsername;

    @FXML
    private JFXComboBox<String> AddPatientGender;

    @FXML
    private JFXComboBox<String> AddPatientMaritalStatus;

    @FXML
    private JFXTextField AddPatientAddressLine1;

    @FXML
    private JFXTextField AddPatientCity;

    @FXML
    private JFXTextField AddPatientLastName;

    @FXML
    private JFXTextField AddPatientIDCardNumber;

    @FXML
    private JFXTextField AddPatientPhoneNumber;

    @FXML
    private JFXDatePicker AddPatientDOB;

    @FXML
    private JFXTextField AddPatientAddressLine2;

    @FXML
    private JFXTextField AddPatientCountry;

    @FXML
    private JFXComboBox<String> AddPatientBloodGroup;

    @FXML
    private JFXTextField ViewPatientRecordIDNum;

    @FXML
    private JFXTextField EditPatientRecordIDNum;

    @FXML
    private BorderPane EditPatientBorderPane;

    @FXML
    private JFXTextField AddPatientAllergies;

    @FXML
    private JFXButton AddPatientBtn;

    @FXML
    private JFXButton EditPatientUserName;

    @FXML
    private JFXButton ViewPatientUserName;

    @FXML
    private JFXButton DeletePatientUserName;

    @FXML
    private BorderPane ViewPatientBorderPane;


     @FXML
     void View_Patient(MouseEvent event) throws IOException
    {
        ValidationController validatePatientID = new ValidationController(RecepAddPatientStackPane,
                RecepAddPatientAnchorPane, 4);
        if(validatePatientID.ValidNotEmpty(ViewPatientRecordIDNum)) {
            if (validatePatientID.validatePatientID(ViewPatientRecordIDNum)) {
                PatientIDGlobal = ViewPatientRecordIDNum.getText().trim();
                Parent patientPane = FXMLLoader.load(getClass().getResource("/sample/view/RecepViewPatient.fxml"));
                ViewPatientBorderPane.setCenter(patientPane);
                clearFields();
            }
        }
    }


    @FXML
    void Edit_Patient(MouseEvent event) throws IOException {
        ValidationController validatePatientID = new ValidationController(RecepAddPatientStackPane,
                RecepAddPatientAnchorPane, 1);
        if(validatePatientID.ValidNotEmpty(EditPatientRecordIDNum)){
            if (validatePatientID.validateNIC(EditPatientRecordIDNum)) {
                PatientIDGlobal = EditPatientRecordIDNum.getText().trim();
                Parent appointmentPane = FXMLLoader.load(getClass()
                        .getResource("/sample/view/RecepEditPatient.fxml"));
                EditPatientBorderPane.setCenter(appointmentPane);
                clearFields();
            }
        }
    }

    @FXML
    void Add_Patient(MouseEvent event) {
        try{
            ValidationController validate = new ValidationController(RecepAddPatientStackPane, RecepAddPatientAnchorPane, 4);
            if(        !(AddPatientDOB.getValue() == null)
                    && !(AddPatientGender.getSelectionModel().isEmpty())
                    && !(AddPatientMaritalStatus.getSelectionModel().isEmpty())
                    && !(AddPatientBloodGroup.getSelectionModel().isEmpty())
                    && validate.ValidNotEmpty(AddPatientFirstName)
                    && validate.ValidNotEmpty(AddPatientLastName)
                    && validate.ValidNotEmpty(AddPatientIDCardNumber)
                    && validate.ValidNotEmpty(AddPatientPhoneNumber)
                    && validate.ValidNotEmpty(AddPatientAddressLine1)
                    && validate.ValidNotEmpty(AddPatientAddressLine2)
                    && validate.ValidNotEmpty(AddPatientCity)
                    && validate.ValidNotEmpty(AddPatientAllergies)
            ) {
                if (validate.validateNIC(AddPatientIDCardNumber)
                        && validate.validatePhone(AddPatientPhoneNumber)

                ) {

                    RecepPatient newRecepPatient = new RecepPatient();

                    newRecepPatient.setFirstName(AddPatientFirstName.getText().trim());
                    newRecepPatient.setLastName(AddPatientLastName.getText().trim());
                    newRecepPatient.setIdCardNo(AddPatientIDCardNumber.getText().trim());
                    newRecepPatient.setGender(AddPatientGender.getValue());
                    newRecepPatient.setPhoneNumber(AddPatientPhoneNumber.getText().trim());
                    newRecepPatient.setdOB(AddPatientDOB.getValue());
                    newRecepPatient.setAddressLine1(AddPatientAddressLine1.getText().trim());
                    newRecepPatient.setAddressLine2(AddPatientAddressLine2.getText().trim());
                    newRecepPatient.setCity(AddPatientCity.getText().trim());
                    newRecepPatient.setMaritalStatus(AddPatientMaritalStatus.getValue());
                    newRecepPatient.setBloodGroup(AddPatientBloodGroup.getValue());
                    newRecepPatient.setAllergies(AddPatientAllergies.getText().trim());

                    RecepAddPatient.writeToFile(newRecepPatient);
                    validate.successfulUserCreation("Patient Record Successfully Created");
                    clearFields();

            }
            } else {
                validate.detailedMsg("Invalid Input Data", "Some fields are empty." +
                        " Enter data and try again");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void clearFields() {
        AddPatientFirstName.clear();
        AddPatientLastName.clear();
        AddPatientIDCardNumber.clear();
        AddPatientGender.getSelectionModel().clearSelection();
        AddPatientPhoneNumber.clear();
        AddPatientDOB.getEditor().clear();
        AddPatientAddressLine1.clear();
        AddPatientAddressLine2.clear();
        AddPatientCity.clear();
        AddPatientAllergies.clear();
        EditPatientRecordIDNum.clear();
        ViewPatientRecordIDNum.clear();

    }


    @FXML
    void initialize() {
        // combo-box items for gender at create add patient
        AddPatientGender.getItems().add("Male");
        AddPatientGender.getItems().add("Female");

        // combo-box items for marital status at create add patient
        AddPatientMaritalStatus.getItems().add("Unmarried");
        AddPatientMaritalStatus.getItems().add("Married");
        AddPatientMaritalStatus.getItems().add("Divorced");
        AddPatientMaritalStatus.getItems().add("Widowed");
        AddPatientMaritalStatus.getItems().add("Legally Separated");


        // combo-box items for blood-group status at create user account
        AddPatientBloodGroup.getItems().add("A+");
        AddPatientBloodGroup.getItems().add("A-");
        AddPatientBloodGroup.getItems().add("B+");
        AddPatientBloodGroup.getItems().add("B-");
        AddPatientBloodGroup.getItems().add("O+");
        AddPatientBloodGroup.getItems().add("O-");
        AddPatientBloodGroup.getItems().add("AB+");
        AddPatientBloodGroup.getItems().add("AB-");


    }
}
