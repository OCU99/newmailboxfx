package com.mycompany.newmailboxfx;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class MainApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {

        URL url1 = new File("src/main/resources/com/mycompany/newmailboxfx/Login.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url1);
        Scene scene = new Scene(root, 900, 690);

        primaryStage.setTitle("Mailroom");
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}