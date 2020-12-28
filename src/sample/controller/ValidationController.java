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
import sample.model.UserEditDelete;

import java.io.*;
import java.util.Collections;
import java.util.List;

public class ValidationController {
    private StackPane stackPane;
    private Node node;
    private int styleIndex;


    public ValidationController(StackPane stackPane, Node node, int styleIndex){
        this.stackPane = stackPane;
        this.node = node;
        this.styleIndex = styleIndex;
    }

    public int getStyleIndex(){ return styleIndex; }

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

    public boolean ValidateRefAlready(TextField txt, int LocationIndex){
        if(ValidateReference(txt, LocationIndex)){
            JFXButton button = new JFXButton("OK");
            loginUserException(getStackPane(), getNode(), Collections.singletonList(button), getStyleIndex(),
                    "Invalid Input Data",
                    "That Reference is already in Reference database. Try another." );
            return false;
        }
        return true;
    }

    public boolean ValidateRefIsNot(TextField txt, int LocationIndex){
        if(ValidateReference(txt, LocationIndex)){
            return true;
        }
        JFXButton button = new JFXButton("OK");
        loginUserException(getStackPane(), getNode(), Collections.singletonList(button), getStyleIndex(),
                "Invalid Input Data",
                "That Reference is not in Reference database. Try with exiting one." );
        return false;
    }



    public boolean ValidateReference(TextField txt, int LocationIndex){
        String[] fileLocation = {"src/sample/data/MOSpecialArea.txt", "src/sample/data/ComplaintDepartment.txt"};
        File file = new File(fileLocation[LocationIndex]);
        try(FileReader fileReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null ;

            while((line = bufferedReader.readLine()) != null) {
                String[] item = line.split("~");
                if(sameCredentialValidation(item[0], txt)){
                    return true;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean ValidNotEmpty(TextField txt){
        if (txt.getText().isEmpty()) {
            JFXButton button = new JFXButton("OK");
            loginUserException(getStackPane(), getNode(), Collections.singletonList(button), getStyleIndex(),
                    "Invalid Input Data",
                    "The Field is empty. Enter valid data and try again." );
            return false;
        }
        return true;
    }

    public boolean validEmail(TextField txt) {
        if(txt.getText().matches("^(.+)@(.+)$")
                || (txt.getText().isEmpty())) {
            return true;
        } else {
            JFXButton button = new JFXButton("OK");
            loginUserException(getStackPane(), getNode(), Collections.singletonList(button), getStyleIndex(),
                    "Invalid Input Data",
                    "Email that you've entered is not valid please try again." );
            return false;
        }
    }

    public boolean validateNIC(TextField txt) {
        if (txt.getText().matches("^(\\d{9}|\\d{12})[VvXx]$")|| (txt.getText().isEmpty())) {
            return true;
        } else {
            JFXButton button = new JFXButton("OK");
            loginUserException(getStackPane(), getNode(), Collections.singletonList(button), getStyleIndex(),
                    "Invalid Input Data",
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
            loginUserException(getStackPane(), getNode(), Collections.singletonList(button), getStyleIndex(),
                    "Invalid Input Data",
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

    public boolean sameIDNo(TextField txt) {
        if(validateSameCredentials(txt, 4, 3)){
            return true;
        } else {
            JFXButton button = new JFXButton("OK");
            loginUserException(getStackPane(), getNode(), Collections.singletonList(button), getStyleIndex(),
                    "Invalid Input Data",
                    "That NIC is taken by another user." );
            return false;
        }
    }

    public boolean samePhoneNumber(TextField txt) {
        if(validateSameCredentials(txt, 5, 3)){
            return true;
        } else {
            JFXButton button = new JFXButton("OK");
            loginUserException(getStackPane(), getNode(), Collections.singletonList(button), getStyleIndex(),
                    "Invalid Input Data",
                    "That Phone Number is taken by another user." );
            return false;
        }
    }

    public boolean sameStaffID(TextField txt) {
        if(validateSameCredentials(txt, 13, 2)){
            return true;
        } else {
            JFXButton button = new JFXButton("OK");
            loginUserException(getStackPane(), getNode(), Collections.singletonList(button), getStyleIndex(),
                    "Invalid Input Data",
                    "That Staff ID is taken by another user." );
            return false;
        }
    }

    public boolean sameStaffEmail(TextField txt) {
        if(validateSameCredentials(txt, 14, 2)){
            return true;
        } else {
            JFXButton button = new JFXButton("OK");
            loginUserException(getStackPane(), getNode(), Collections.singletonList(button), getStyleIndex(),
                    "Invalid Input Data",
                    "That Staff Email Address is taken by another user." );
            return false;
        }
    }

    public boolean validateUsername(TextField txt){
        if(validateSameCredentials(txt, 0, 3)){
            return true;
        } else {
            JFXButton button = new JFXButton("OK");
            loginUserException(getStackPane(), getNode(), Collections.singletonList(button), getStyleIndex(),
                    "Invalid Input Data",
                    "That username is taken. Try another" );
            return false;
        }
    }

    public boolean validateEditUsername(TextField txt, int usermode) {
        if(validateSpecificUsername(txt, usermode)){
            return false;
        } else {
            return true;
        }
    }

//    public boolean validateAppointmentID(TextField appointmentID){
//        File file = new File("src/sample/data/Appointment.txt");
//        try (FileReader fileReader = new FileReader(file)) {
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//
//            String line = null;
//
//            while ((line = bufferedReader.readLine()) != null) {
//                String[] userCredentials = line.split("~");
//
//                if(sameCredentialValidation(userCredentials[credentialIndex], appointmentID)){
//                    return false;
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public boolean rightAppointmentPatient(String appointmentID, String username){
        File file = new File("src/sample/data/Appointment.txt");
        try(FileReader fileReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null ;

            while((line = bufferedReader.readLine()) != null) {
                String[] userCredentials = line.split("~");
                if(identicalCredentialValidation(userCredentials[0], appointmentID)
                        && identicalCredentialValidation(userCredentials[1], username)){
                    return true;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        JFXButton button = new JFXButton("OK");
        loginUserException(getStackPane(), getNode(), Collections.singletonList(button), getStyleIndex(),
                "Invalid Input Data",
                "That Appointment ID is not in belongs to you. Try another." );
        return false;
    }

    public boolean correctAppointment(String username, TextField appointmentID){
        UserEditDelete newUser = new UserEditDelete(2);
        newUser.UserEdit(username);
        String[] userDetails = newUser.getUserDetailArray();
        String reqDoctorDetail = "Dr. "+userDetails[2]+ " " + userDetails[3]+" - "+userDetails[13] ;
        File file = new File("src/sample/data/Appointment.txt");
        try(FileReader fileReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null ;

            while((line = bufferedReader.readLine()) != null) {
                String[] userCredentials = line.split("~");
                if(identicalCredentialValidation(userCredentials[15], reqDoctorDetail) && sameCredentialValidation(userCredentials[0],
                        appointmentID)){
                    return true;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        JFXButton button = new JFXButton("OK");
        loginUserException(getStackPane(), getNode(), Collections.singletonList(button), getStyleIndex(),
                "Invalid Input Data",
                "That Appointment ID is not in belongs to you. Try another." );
        return false;
    }

    public boolean identicalCredentialValidation(String userCredentials1, String userCredentials2){
        return userCredentials1.equals(userCredentials2);
    }

    public boolean validateAppointmentID(TextField ID) throws IOException {
        File file = new File("src/sample/data/Appointment.txt");
        try (FileReader fileReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                String[] userCredentials = line.split("~");

                if(sameCredentialValidation(userCredentials[0], ID)){
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        JFXButton button = new JFXButton("OK");
        loginUserException(getStackPane(), getNode(), Collections.singletonList(button), getStyleIndex(),
                "Invalid Input Data",
                "That Appointment ID is not in Appointment Database. Try with exiting one." );
        return false;
    }
    public boolean validateVisitorID(TextField txt) throws IOException {
        File file = new File("src/sample/data/Visitor.txt");
        try (FileReader fileReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                String[] userCredentials = line.split("~");

                if(sameCredentialValidation(userCredentials[0], txt)){
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        JFXButton button = new JFXButton("OK");
        loginUserException(getStackPane(), getNode(), Collections.singletonList(button), getStyleIndex(),
                "Invalid Input Data",
                "That ID is not in Visitor Database. Try with exiting one." );
        return false;
    }
    public boolean complaintValidationID(TextField txt) throws IOException {
        File file = new File("src/sample/data/Complaint.txt");
        try (FileReader fileReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                String[] userCredentials = line.split("~");

                if(sameCredentialValidation(userCredentials[0], txt)){
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        JFXButton button = new JFXButton("OK");
        loginUserException(getStackPane(), getNode(), Collections.singletonList(button), getStyleIndex(),
                "Invalid Input Data",
                "That ID is not in Complaint Database. Try with exiting one." );
        return false;
    }

    public boolean validateExitingPatientUsername(TextField username){
        if(validateSpecificUsername(username, 2)){
            JFXButton button = new JFXButton("OK");
            loginUserException(getStackPane(), getNode(), Collections.singletonList(button), getStyleIndex(),
                    "Invalid Input Data",
                    "That username is not in Patient Database. Try with exiting one." );
            return false;
        } else {
            return true;
        }
    }

    public boolean validateSpecificUsername(TextField credential1, int usermode){
        final String[] fileLocation = {"src/sample/data/UserReceptionist.txt", "src/sample/data/UserMedicalOfficer.txt",
                "src/sample/data/UserPatient.txt"
        };
            File file = new File(fileLocation[usermode]);
            try (FileReader fileReader = new FileReader(file)) {
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String line = null;

                while ((line = bufferedReader.readLine()) != null) {
                    String[] userCredentials = line.split("~");

                    if(sameCredentialValidation(userCredentials[0], credential1)){
                        return false;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        return true;
    }

    public boolean validateSameCredentials(TextField credential1, int credentialIndex, int credentialBoundary ){
        final String[] fileLocation = {"src/sample/data/UserReceptionist.txt", "src/sample/data/UserMedicalOfficer.txt",
                "src/sample/data/UserPatient.txt"
        };

        for (int i = 0; i < credentialBoundary; i++) {
            File file = new File(fileLocation[i]);
            try (FileReader fileReader = new FileReader(file)) {
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String line = null;

                while ((line = bufferedReader.readLine()) != null) {
                    String[] userCredentials = line.split("~");

                    if(sameCredentialValidation(userCredentials[credentialIndex], credential1)){
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

    public void detailedMsg(String MsgHeader, String MsgBody){
        JFXButton button = new JFXButton("OK");
        loginUserException(getStackPane(), getNode(), Collections.singletonList(button), 1, MsgHeader, MsgBody);
    }

    private void loginUserException(StackPane userStackPane, Node nodeToBeBlurred, List<JFXButton> controls,
                                    int StyleIndex, String dialogHeading, String dialogBody) {
        String[] styleClassDashboard = {"button-raised", "button-raised-admin-dash", "button-raised-mo-dash",
                "button-raised-patient-dash", "button-raised-recep-dash"};
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