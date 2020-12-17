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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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

    public boolean validateSameCredentials(TextField username, TextField idNo, TextField tel, TextField staffID){
        final String[] fileLocation = {"src/sample/data/UserAdmin.txt", "src/sample/data/UserReceptionist.txt",
                "src/sample/data/UserPatient.txt", "src/sample/data/UserMedicalOfficer.txt"
        };

        for (int i = 0; i < 4; i++) {
            File file = new File(fileLocation[i]);
            try (FileReader fileReader = new FileReader(file)) {
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String line = null;

                while ((line = bufferedReader.readLine()) != null) {
                    String[] userCredentials = line.split("~");

                    if (sameCredentialValidation(userCredentials[0], username)) {
                        JFXButton button = new JFXButton("OK");
                        loginUserException(getStackPane(), getNode(), Collections.singletonList(button), 1,
                                "Invalid Input Data",
                                "That username is taken. Try another" );
                        return false;
                    }
                    if (sameCredentialValidation(userCredentials[4], idNo)) {
                        JFXButton button = new JFXButton("OK");
                        loginUserException(getStackPane(), getNode(), Collections.singletonList(button), 1,
                                "Invalid Input Data",
                                "That NIC is taken by another user." );
                        return false;
                    }
                    if (sameCredentialValidation(userCredentials[5], tel)) {
                        JFXButton button = new JFXButton("OK");
                        loginUserException(getStackPane(), getNode(), Collections.singletonList(button), 1,
                                "Invalid Input Data",
                                "That Phone Number is taken by another user." );
                        return false;
                    }
                    if (sameCredentialValidation(userCredentials[13], staffID)) {
                        JFXButton button = new JFXButton("OK");
                        loginUserException(getStackPane(), getNode(), Collections.singletonList(button), 1,
                                "Invalid Input Data",
                                "That Staff ID is taken by another user." );
                        return false;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public boolean sameCredentialValidation(String userCredentials1, TextField userCredentials2){
        return userCredentials1.equals(userCredentials2.getText());
    }

    public void successfulUserCreation(String userAccountType){
        JFXButton button = new JFXButton("OK");
        loginUserException(getStackPane(), getNode(), Collections.singletonList(button), 1,
                "User Creation",
                userAccountType);
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
