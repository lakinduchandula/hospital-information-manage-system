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
import sample.model.PostalEditDelete;
import sample.model.UserEditDelete;

import java.io.IOException;

public class ViewReceivedPostalMailController {
    @FXML
    private Label ReceivedPMToName;

    @FXML
    private Label ReceivedPMRefNo;

    @FXML
    private Label ReceivedPMNote;

    @FXML
    private Label ReceivedPMFromName;

    @FXML
    private Label ReceivedPMDate;


    @FXML
    private StackPane ViewPostalMailStackPane;

    @FXML
    private AnchorPane ViewPostalMailAnchorPane;

    @FXML
    private BorderPane ViewPostalMailBorderPane;

    @FXML
    private Label ReceivedPMFromAddress;

    @FXML
    private JFXButton ReceivedPMDeleteBtn;


    @FXML
    void DeleteReceivedPostalMail(MouseEvent event)throws IOException {
        PostalEditDelete newDeletePostalMail = new PostalEditDelete(0);
        ValidationController deleteValidate = new ValidationController(ViewPostalMailStackPane,ViewPostalMailAnchorPane, 1);
        deleteValidate.detailedMsg("Account Delete", "Received PostalMail was Successfully Deleted");
        newDeletePostalMail.PostalMailDelete(ReceptDashPostalMailController.postalMailIDGlobal);
        afterCreation();
    }

    public void afterCreation() throws IOException {
        Parent white = FXMLLoader.load(getClass()
                .getResource("/sample/view/WhiteBlank.fxml"));
        ViewPostalMailBorderPane.setCenter(white);

    }

    @FXML
    void initialize() {
        PostalEditDelete newViewPostalMail = new PostalEditDelete(0);
        newViewPostalMail.PostalMailEdit(ReceptDashPostalMailController.postalMailIDGlobal);
        String[] PostalMailDetails = newViewPostalMail.getPostalDetailsArray();
        ReceivedPMRefNo.setText(PostalMailDetails[0]);
        ReceivedPMDate.setText(PostalMailDetails[1]);
        ReceivedPMNote.setText(PostalMailDetails[2]);
        ReceivedPMFromAddress.setText(PostalMailDetails[3]);
        ReceivedPMFromName.setText(PostalMailDetails[4]);
        ReceivedPMToName.setText(PostalMailDetails[5]);

    }
    }

