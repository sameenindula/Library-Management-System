package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AdminLoginController {
    
    @FXML
    private AnchorPane adminLoginRoot;

    @FXML
    private TextField txtFieldAdminName;

    @FXML
    private TextField txtFieldPasswd;

    @FXML
    private Label lblNoties;

    @FXML
    void btnAdminLogin(ActionEvent event) throws IOException {
        if (txtFieldAdminName.getText().equals("admin") && txtFieldPasswd.getText().equals("1234")) {
            this.adminLoginRoot.getChildren().clear();
            Parent node = FXMLLoader.load(this.getClass().getResource("/view/Admin_MainMenu.fxml"));
            this.adminLoginRoot.getChildren().add(node);
        } else {
            lblNoties.setText("user name or passwd wrong");
        }
    }
}
