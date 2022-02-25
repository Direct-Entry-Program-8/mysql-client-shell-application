package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginFormController {

    public TextField txtHost;
    public TextField txtPort;
    public TextField txtUserName;
    public PasswordField txtPassword;
    public Button btnConnect;
    public Button btnExit;

    public void initialize() {
        Platform.runLater(() -> txtUserName.requestFocus());
    }

    public void btnConnect_OnAction(ActionEvent event) {

        /* Let's validate some inputs */
        if (txtHost.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Host can't be empty").show();
            txtHost.requestFocus();
            txtHost.selectAll();
            return;
        } else if (!txtPort.getText().matches("\\d+")) {
            new Alert(Alert.AlertType.ERROR, "Invalid port").show();
            txtPort.requestFocus();
            txtPort.selectAll();
            return;
        } else if (txtUserName.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Username can't be empty").show();
            txtUserName.requestFocus();
            txtUserName.selectAll();
            return;
        }

        try {
//            String command = String.format("mysql -h %s -u %s -p%s --port %s -e exit",
//                    txtHost.getText(),
//                    txtUserName.getText(),
//                    txtPassword.getText(),
//                    txtPort.getText());
//            String[] commands = {"mysql",
//                    "-h", txtHost.getText(),
//                    "-u", txtUserName.getText(),
//                    "--port", txtPort.getText(),
//                    "-p" + txtPassword.getText(),
//                    "-e", "exit"};
//            Process mysql = Runtime.getRuntime().exec(commands);

            Process mysql = new ProcessBuilder("mysql",
                    "-h", txtHost.getText(),
                    "-u", txtUserName.getText(),
                    "--port", txtPort.getText(),
                    "-p" + txtPassword.getText(),
                    "-e", "exit").start();

            int exitCode = mysql.waitFor();
            if (exitCode != 0) {
                new Alert(Alert.AlertType.ERROR, "Can't establish the connection, try again").show();
                txtUserName.requestFocus();
                txtUserName.selectAll();
            } else {
                System.out.println("Wade Goda!");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void btnExit_OnAction(ActionEvent event) {
        System.exit(0);
    }

}
