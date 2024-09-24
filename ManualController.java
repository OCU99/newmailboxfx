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
public class ManualController {
    
    @FXML
    Button btnError;
    
    @FXML
    Button btnMultiple;
    
    public void onErrorButtonClick(ActionEvent actionEvent) throws IOException {
        Common.loadWindow(btnError, "ErrorScreen");
    }
    
    public void onMultipleButtonClick(ActionEvent actionEvent) throws IOException {
        Common.loadWindow(btnMultiple, "MultiplePackages");
    }   
}