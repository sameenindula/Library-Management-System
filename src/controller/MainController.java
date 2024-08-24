package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class MainController {
/////////////////////////////////////////////Main manu///////////////////////////////////////////////////////////////////////////////////////////////////
        @FXML
    private AnchorPane firstpageRoot;

    @FXML
    void btnAdmin(ActionEvent event) throws IOException {
        // URL resource = getClass().getResource("/view/Admin.fxml");;
        // Parent root = FXMLLoader.load(resource);;// load the resource
        // Stage stage= new Stage();
        // stage.setScene(new Scene(root));
        // stage.show();
        // stage.setTitle("Book_Management_Sys");

        this.firstpageRoot.getChildren().clear();
        Parent node = FXMLLoader.load(this.getClass().getResource("/view/Admin.fxml"));
        this.firstpageRoot.getChildren().add(node);
    }

    @FXML
    void btnUser(ActionEvent event) {

    }

    //////////////////////////////////Admin passwd ///////////////////////////////////////////////////////////////////////////////////////////

     @FXML
    private TextField txtFieldAdminName;

    @FXML
    private TextField txtFieldPasswd;

    @FXML
    void btnAdminLogin(ActionEvent event) {
        if (txtFieldAdminName.toString()=="abmin" && txtFieldPasswd.toString()=="1234") {
            System.out.println("ff");
        }
    }

}
