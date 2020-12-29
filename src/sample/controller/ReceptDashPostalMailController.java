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
import java.net.URL;
import java.util.ResourceBundle;

public class ReceptDashPostalMailController {

    public static String postalMailIDGlobal;

    @FXML
    private JFXTextField AddPostalMailRefereneceNum;

    @FXML
    private JFXDatePicker AddPostalMailDate;

    @FXML
    private JFXTextField AddPostalMailNote;

    @FXML
    private JFXButton AddPostalMailAttachBtn;

    @FXML
    private JFXTextField ReceivedPMFromName;

    @FXML
    private JFXTextField ReceivedPMToName;

    @FXML
    private JFXTextField ReceivedPMFromAddress;

    @FXML
    private JFXButton ReceivedPMAddBtn;

    @FXML
    private JFXTextField DispatchPMToName;

    @FXML
    private JFXTextField DispatchPMFromName;

    @FXML
    private JFXTextField DispatchPMToAddress;

    @FXML
    private JFXButton DispatchPMAddBtn;

    @FXML
    private StackPane PostalMailStackPane;

    @FXML
    private AnchorPane PostalMailAnchorPane;

    @FXML
    private JFXTextField EditPostalMailRefereneceNum;

    @FXML
    private JFXButton EditPostalMailBtn;

    @FXML
    private BorderPane ViewPostalMailBorderPane;

    @FXML
    private BorderPane EditPostalMailBorderPane;


    @FXML
    private JFXComboBox<String> EditPostalMailMode;

    @FXML
    private JFXTextField ViewPostalMailReferenceNum;

    @FXML
    private JFXButton ViewPostalMailBtn;

    @FXML
    private JFXComboBox<String> ViewPostalMailMode;


    @FXML
    void AddReceivedPostalMail(MouseEvent event) {
        try {
            ValidationController validate = new ValidationController(PostalMailStackPane, PostalMailAnchorPane, 4);

            if(
                    !(AddPostalMailDate.getValue() == null)
                            && validate.ValidNotEmpty(AddPostalMailRefereneceNum)
                            && validate.ValidNotEmpty(AddPostalMailNote)
                            && validate.ValidNotEmpty(ReceivedPMFromName)
                            && validate.ValidNotEmpty(ReceivedPMFromAddress)
                            && validate.ValidNotEmpty(ReceivedPMToName)

            )

            {
            ReceivedPostalMail newReceivedPostalMail = new ReceivedPostalMail();

            newReceivedPostalMail.setReferenceNo(AddPostalMailRefereneceNum.getText().trim());
            newReceivedPostalMail.setCurrentDate(AddPostalMailDate.getValue());
            newReceivedPostalMail.setNote(AddPostalMailNote.getText().trim());
            newReceivedPostalMail.setFromName(ReceivedPMFromName.getText().trim());
            newReceivedPostalMail.setFromAddress(ReceivedPMFromName.getText().trim());
            newReceivedPostalMail.setToName(ReceivedPMToName.getText().trim());


            ReceptAddPostalMail.writeToFile(newReceivedPostalMail, 0);
            validate.successfulUserCreation("ReceivedPostalMail  Successfully Created");
             clearFields();
            }
            else {
                validate.detailedMsg("Invalid Input Data", "Some fields are empty." +
                        " Enter data and try again");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void AddDispatchPostalMail(MouseEvent event) {
        try {
            ValidationController validate = new ValidationController(PostalMailStackPane, PostalMailAnchorPane, 4);


            if(
                   !(AddPostalMailDate.getValue() == null)
                    && validate.ValidNotEmpty(AddPostalMailRefereneceNum)
                    && validate.ValidNotEmpty(AddPostalMailNote)
                    && validate.ValidNotEmpty(DispatchPMToName)
                    && validate.ValidNotEmpty(DispatchPMToAddress)
                    && validate.ValidNotEmpty(DispatchPMFromName)

            )

            {
            DispatchPostalMail newDispatchPostalMail = new DispatchPostalMail();

            newDispatchPostalMail.setReferenceNo(AddPostalMailRefereneceNum.getText().trim());
            newDispatchPostalMail.setCurrentDate(AddPostalMailDate.getValue());
            newDispatchPostalMail.setNote(AddPostalMailNote.getText().trim());
            newDispatchPostalMail.setToName(DispatchPMToName.getText().trim());
            newDispatchPostalMail.setToName(DispatchPMToAddress.getText().trim());
            newDispatchPostalMail.setToName(DispatchPMFromName.getText().trim());


            ReceptAddPostalMail.writeToFile(newDispatchPostalMail, 1);
            validate.successfulUserCreation("DispatchPostalMail Successfully Created");
               clearFields();
            }
         else {
            validate.detailedMsg("Invalid Input Data", "Some fields are empty." +
                    " Enter data and try again");
        }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Edit_PostalMail(MouseEvent event) throws IOException {


        ValidationController validatePostalMail = new ValidationController(PostalMailStackPane, PostalMailAnchorPane, 4);
        if ( !( EditPostalMailMode.getSelectionModel().isEmpty()) ) {
            switch (EditPostalMailMode.getValue()) {
                case "ReceivedPostalMail": {
                    if (validatePostalMail.validatePostalID(EditPostalMailRefereneceNum, 0)) {
                        postalMailIDGlobal = EditPostalMailRefereneceNum.getText().trim();
                        Parent editUserAccount = FXMLLoader.load(getClass()
                                .getResource("/sample/view/EditReceivedPostalMail.fxml"));
                        //Parent editUserAccount = loader.load();
                        EditPostalMailBorderPane.setCenter(editUserAccount);
                        clearFields();
                    } else {
                        validatePostalMail.detailedMsg("User Not Found",
                                "Reference Number that you've entered is not in Receptionist Database");
                    }
                    break;
                }
                case "DispatchPostalMail": {
                    if (validatePostalMail.validatePostalID(EditPostalMailRefereneceNum, 1)) {
                        postalMailIDGlobal = EditPostalMailRefereneceNum.getText().trim();
                        Parent editUserAccount = FXMLLoader.load(getClass()
                                .getResource("/sample/view/EditDispatchPostalMail.fxml"));
                        EditPostalMailBorderPane.setCenter(editUserAccount);
                        clearFields();
                    } else {
                        validatePostalMail.detailedMsg("User Not Found",
                                "Reference Number that you've entered is not in Patient Database");
                    }
                    break;
                }

            }
        } else {
            validatePostalMail.detailedMsg("Input Data",
                    "Please Enter valid referenceNum and it's PostalMailType\n" +
                            "to view Postal Mail.");
        }

    }

    @FXML
    void View_PostalMail(MouseEvent event) throws IOException {
        ValidationController validatePostalMailDelete = new ValidationController(PostalMailStackPane, PostalMailAnchorPane, 4);
        if ( !( ViewPostalMailMode.getSelectionModel().isEmpty()) ) {
            switch ( ViewPostalMailMode.getValue()) {
                case "ReceivedPostalMail": {
                    if (validatePostalMailDelete.validatePostalID(ViewPostalMailReferenceNum, 0)) {
                        postalMailIDGlobal = ViewPostalMailReferenceNum.getText().trim();
                        Parent deleteUserAcc = FXMLLoader.load(getClass()
                                .getResource("/sample/view/ViewReceivedPostalMail.fxml"));
                        ViewPostalMailBorderPane.setCenter(deleteUserAcc);
                        clearFields();
                    } else {
                        validatePostalMailDelete.detailedMsg("PostalMail Not Found",
                                "Reference Number that you've entered is not in PostalMail Database");
                    }
                    break;
                }
                case "DispatchPostalMail": {
                    if (validatePostalMailDelete.validatePostalID(ViewPostalMailReferenceNum,1)) {
                        postalMailIDGlobal = ViewPostalMailReferenceNum.getText().trim();
                        Parent deleteUserAcc = FXMLLoader.load(getClass()
                                .getResource("/sample/view/ViewDispatchPostalMail.fxml"));
                        ViewPostalMailBorderPane.setCenter(deleteUserAcc);
                        clearFields();
                    } else {
                        validatePostalMailDelete.detailedMsg("PostalMail Not Found",
                                "Reference Number that you've entered is not in PostalMail Database");
                    }
                    break;
                }

            }
        } else {
            validatePostalMailDelete.detailedMsg("Input Data",
                    "Please Enter valid referenceNum and it's PostalMailType\n" +
                            "to view Postal Mail");
        }
    }
    @FXML
    void initialize() {

        // combo-box items for PostalMailType-edit
        EditPostalMailMode.getItems().add("Received PostalMail");
        EditPostalMailMode.getItems().add("Dispatch PostalMail");


        // combo-box items for PostalMailType-view
        ViewPostalMailMode.getItems().add("Received PostalMail");
        ViewPostalMailMode.getItems().add("Dispatch PostalMail");

        AddPostalMailDate.setValue(java.time.LocalDate.now());


    }

    public void clearFields() {
        AddPostalMailRefereneceNum.clear();
        AddPostalMailDate.getEditor().clear();
        AddPostalMailNote.clear();
        DispatchPMToName.clear();
        DispatchPMToAddress.clear();
        DispatchPMFromName.clear();
        ReceivedPMFromName.clear();
        ReceivedPMFromAddress.clear();
        ReceivedPMToName.clear();

    }
}
