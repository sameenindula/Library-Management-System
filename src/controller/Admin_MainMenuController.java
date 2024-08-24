package controller;

import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Admin_MainMenuController {
    
    
    @FXML
    private AnchorPane AdminMainPageRoot;

    @FXML
    void btnBokkCategory(ActionEvent event) throws IOException {
        URL resource = getClass().getResource("/view/BookCatagory.fxml");;
        Parent root = FXMLLoader.load(resource);;// load the resource
        Stage stage= new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        stage.setTitle("Book_Management_Sys");
    }

    @FXML
    void btnBooks(ActionEvent event) throws IOException {
        URL resource = getClass().getResource("/view/Books.fxml");;
        Parent root = FXMLLoader.load(resource);;// load the resource
        Stage stage= new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        stage.setTitle("Book_Management_Sys");  
        
    }

    @FXML
    void btnUsers(ActionEvent event) throws IOException {
        URL resource = getClass().getResource("/view/Users.fxml");;
        Parent root = FXMLLoader.load(resource);;// load the resource
        Stage stage= new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        stage.setTitle("Book_Management_Sys");
    }
}
