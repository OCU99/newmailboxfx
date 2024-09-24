package com.mycompany.newmailboxfx;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ReturnScreenController {

    
    @FXML
    Button btnHome;
    
    public void onHomeButtonClick(ActionEvent actionEvent) throws IOException {
        Common.loadWindow(btnHome, "HomeScreen");
    }
    
}