/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.newmailboxfx;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 *
 * @author avp
 */
public class ErrorController {
    
    @FXML
    Button btnManual;
    
    public void onManualButtonClick(ActionEvent actionEvent) throws IOException {
        Common.loadWindow(btnManual, "Manual");
    }   
}