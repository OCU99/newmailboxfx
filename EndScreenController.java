package com.mycompany.newmailboxfx;

import javafx.event.ActionEvent;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class EndScreenController extends Common {

    @FXML
    Button btnReturn;

    public void onReturnButtonClick(ActionEvent actionEvent) throws IOException {
        Common.loadWindow(btnReturn, "LoginScreen");
    }
}