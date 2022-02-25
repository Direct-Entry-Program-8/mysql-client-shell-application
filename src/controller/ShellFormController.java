package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ShellFormController {
    public TextField txtCommand;
    public Button btnExecute;
    public TextArea txtOutput;
    private String host;
    private String port;
    private String userName;
    private String password;

    public void initData(String host, String port, String userName, String password){
        this.host = host;
        this.port = port;
        this.userName = userName;
        this.password = password;
    }

    public void btnExecute_OnAction(ActionEvent actionEvent) {
    }
}
