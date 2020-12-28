package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
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
    private JFXTextField ReferenceEnterItem;

    @FXML
    private JFXButton CompDelete;

    @FXML
    private JFXButton ReferenceAddCD;

    @FXML
    private JFXComboBox<String> ReferenceCompleteDep;


    @FXML
    private JFXComboBox<String> ReferenceMOSpecial;

    @FXML
    public void rm_item_MOSpecial(MouseEvent event) {
        ValidationController ReferenceValidate = new ValidationController(ReferenceRecStackPane, ReferenceRecAnch,
                1);

        if(ReferenceValidate.ValidNotEmpty(ReferenceAddMOItem)){
            if (ReferenceValidate.ValidateRefIsNot(ReferenceAddMOItem, 0)) {
                AdReference.removeItem(ReferenceAddMOItem, 0);
                ReferenceValidate.detailedMsg("Item Remove", "That Area was Removed from database");
                AdReference.readItem(ReferenceMOSpecial, 0);
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
                AdReference.addItem(ReferenceAddMOItem, 0);
                ReferenceValidate.detailedMsg("Item Add",
                        "New specialized area added for Medical Officer ");
                AdReference.readItem(ReferenceMOSpecial, 0);
            }
            ReferenceAddMOItem.clear();
        }

    }

    @FXML
    void remove_com_dep(MouseEvent event) {
        ValidationController ReferenceDep = new ValidationController(ReferenceRecStackPane, ReferenceRecAnch,
                1);
        if(ReferenceDep.ValidNotEmpty(ReferenceEnterItem)){
            if(ReferenceDep.ValidateRefIsNot(ReferenceEnterItem, 1)){
                AdReference.removeItem(ReferenceEnterItem, 1);
                ReferenceDep.detailedMsg("Item Removed",
                        "That item was removed from the Reference database");
                AdReference.readItem(ReferenceCompleteDep, 1);
            }
        }
    }

    @FXML
    void add_comp_dep(MouseEvent event) {
        ValidationController ReferenceValidate = new ValidationController(ReferenceRecStackPane, ReferenceRecAnch,
                1);
        if(ReferenceValidate.ValidNotEmpty(ReferenceEnterItem)){
            if(ReferenceValidate.ValidateRefAlready(ReferenceEnterItem, 1)){
                AdReference.addItem(ReferenceEnterItem, 1);
                ReferenceValidate.detailedMsg("Item Add",
                        "New Complaint Department added for Complaint database");
                ReferenceCompleteDep.getItems().clear();
                AdReference.readItem(ReferenceCompleteDep, 1);
            }
            ReferenceEnterItem.clear();
        }
    }

    @FXML
    void initialize() {
        // add items to the medical officer specialist areas
        AdReference.readItem(ReferenceMOSpecial, 0);

        // add items to the complaint department
        AdReference.readItem(ReferenceCompleteDep, 1);
    }
}
