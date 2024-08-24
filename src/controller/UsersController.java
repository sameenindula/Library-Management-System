package controller;

import java.util.ArrayList;

import com.jfoenix.controls.JFXButton;

import controllerForLayer.UserController;
import dto.UserDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class UsersController {

    
    @FXML
    private AnchorPane UserUpdateANDdeleteRoot;

    @FXML
    private JFXButton btnNewUser;

    @FXML
    private JFXButton btnUpdateUser;

    @FXML
    private JFXButton btnUserDelete;

    @FXML
    private TextField textFieldAddress;

    @FXML
    private TextField textFieldContactNumber;

    @FXML
    private TextField textFieldEnterUserIDForSearch;

    @FXML
    private TextField textFieldJoinDate;

    @FXML
    private TextField textFieldUserID;

    @FXML
    private TextField textFieldUserName;

    @FXML
    private TableView<UserDTO> tblUsers;

    @FXML
    private TableColumn<UserDTO, String> tblAddress;

    @FXML
    private TableColumn<UserDTO, String> tblContactNumber;

    @FXML
    private TableColumn<UserDTO, String> tblJoinDate;

    @FXML
    private TableColumn<UserDTO, String> tblUserID;

    @FXML
    private TableColumn<UserDTO, String> tblUserName;

    public void initialize() throws Exception {
        UserLoadTableData();
        tblUserID.setCellValueFactory(new PropertyValueFactory<>("user_ID"));
        tblUserName.setCellValueFactory(new PropertyValueFactory<>("user_Name"));
        tblAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        tblContactNumber.setCellValueFactory(new PropertyValueFactory<>("contactNO"));
        tblJoinDate.setCellValueFactory(new PropertyValueFactory<>("joiDate"));

         // Load data into the table when initializing
    }

    @FXML
    void btnUpdate(ActionEvent event) {
        try {
            UserDTO dto = new UserDTO(textFieldUserID.getText(), textFieldUserName.getText(), textFieldAddress.getText(), textFieldContactNumber.getText(), textFieldJoinDate.getText());
            String resp = UserController.update(dto);
            showAlert(AlertType.INFORMATION, "Success", resp);
            clearForm();
            UserLoadTableData();
            clearForm();
            
        } catch (Exception ex) {
            ex.printStackTrace();
            showAlert(AlertType.ERROR, "Error", "Error update data: " + ex.getMessage());
        }
    }

    @FXML
    void btnDelete(ActionEvent event) {
    try {
                String userId = textFieldUserID.getText();
                String resp = UserController.delete(userId);
                showAlert(AlertType.INFORMATION, "Success", resp);
                clearForm();
                UserLoadTableData();
        }catch (Exception ex) {
            ex.printStackTrace();
            showAlert(AlertType.ERROR, "Error", "Error delete data: " + ex.getMessage());
        }
    }


    @FXML
    void btnNew(ActionEvent event) {
        try {
            UserDTO dto = new UserDTO(textFieldUserID.getText(), textFieldUserName.getText(), textFieldAddress.getText(), textFieldContactNumber.getText(), textFieldJoinDate.getText());
            String resp = UserController.save(dto);
            showAlert(AlertType.INFORMATION, "Success", resp);
            clearForm();
            UserLoadTableData();
        } catch (Exception ex) {
            ex.printStackTrace();
            showAlert(AlertType.ERROR, "Error", "Error saving data: " + ex.getMessage());
            
        }
    }

    @FXML
    void btnSearchID(ActionEvent event) throws Exception {
        
        try {
            ObservableList<UserDTO> userArrayList = FXCollections.observableArrayList();
        ArrayList <UserDTO> userSet= UserController.getAllUsers(textFieldEnterUserIDForSearch.getText());
        for (UserDTO user:userSet) {
            UserDTO userDTO = new UserDTO(
                user.getUser_ID(),
                user.getUser_Name(),
                user.getAddress(),
                user.getContactNO(),
                user.getJoiDate()
            );
            userArrayList.add(userDTO);
        }
        tblUsers.setItems(userArrayList);
        } catch (Exception ex) {
            ex.printStackTrace();
            showAlert(AlertType.ERROR, "Error", "Invalid Input " + ex.getMessage());
            UserLoadTableData();
            
        }


        
    }
    
    @FXML
    void tableUsers(ActionEvent event) {
        // Implementation for tableUsers
    }

    private void showAlert(AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void UserLoadTableData() throws Exception {
        ObservableList<UserDTO> userArrayList = FXCollections.observableArrayList();

        ArrayList <UserDTO> userSet= UserController.getAllUsers();
        for (UserDTO user:userSet) {
            UserDTO userDTO = new UserDTO(
                user.getUser_ID(),
                user.getUser_Name(),
                user.getAddress(),
                user.getContactNO(),
                user.getJoiDate()
            );
            userArrayList.add(userDTO);
        }

        
        tblUsers.setItems(userArrayList);
    }

    private void clearForm() {
        textFieldUserID.setText("");
        textFieldUserName.setText("");
        textFieldAddress.setText("");
        textFieldContactNumber.setText("");
        textFieldJoinDate.setText("");
    }
    
    @FXML
    void mouseClickColum(MouseEvent event) {
        try {
            // Get the selected item from the TableView
            UserDTO selectedUser = tblUsers.getSelectionModel().getSelectedItem();
            
            if (selectedUser != null) {
                // Fill text fields with the selected user's details
                textFieldUserID.setText(selectedUser.getUser_ID());
                textFieldUserName.setText(selectedUser.getUser_Name());
                textFieldAddress.setText(selectedUser.getAddress());
                textFieldContactNumber.setText(selectedUser.getContactNO());
                textFieldJoinDate.setText(selectedUser.getJoiDate().toString()); // Format as needed
            } else {
                showAlert(AlertType.INFORMATION, "Item not found", "No user selected.");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            showAlert(AlertType.ERROR, "Error", "Error displaying data: " + ex.getMessage());
        }
    }


}
