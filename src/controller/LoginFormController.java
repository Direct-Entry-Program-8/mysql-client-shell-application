package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginFormController {

    public TextField txtHost;
    public TextField txtPort;
    public TextField txtUserName;
    public PasswordField txtPassword;
    public Button btnConnect;
    public Button btnExit;

    public void initialize() {
        Platform.runLater(()->txtUserName.requestFocus());
    }

    public void btnConnect_OnAction(ActionEvent event) {

    }

    public void btnExit_OnAction(ActionEvent event) {
        System.exit(0);
    }

}
