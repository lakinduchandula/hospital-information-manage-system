package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
<<<<<<< HEAD
        Parent root = FXMLLoader.load(getClass().getResource("view/AdDashMOApplication.fxml"));


=======
        Parent root = FXMLLoader.load(getClass().getResource("view/AdminDashboard.fxml"));
>>>>>>> 50a689b0c30b158b4163b6a7867d4e2b8a131b6e
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1050, 576));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
