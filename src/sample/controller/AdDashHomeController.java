package sample.controller;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import sample.model.HomeDetails;
import sample.model.LastLogin;

public class AdDashHomeController {

    private ArrayList<String> lastLogin;

    public void setLastLogin(ArrayList<String> lastLogin) {
        this.lastLogin = lastLogin;
    }

    public ArrayList<String> getLastLogin() {
        return lastLogin;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label AdDashHomeMO;

    @FXML
    private Label AdDashHomePatient;

    @FXML
    private Label AdDashHomeRecep;

    @FXML
    private Label AdDashHomeComplaint;

    @FXML
    private Label AdDashHomeAppointment;

    @FXML
    private Label AdDashHomeLastUsername1;

    @FXML
    private Label AdDashHomeLastUsermode1;

    @FXML
    private Label AdDashHomeLastDateTime1;

    @FXML
    private Label AdDashHomeLastUsername2;

    @FXML
    private Label AdDashHomeLastUsermode2;

    @FXML
    private Label AdDashHomeLastDateTime2;

    @FXML
    private Label AdDashHomeLastUsername3;

    @FXML
    private Label AdDashHomeLastUsermode3;

    @FXML
    private Label AdDashHomeLastDateTime3;

    @FXML
    private Label AdDashHomeLastUsername4;

    @FXML
    private Label AdDashHomeLastUsermode4;

    @FXML
    private Label AdDashHomeLastDateTime4;

    @FXML
    private Circle AdDashHomeProPic;

    @FXML
    private Label AdDashHomeName;

    @FXML
    private Label AdDashHomeUsername;

    @FXML
    private Label AdDashHomeTime;

    @FXML
    private Label AdDashHomeDate;

    @FXML
    void initialize() throws IOException {
        // time and day
        realTimeGenerate();
        realDateGenerate();

        HomeDetails adminHome = new HomeDetails();
        adminHome.textReader();
        int[] detailCount = adminHome.getHomeDetailCount();

        AdDashHomeMO.setText(String.format("%d",detailCount[2]));
        AdDashHomeComplaint.setText(String.format("%d",detailCount[4]));
        AdDashHomeAppointment.setText(String.format("%d",detailCount[3]));
        AdDashHomePatient.setText(String.format("%d",detailCount[1]));
        AdDashHomeRecep.setText(String.format("%d",detailCount[0]));

        // add user last login details
        setLastLogin(LastLogin.getLastLogin());

        // Last user 1
        AdDashHomeLastUsermode1.setText(getLastLogin().get(0));
        AdDashHomeLastUsername1.setText(getLastLogin().get(1));
        AdDashHomeLastDateTime1.setText(getLastLogin().get(2)+" at "+getLastLogin().get(3));
        // Last user 2
        AdDashHomeLastUsermode2.setText(getLastLogin().get(4));
        AdDashHomeLastUsername2.setText(getLastLogin().get(5));
        AdDashHomeLastDateTime2.setText(getLastLogin().get(6)+" at "+getLastLogin().get(7));
        // Last user 3
        AdDashHomeLastUsermode3.setText(getLastLogin().get(8));
        AdDashHomeLastUsername3.setText(getLastLogin().get(9));
        AdDashHomeLastDateTime3.setText(getLastLogin().get(10)+" at "+getLastLogin().get(11));
        // Last user 4
        AdDashHomeLastUsermode4.setText(getLastLogin().get(12));
        AdDashHomeLastUsername4.setText(getLastLogin().get(13));
        AdDashHomeLastDateTime4.setText(getLastLogin().get(14)+" at "+getLastLogin().get(15));
        // Last user 5
        AdDashHomeLastUsermode4.setText(getLastLogin().get(16));
        AdDashHomeLastUsername4.setText(getLastLogin().get(17));
        AdDashHomeLastDateTime4.setText(getLastLogin().get(18)+" at "+getLastLogin().get(19));



    }

    public void realTimeGenerate(){
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime currentTime = LocalTime.now();
            AdDashHomeTime.setText(currentTime.getHour() + ":" + currentTime.getMinute() + ":"
                    + currentTime.getSecond());
        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

    public void realDateGenerate(){
        LocalDate day = LocalDate.now(); // or myDatePicker.getValue()
        DateTimeFormatter format = DateTimeFormatter.ofPattern("EEEE", Locale.getDefault());
//        System.out.println(day.format(format));
        AdDashHomeDate.setText(day.format(format));
    }


}
