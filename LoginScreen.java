package com.mycompany.newmailboxfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.io.IOException;

public class LoginScreen extends Common {
    @FXML
    private TextField user;
    @FXML
    private TextField password;
    @FXML
    Button btnHome;
    @FXML
    private Label aLogin;

    public void onHomeButtonClick(ActionEvent actionEvent) {
        if ("avp".equals(user.getText()) && "Z8765a@&".equals(password.getText())) {
            aLogin.setText("success");
            try {
                Common.loadWindow(btnHome, "HomeScreen");
            } catch (IOException ex) {
                ex.getMessage();
            }
        } else if (user.getText().isEmpty() && password.getText().isEmpty()) {
            aLogin.setText("enter some values");
        } else {
            aLogin.setText("invalid login");
        }
    }
}