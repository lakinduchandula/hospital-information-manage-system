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
import sample.model.DispatchPostalMail;
import sample.model.PostalEditDelete;
import sample.model.ReceivedPostalMail;
import sample.model.ReceptAddPostalMail;

import java.io.IOException;

public class EditDispatchPostalMailController {
    @FXML
    private StackPane EditDispatchPMStackPane;

    @FXML
    private BorderPane EditDispatchPMBorderPane;

    @FXML
    private AnchorPane EditDispatchPMAnchorPane;

    @FXML
    private JFXTextField EditDispatchPMRefereneceNum;

    @FXML
    private JFXDatePicker EditDispatchPMDate;

    @FXML
    private JFXTextField EditDispatchPMFromName;

    @FXML
    private JFXTextField EditDispatchPMNote;

    @FXML
    private JFXTextField EditDispatchPMToName;

    @FXML
    private JFXTextField EditDispatchPMToAddress;

    @FXML
    private JFXButton EditDispatchPMSaveChangesBtn;

    @FXML
    void SaveChanges(MouseEvent event) {
        try{
            PostalEditDelete newPostalEditDelete = new PostalEditDelete(1);
            newPostalEditDelete.PostalMailDelete(ReceptDashPostalMailController.postalMailIDGlobal);
            ValidationController validate = new ValidationController(EditDispatchPMStackPane, EditDispatchPMAnchorPane, 1);
            {

                DispatchPostalMail editDispatchPostalMail = new DispatchPostalMail();

                editDispatchPostalMail.setReferenceNo(EditDispatchPMRefereneceNum.getText().trim());
                editDispatchPostalMail.setNote(EditDispatchPMNote.getText().trim());
                editDispatchPostalMail.setCurrentDate(EditDispatchPMDate.getValue());
                editDispatchPostalMail.setToAddress(EditDispatchPMToAddress.getText().trim());
                editDispatchPostalMail.setFromName(EditDispatchPMFromName.getText().trim());
                editDispatchPostalMail.setToName(EditDispatchPMToName.getText().trim());

                ReceptAddPostalMail.writeToFile(editDispatchPostalMail, 1);
                validate.successfulUserCreation("Dispatch PostalMail Record Successfully Updated");
                afterCreation();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void afterCreation() throws IOException {
        Parent white = FXMLLoader.load(getClass()
                .getResource("/sample/view/WhiteBlank.fxml"));
        EditDispatchPMBorderPane.setCenter(white);
    }
    @FXML
    void initialize() {


        PostalEditDelete newEditPostal = new  PostalEditDelete(1);
        newEditPostal.PostalMailEdit(ReceptDashPostalMailController.postalMailIDGlobal);
        String[] PatientDetails = newEditPostal.getPostalDetailsArray();


        EditDispatchPMRefereneceNum.setText(PatientDetails[0]);
        // EditDispatchPMDate.setValue(PatientDetails[1]);
        EditDispatchPMNote.setText(PatientDetails[2]);
        EditDispatchPMToAddress.setText(PatientDetails[3]);
        EditDispatchPMFromName.setText(PatientDetails[4]);
        EditDispatchPMToName.setText(PatientDetails[5]);

    }


}

