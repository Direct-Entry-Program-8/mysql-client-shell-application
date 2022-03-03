package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;

public class ShellFormController {
    public TextField txtCommand;
    public Button btnExecute;
    public TextArea txtOutput;
    private Process mysql;

    public void initialize(){
        txtOutput.setWrapText(true);
    }

    public void initData(String host, String port, String userName, String password) {
        try {

            ProcessBuilder mysqlBuilder = new ProcessBuilder("mysql",
                    "-h", host,
                    "-u", userName,
                    "--port", port,
                    "-n",
                    "-p",
                    "-v");
            this.mysql = mysqlBuilder.start();

            this.mysql.getOutputStream().write((password + "\n").getBytes());
            this.mysql.getOutputStream().flush();

            txtCommand.getScene().getWindow().setOnCloseRequest(event -> {
                if (this.mysql.isAlive()) {
                    this.mysql.destroy();
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Failed to establish the connection for some reason").show();
            if (mysql.isAlive()) {
                mysql.destroyForcibly();
            }
        }
    }

    public void btnExecute_OnAction(ActionEvent actionEvent) {
        String statement = txtCommand.getText();

        if (!txtCommand.getText().endsWith(";")) {
            statement += ";";
        }
        try {
            this.mysql.getOutputStream().write((statement + "\n").getBytes());
            this.mysql.getOutputStream().flush();

            InputStream is = this.mysql.getInputStream();
            InputStream es = this.mysql.getErrorStream();

            if (is.a)
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
