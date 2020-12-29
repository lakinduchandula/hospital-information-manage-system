package sample.controller;

import com.jfoenix.controls.JFXButton;
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

public class EditReceivedPostalMailController {
    @FXML
    private StackPane ReceivedPMStackPane;

    @FXML
    private BorderPane ReceivedPMBorderPane;

    @FXML
    private AnchorPane ReceivedPMAnchorPane;

    @FXML
    private JFXTextField EditReceivedPMRefereneceNum;

    @FXML
    private JFXTextField EditReceivedPMNote;

    @FXML
    private JFXTextField EditReceivedPMFromName;

    @FXML
    private JFXDatePicker EditReceivedPMDate;

    @FXML
    private JFXTextField EditReceivedPMFromAddress;

    @FXML
    private JFXTextField EditReceivedPMToName;

    @FXML
    private JFXButton EditReceivedPMSaveChangesBtn;

    @FXML
    void SaveChanges(MouseEvent event) {
        try{
        PostalEditDelete newPostalEditDelete = new PostalEditDelete(0);
            newPostalEditDelete.PostalMailDelete(ReceptDashPostalMailController.postalMailIDGlobal);
        ValidationController validate = new ValidationController(ReceivedPMStackPane, ReceivedPMAnchorPane, 1);
        {

            ReceivedPostalMail editReceivedPostalMail = new ReceivedPostalMail();

            editReceivedPostalMail.setReferenceNo(EditReceivedPMRefereneceNum.getText().trim());
            editReceivedPostalMail.setNote(EditReceivedPMNote.getText().trim());
            editReceivedPostalMail.setCurrentDate(EditReceivedPMDate.getValue());
            editReceivedPostalMail.setFromAddress(EditReceivedPMFromAddress.getText().trim());
            editReceivedPostalMail.setFromName(EditReceivedPMFromName.getText().trim());
            editReceivedPostalMail.setToName(EditReceivedPMToName.getText().trim());

            ReceptAddPostalMail.writeToFile(editReceivedPostalMail, 0);
            validate.successfulUserCreation("Received PostalMail Record Successfully Updated");
            afterCreation();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    }

    public void afterCreation() throws IOException {
        Parent white = FXMLLoader.load(getClass()
                .getResource("/sample/view/WhiteBlank.fxml"));
        ReceivedPMBorderPane.setCenter(white);
    }
    @FXML
    void initialize() {


        PostalEditDelete newEditPostal = new  PostalEditDelete(0);
        newEditPostal.PostalMailEdit(ReceptDashPostalMailController.postalMailIDGlobal);
        String[] PatientDetails = newEditPostal.getPostalDetailsArray();


        EditReceivedPMRefereneceNum.setText(PatientDetails[0]);
      //  EditReceivedPMDate.setValue(PatientDetails[1]);
        EditReceivedPMNote.setText(PatientDetails[2]);
        EditReceivedPMFromAddress.setText(PatientDetails[3]);
        EditReceivedPMFromName.setText(PatientDetails[4]);
        EditReceivedPMToName.setText(PatientDetails[5]);

    }




}
