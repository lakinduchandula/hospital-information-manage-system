package sample.controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.Label;
import javafx.util.Duration;
import sample.model.Analytics;
import sample.model.HomeDetails;
import sample.model.UserEditDelete;

public class MODashHomeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label AdDashHomeDate;

    @FXML
    private Label AdDashHomeTime;

    @FXML
    private Label MODashHomeRecep;

    @FXML
    private Label MODashHomeMO;

    @FXML
    private Label MODashHomePatient;

    @FXML
    private LineChart<String, Integer> AppointmentChart;

    @FXML
    private CategoryAxis AppX;

    @FXML
    private NumberAxis AppY;

    @FXML
    private BarChart<String, Integer> ComplaintChart;

    @FXML
    private CategoryAxis CompX;

    @FXML
    private NumberAxis CompY;

    @FXML
    private Label MODashHomeAllAppCount;

    @FXML
    private Label MODashHomeMEAppCount;

    @FXML
    private Label MODashHomePendingApp;

    @FXML
    private Label MODashHomeApproveApp;

    @FXML
    private Label RecepDashHomeCompApp;

    @FXML
    private Label RecepDashHomeUndoneComp;

    @FXML
    void initialize() {
        // time and day
        realTimeGenerate();
        realDateGenerate();

        // call and instantiation for get user specific details
        UserEditDelete newEditProfile = new UserEditDelete(2);
        newEditProfile.UserEdit(LoginController.currentUser);
        String[] MOProfileDetail = newEditProfile.getUserDetailArray();

        // call home details class for standard stats
        HomeDetails MOHomeDetails = new HomeDetails();
        MOHomeDetails.textReader();
        int[] detailCount = MOHomeDetails.getHomeDetailCount();

        // instantiation of Analytics class
        Analytics MOHome = new Analytics();

        // appointment chart start
        XYChart.Series appointmentAll = new XYChart.Series();
        MOHome.AppointmentCalculations(); // call method to calculate appointment analytics
        MOHome.AppointmentStatusSpecificMO(MOProfileDetail[14]);

        // fill the graph with details
        appointmentAll.getData().add(new XYChart.Data("January", MOHome.getAppointmentByMonth()[0]));
        appointmentAll.getData().add(new XYChart.Data("February", MOHome.getAppointmentByMonth()[1]));
        appointmentAll.getData().add(new XYChart.Data("March", MOHome.getAppointmentByMonth()[2]));
        appointmentAll.getData().add(new XYChart.Data("April", MOHome.getAppointmentByMonth()[3]));
        appointmentAll.getData().add(new XYChart.Data("May", MOHome.getAppointmentByMonth()[4]));
        appointmentAll.getData().add(new XYChart.Data("June", MOHome.getAppointmentByMonth()[5]));
        appointmentAll.getData().add(new XYChart.Data("July", MOHome.getAppointmentByMonth()[6]));
        appointmentAll.getData().add(new XYChart.Data("August", MOHome.getAppointmentByMonth()[7]));
        appointmentAll.getData().add(new XYChart.Data("September", MOHome.getAppointmentByMonth()[8]));
        appointmentAll.getData().add(new XYChart.Data("October", MOHome.getAppointmentByMonth()[9]));
        appointmentAll.getData().add(new XYChart.Data("November", MOHome.getAppointmentByMonth()[10]));
        appointmentAll.getData().add(new XYChart.Data("December", MOHome.getAppointmentByMonth()[11]));

        // plot graph with above details
//        AppointmentChart.setStyle("CHART_COLOR_1: #0000FF ;");MOHome
//        AppointmentChart.setStyle("-fx-background-color: white ");
        AppointmentChart.getData().addAll(appointmentAll);


        XYChart.Series appointmentME = new XYChart.Series<>();
        MOHome.AppointmentCalculationsForSpecificMO(MOProfileDetail[14]); // call method to calculate complaint analytics

        appointmentME.getData().add(new XYChart.Data<>("January", MOHome.getAppointmentByMonthSpecificMO()[0]));
        appointmentME.getData().add(new XYChart.Data<>("February", MOHome.getAppointmentByMonthSpecificMO()[1]));
        appointmentME.getData().add(new XYChart.Data<>("March", MOHome.getAppointmentByMonthSpecificMO()[2]));
        appointmentME.getData().add(new XYChart.Data<>("April", MOHome.getAppointmentByMonthSpecificMO()[3]));
        appointmentME.getData().add(new XYChart.Data<>("May", MOHome.getAppointmentByMonthSpecificMO()[4]));
        appointmentME.getData().add(new XYChart.Data<>("June", MOHome.getAppointmentByMonthSpecificMO()[5]));
        appointmentME.getData().add(new XYChart.Data<>("July", MOHome.getAppointmentByMonthSpecificMO()[6]));
        appointmentME.getData().add(new XYChart.Data<>("August", MOHome.getAppointmentByMonthSpecificMO()[7]));
        appointmentME.getData().add(new XYChart.Data<>("September", MOHome.getAppointmentByMonthSpecificMO()[8]));
        appointmentME.getData().add(new XYChart.Data<>("October", MOHome.getAppointmentByMonthSpecificMO()[9]));
        appointmentME.getData().add(new XYChart.Data<>("November", MOHome.getAppointmentByMonthSpecificMO()[10]));
        appointmentME.getData().add(new XYChart.Data<>("December", MOHome.getAppointmentByMonthSpecificMO()[11]));

        // plot graph with above details
        ComplaintChart.getData().addAll(appointmentME);

        // specific status for MO -> Pending, Approved, Complete
        MODashHomePendingApp.setText(String.valueOf(MOHome.getAppointmentSpecificMOStatus()[0]));
        MODashHomeApproveApp.setText(String.valueOf(MOHome.getAppointmentSpecificMOStatus()[1]));
        RecepDashHomeCompApp.setText(String.valueOf(MOHome.getAppointmentSpecificMOStatus()[2]));

        // standard stats for MO, User counts
        MODashHomeMO.setText(String.format("%d",detailCount[2]));
        MODashHomeAllAppCount.setText(String.format("%d",detailCount[3]));
        MODashHomePatient.setText(String.format("%d",detailCount[1]));
        MODashHomeRecep.setText(String.format("%d",detailCount[0]));
        MODashHomeMEAppCount.setText(String.valueOf(MOHome.getAppointmentSpecificMOStatus()[0]+
                MOHome.getAppointmentSpecificMOStatus()[1]+
                MOHome.getAppointmentSpecificMOStatus()[2]));

        // percentage of specific appointment
        RecepDashHomeUndoneComp.setText(percentageCalculator(
                MOHome.getAppointmentSpecificMOStatus()[0],
                MOHome.getAppointmentSpecificMOStatus()[1],
                MOHome.getAppointmentSpecificMOStatus()[2],
                detailCount[3]
        ));
    }

    public String percentageCalculator(int Pending, int Complete, int Approved, int allAppointmentCount){
        float total = (Pending+Complete+Approved) ;
        float percentage = total/allAppointmentCount;
        return String.format("%.2f%%", percentage*100);

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
