package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import sample.model.AdReference;

public class AdDashReferenceRecordsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private StackPane ReferenceRecStackPane;

    @FXML
    private AnchorPane ReferenceRecAnch;

    @FXML
    private URL location;

    @FXML
    private JFXTextField ReferenceAddMOItem;

    @FXML
    private JFXButton ReferenceMOItemAdd;

    @FXML
    private JFXButton ReferenceMOItemDelete;

    @FXML
    public void rm_item_MOSpecial(MouseEvent event) {
        ValidationController ReferenceValidate = new ValidationController(ReferenceRecStackPane, ReferenceRecAnch,
                1);

        if(ReferenceValidate.ValidNotEmpty(ReferenceAddMOItem)){
            if (ReferenceValidate.ValidateRefIsNot(ReferenceAddMOItem, 0)) {
                AdReference.removeItem(ReferenceAddMOItem);
                ReferenceValidate.detailedMsg("Item Remove", "That Area was Removed from database");
            }
            ReferenceAddMOItem.clear();
        }

    }

    @FXML
    public void add_item_MOSpecial(MouseEvent event) {
        ValidationController ReferenceValidate = new ValidationController(ReferenceRecStackPane, ReferenceRecAnch,
                1);

        if(ReferenceValidate.ValidNotEmpty(ReferenceAddMOItem)){
            if (ReferenceValidate.ValidateRefAlready(ReferenceAddMOItem, 0)) {
                AdReference.addItem(ReferenceAddMOItem);
                ReferenceValidate.detailedMsg("Item Add", "New specialized area added for Medical Officer ");
            }
        }
        ReferenceAddMOItem.clear();
    }

    @FXML
    void initialize() {


    }
}
