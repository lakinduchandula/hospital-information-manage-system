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

import java.io.IOException;

public class ViewDispatchPostalMailController {

    @FXML
    private Label DispatchPMRefNo;

    @FXML
    private Label DispatchPMNote;

    @FXML
    private Label DispatchPMFromName;

    @FXML
    private Label DispatchPMDate;

    @FXML
    private Label DispatchPMToAddress;

    @FXML
    private Label DispatchPMToName;

    @FXML
    private JFXButton DispatchPostalBtn;

    @FXML
    private StackPane DispatchPMStackPane;

    @FXML
    private BorderPane DispatchPMBorderPane;

    @FXML
    private AnchorPane DispatchPMAnchorPane;

    @FXML
    void DeleteDispatchPostalMail(MouseEvent event) throws IOException {
        PostalEditDelete newDeletePostalMail = new PostalEditDelete(1);
        ValidationController deleteValidate = new ValidationController(DispatchPMStackPane,DispatchPMAnchorPane, 1);
        deleteValidate.detailedMsg("Account Delete", "Dispatch PostalMail was Successfully Deleted");
        newDeletePostalMail.PostalMailDelete(ReceptDashPostalMailController.postalMailIDGlobal);
        afterCreation();
    }
    public void afterCreation() throws IOException {
        Parent white = FXMLLoader.load(getClass()
                .getResource("/sample/view/WhiteBlank.fxml"));
        DispatchPMBorderPane.setCenter(white);

    }
    @FXML
    void initialize() {
        PostalEditDelete newViewPostalMail = new PostalEditDelete(1);
        newViewPostalMail.PostalMailEdit(ReceptDashPostalMailController.postalMailIDGlobal);
        System.out.println(ReceptDashPostalMailController.postalMailIDGlobal);
        String[] PostalMailDetails = newViewPostalMail.getPostalDetailsArray();
        DispatchPMRefNo.setText(PostalMailDetails[0]);
        DispatchPMDate.setText(PostalMailDetails[1]);
        DispatchPMNote.setText(PostalMailDetails[2]);
        DispatchPMToAddress.setText(PostalMailDetails[3]);
        DispatchPMFromName.setText(PostalMailDetails[4]);
        DispatchPMToName.setText(PostalMailDetails[5]);

    }
}
