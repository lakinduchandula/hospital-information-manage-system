package sample.controller;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import sample.model.Appointment;
import sample.model.GetSetTextArea;
import sample.model.Visitor;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class RecepViewVisitorController {
    @FXML
    private StackPane RecepViewVisitorStackPane;

    @FXML
    private BorderPane RecepViewVisitorBorderPane;

    @FXML
    private AnchorPane RecepViewVisitorAnchorPane;

    @FXML
    private Label ViewVisitorFirstName;

    @FXML
    private Label ViewVisitorLastName;

    @FXML
    private Label ViewVisitorPurpose;

    @FXML
    private Label ViewVisitorNote;

    @FXML
    private Label ViewVisitorNIC;

    @FXML
    private Label ViewVisitorAdress;

    @FXML
    private Label ViewVisitorPhoneNumber;

    @FXML
    private Label ViewVisitorInTime;

    @FXML
    private Label ViewVisitorOutTime;

    @FXML
    private Label ViewVisitorDate;

    @FXML
    private JFXButton DeleteVisitor;

    @FXML
    void DeleteVisitor(MouseEvent event) throws IOException { Visitor deleteVisitor = new Visitor();
        ValidationController deleteValidate = new ValidationController(RecepViewVisitorStackPane, RecepViewVisitorAnchorPane, 1);
        deleteValidate.detailedMsg("Visitor Record Delete", "Visitor Record was Successfully Deleted");
        deleteVisitor.deleteVisitor(ReceptDashVisitorRecordsController.VisitorIDGlobal);
        afterCreation();
    }

    public void afterCreation() throws IOException {
        Parent white = FXMLLoader.load(getClass()
                .getResource("/sample/view/WhiteBlank.fxml"));
        RecepViewVisitorBorderPane.setCenter(white);
    }
    @FXML
    void initialize() {
        Visitor viewVisitor = new Visitor();
        viewVisitor.getVisitorDetailsArray(ReceptDashVisitorRecordsController.VisitorIDGlobal);
        String[] visitorDetails = viewVisitor.getVisitorDetails();

        ViewVisitorFirstName.setText(visitorDetails[1]);
        ViewVisitorLastName.setText(visitorDetails[2]);
        ViewVisitorNIC.setText(visitorDetails[0]);
        ViewVisitorAdress.setText(visitorDetails[4]);
        ViewVisitorPurpose.setText(visitorDetails[3]);
        ViewVisitorPhoneNumber.setText(visitorDetails[5]);
        ViewVisitorNote.setText(visitorDetails[9]);
        ViewVisitorInTime.setText(visitorDetails[7]);
        ViewVisitorOutTime.setText(visitorDetails[8]);
        ViewVisitorDate.setText(visitorDetails[6]);
    }
}
