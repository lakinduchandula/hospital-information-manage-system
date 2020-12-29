package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import sample.model.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class RecepEditVisitorController {

    private String[] visitorDetails;

    public void setVisitorDetails(String[] visitorDetails) {
        this.visitorDetails = visitorDetails;
    }

    public String[] getVisitorDetails() {
        return visitorDetails;
    }

    @FXML
    private StackPane RecepEditVisitorAnchorPane;

    @FXML
    private BorderPane RecepEditVisitorBorderPane;

    @FXML
    private JFXTextField EditVisitorFirstName;

    @FXML
    private JFXTextField EditVisitorLastName;

    @FXML
    private JFXTextField EditVisitorPurpose;

    @FXML
    private JFXDatePicker EditVisitorDate;

    @FXML
    private JFXTextField EditVisitorNote;

    @FXML
    private JFXTextField EditVisitorIDNum;

    @FXML
    private JFXTextField EditVisitorAddress;

    @FXML
    private JFXTextField EditVisitorPhoneNum;

    @FXML
    private JFXTimePicker EditVisitorTimeIn;

    @FXML
    private JFXTimePicker EditVisitorTimeOut;

    @FXML
    private JFXButton EditVisitorSaveChangeBtn;

    @FXML
    void SaveChanges(MouseEvent event) throws IOException {

        try{
        ValidationController validate = new ValidationController(RecepEditVisitorAnchorPane, RecepEditVisitorBorderPane,
                4);
            if(        validate.validatePhone(EditVisitorPhoneNum)
                    && validate.validateNIC(EditVisitorIDNum))
            {

            Visitor editVisitor = new Visitor();
            editVisitor.getVisitorDetailsArray(ReceptDashVisitorRecordsController.VisitorIDGlobal);


            editVisitor.setFirstName(EditVisitorFirstName.getText().trim());
            editVisitor.setLastName(EditVisitorLastName.getText().trim());
            editVisitor.setIdCardNo(EditVisitorIDNum.getText().trim());
            editVisitor.setAddress(EditVisitorAddress.getText().trim());
            editVisitor.setPurpose(EditVisitorPurpose.getText().trim());
            editVisitor.setPhoneNumber(EditVisitorPhoneNum.getText().trim());
            editVisitor.setNote(EditVisitorNote.getText().trim());
            editVisitor.setDate(LocalDate.parse(getVisitorDetails()[6]));
            editVisitor.setInTime(LocalTime.parse(getVisitorDetails()[7]));
            editVisitor.setOutTime(LocalTime.parse(getVisitorDetails()[8]));


            ReceptAddVisitor.writeToFile(editVisitor);
            validate.successfulUserCreation("Visitor Record Successfully Updated");
            clearFields();
            afterCreation();
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void afterCreation() throws IOException {
        Parent white = FXMLLoader.load(getClass()
                .getResource("/sample/view/WhiteBlank.fxml"));
        RecepEditVisitorBorderPane.setCenter(white);
    }
    @FXML
    void initialize() {


        Visitor editVisitor = new Visitor();
        editVisitor.getVisitorDetailsArray(ReceptDashVisitorRecordsController.VisitorIDGlobal);
        String[] visitorDetails = editVisitor.getVisitorDetails();
        setVisitorDetails(visitorDetails);

        // set values to text fields
        EditVisitorFirstName.setText(visitorDetails[1]);
        EditVisitorLastName.setText(visitorDetails[2]);
        EditVisitorIDNum.setText(visitorDetails[0]);
        EditVisitorAddress.setText(visitorDetails[4]);
        EditVisitorPurpose.setText(visitorDetails[3]);
        EditVisitorPhoneNum.setText(visitorDetails[5]);
        EditVisitorNote.setText(visitorDetails[9]);
        EditVisitorTimeIn.setValue(LocalTime.parse(visitorDetails[7]));
        EditVisitorTimeOut.setValue(LocalTime.parse(visitorDetails[8]));
        EditVisitorDate.setValue(LocalDate.parse(visitorDetails[6]));

    }
    public void clearFields() {
        EditVisitorFirstName.clear();
        EditVisitorLastName.clear();
        EditVisitorIDNum.clear();
        EditVisitorAddress.clear();
        EditVisitorPurpose.clear();
        EditVisitorPhoneNum.clear();
        EditVisitorNote.clear();
        EditVisitorTimeIn.getEditor().clear();
        EditVisitorTimeOut.getEditor().clear();
        EditVisitorDate.getEditor().clear();
        EditVisitorIDNum.clear();
    }
    }

