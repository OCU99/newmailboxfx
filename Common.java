package com.mycompany.newmailboxfx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Common {
    public static void loadWindow(Button btn, String form) throws IOException {
        Parent root;
        Stage stage;

        var path = form + ".fxml";
        stage = (Stage) btn.getScene().getWindow();
        root = FXMLLoader.load(Common.class.getResource(path));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}