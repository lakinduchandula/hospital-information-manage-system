package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Collections;
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
    public void add_item_MOSpecial(MouseEvent event) {
        ValidationController ReferenceValidate = new ValidationController(ReferenceRecStackPane, ReferenceRecAnch, 1);
        AdReference.addItem(ReferenceAddMOItem);
        ReferenceValidate.detailedMsg("Item Add", "New specialized area added for Medical Officer ");
        ReferenceAddMOItem.clear();
    }

    @FXML
    void initialize() {


    }
}
