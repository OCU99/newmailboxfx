package com.mycompany.newmailboxfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.io.IOException;

public class HomeController {

    @FXML
    Button btnSearch;

    @FXML
    Button btnReturn;

    @FXML
    Button btnTake;

    @FXML
    Button btnLogout;

    public void onSearchButtonClick(ActionEvent actionEvent) throws IOException {
        Common.loadWindow(btnSearch, "SearchScreen");
    }

    public void onReturnButtonClick(ActionEvent actionEvent) throws IOException {
        Common.loadWindow(btnReturn, "ReturnScreen");
    }

    public void onTakeButtonClick(ActionEvent actionEvent) throws IOException {
        Common.loadWindow(btnTake, "TakePhotoScreen");
    }

    public void onLogoutButtonClick(ActionEvent actionEvent) throws IOException {
        Common.loadWindow(btnLogout, "LoginScreen");
    }
}