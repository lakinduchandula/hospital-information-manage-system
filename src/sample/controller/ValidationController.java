package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.events.JFXDialogEvent;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.BoxBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import sample.model.MakeAlert;

import java.util.Collections;
import java.util.List;

public class ValidationController {
    private StackPane stackPane;
    private Node node;

    public ValidationController(){

    }

    public ValidationController(StackPane stackPane, Node node){
        this.stackPane = stackPane;
        this.node = node;
    }

    public StackPane getStackPane(){
        return stackPane;
    }

    public Node getNode(){
        return node;
    }

    public static boolean validateEmpty(TextField txt) {
        if (txt.getText().isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean validateNIC(TextField txt) {
        if (txt.getText().matches("^(\\d{9}|\\d{12})[VvXx]$")|| (txt.getText().isEmpty())) {
            return true;
        } else {
            JFXButton button = new JFXButton("OK");
            loginUserException(getStackPane(), getNode(), Collections.singletonList(button), 1, "Invalid Input Data",
                    "NIC that you've entered is not valid please try again." );
            return false;
        }
    }

    public boolean numbersOnly(TextField txt) {
        if (txt.getText().matches("[0-9]+")) {

            return true;
        } else {

            return false;
        }
    }

    public boolean validatePhone(TextField txt) {
        if (txt.getText().matches("^(\\d{10})")) {
            return true;
        } else {
            JFXButton button = new JFXButton("OK");
            loginUserException(getStackPane(), getNode(), Collections.singletonList(button), 1, "Invalid Input Data",
                    "Phone Number that you've entered is not valid please try again." );
            return false;
        }
    }

    public boolean validateDate(TextField txt) {
        if (txt.getText().matches("\\d{4}-\\d{2}-\\d{2}")) {
            return true;
        } else {

            return false;
        }
    }

    private void loginUserException(StackPane userStackPane, Node nodeToBeBlurred, List<JFXButton> controls,
                                    int StyleIndex, String dialogHeading, String dialogBody) {
        String[] styleClassDashboard = {"button-raised", "button-raised-admin-dash"};
        BoxBlur blurWindow = new BoxBlur(3,3,3);

        JFXDialogLayout dialogLayout = new JFXDialogLayout();

        JFXDialog dialog = new JFXDialog(userStackPane, dialogLayout, JFXDialog.DialogTransition.TOP);

        for (JFXButton controlButton : controls) {
            controlButton.getStyleClass().add(styleClassDashboard[StyleIndex]);
            controlButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent mouseEvent) -> dialog.close());
        }

        // label for dialog box heading and it's styles
        Label dialogBoxHeading = new Label(dialogHeading);
        dialogBoxHeading.setStyle("-fx-font-size: 14px");
        dialogLayout.setHeading(dialogBoxHeading);

        // Text for dialog box body and it's styles
        Text dialogBoxBody = new Text(dialogBody);
        dialogBoxBody.setStyle("-fx-font-size: 14px");
        dialogLayout.setBody(dialogBoxBody);

        dialogLayout.setActions(controls);
        dialog.show();

        // blur outer background
        dialog.setOnDialogClosed((JFXDialogEvent event) -> {
            nodeToBeBlurred.setEffect(null);
        });
        nodeToBeBlurred.setEffect(blurWindow);
    }
}
