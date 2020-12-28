package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

import sample.model.*;
import java.io.IOException;

public class ReceptDashVisitorRecordsController {

    public static String VisitorIDGlobal;

    @FXML
    private StackPane VisitorRecordsStackPane;

    @FXML
    private AnchorPane VisitorRecordsAnchorPane;

    @FXML
    private JFXTextField AddVisitorIDNum;

    @FXML
    private JFXTextField AddVisitorLastName;

    @FXML
    private JFXTextField AddVisitorAddress;

    @FXML
    private JFXTextField AddVisitorFirstName;

    @FXML
    private JFXTextField AddVisitorPurpose;

    @FXML
    private JFXDatePicker AddVisitorDate;

    @FXML
    private JFXTextField AddVisitorNote;

    @FXML
    private JFXTextField AddVisitorPhoneNum;

    @FXML
    private JFXTimePicker AddVisitorTimeIn;

    @FXML
    private JFXTimePicker AddVisitorTimeOut;

    @FXML
    private JFXButton AddVisitorDocAttachBtn;

    @FXML
    private JFXTextField ComplaintActionTaken;

    @FXML
    private JFXButton AddVisitorBtn;

    @FXML
    private BorderPane EditVisitorBorderPane;

    @FXML
    private JFXTextField EditVisitorIDNum;

    @FXML
    private JFXButton EditVisitorBtn;

    @FXML
    private BorderPane ViewVisitorBorderPane;


    @FXML
    private JFXButton ViewVisitorBtn;

    @FXML
    private JFXTextField ViewVisitorIDNum;

    @FXML
    private JFXTextField DeleteVisitorIDNum;

    @FXML
    private JFXButton DeleteVisitorBtn;

     @FXML
    void Add_Visitor(MouseEvent event) {
        try{
            ValidationController validate = new ValidationController(VisitorRecordsStackPane, VisitorRecordsAnchorPane, 1);
            if (               validate.validateNIC(AddVisitorIDNum)
                    && validate.validatePhone(AddVisitorPhoneNum)



            ) {
                Visitor newVisitor = new Visitor();

                newVisitor.setFirstName(AddVisitorFirstName.getText().trim());
                newVisitor.setLastName(AddVisitorLastName.getText().trim());
                newVisitor.setAddress(AddVisitorAddress.getText().trim());
                newVisitor.setIdCardNo(AddVisitorIDNum.getText().trim());
                newVisitor.setPhoneNumber(AddVisitorPhoneNum.getText().trim());
                newVisitor.setDate(AddVisitorDate.getValue());
                newVisitor.setNote(AddVisitorNote.getText().trim());
                newVisitor.setInTime(AddVisitorTimeIn.getValue());
                newVisitor.setOutTime(AddVisitorTimeOut.getValue());


                ReceptAddVisitor.writeToFile(newVisitor);
                validate.successfulUserCreation("Visitor Account Successfully Created");
                clearFields();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    private void clearFields() {


        AddVisitorFirstName.clear();
        AddVisitorLastName.clear();
        AddVisitorAddress.clear();
        AddVisitorIDNum.clear();
        AddVisitorPhoneNum.clear();
        AddVisitorDate.getEditor().clear();
        AddVisitorPurpose.clear();
        AddVisitorNote.clear();
        AddVisitorTimeIn.getEditor().clear();
        AddVisitorTimeOut.getEditor().clear();
        ViewVisitorIDNum.clear();


    }


    @FXML
    void Delete_Visitor(MouseEvent event) {

    }

    @FXML
    void Edit_Visitor(MouseEvent event)  throws IOException {
        ValidationController visitorValidation = new ValidationController(VisitorRecordsStackPane,
                VisitorRecordsAnchorPane, 1);
        if(visitorValidation.validateVisitorID(EditVisitorIDNum)) {
            VisitorIDGlobal = EditVisitorIDNum.getText().trim();
            Parent visitorPane = FXMLLoader.load(getClass().getResource("/sample/view/RecepEditVisitor.fxml"));
            EditVisitorBorderPane.setCenter(visitorPane);
            clearFields();
        }

    }

    @FXML
    void View_Visitor(MouseEvent event) throws IOException {
        ValidationController visitorValidation = new ValidationController(VisitorRecordsStackPane,
                VisitorRecordsAnchorPane, 1);

        if(visitorValidation.validateVisitorID(EditVisitorIDNum)){
            VisitorIDGlobal = ViewVisitorIDNum.getText().trim();
            Parent visitorPane = FXMLLoader.load(getClass().getResource("/sample/view/RecepViewVisitor.fxml"));
            ViewVisitorBorderPane.setCenter(visitorPane);
            clearFields();
        }
    }

}
