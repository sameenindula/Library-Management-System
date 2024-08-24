package controller;

import java.util.ArrayList;

import controllerForLayer.CategoryController;
import dto.CategoryDTO;
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

public class BooksCategoryController {

    @FXML
    private TableColumn<CategoryDTO,String> RawBook_Category;

    @FXML
    private TableColumn<CategoryDTO,String> RawCategory_ID;

    @FXML
    private TableColumn<CategoryDTO,String> RawPairsOfBooks;

    @FXML
    private TableColumn<CategoryDTO,String> RawQty_Of_Books;

    @FXML
    private AnchorPane UserUpdateANDdeleteRoot;

    @FXML
    private TableView<CategoryDTO> tableCategory;

    @FXML
    private TextField textFieldBookCategory;

    @FXML
    private TextField textFieldCategoryID;

    @FXML
    private TextField textFieldEnterCategoryIDForSearch;

    public void initialize() throws Exception {
        CategoryLoadTableData();
        RawCategory_ID.setCellValueFactory(new PropertyValueFactory<>("categoryId"));
        RawBook_Category.setCellValueFactory(new PropertyValueFactory<>("bookCategory"));
        RawQty_Of_Books.setCellValueFactory(new PropertyValueFactory<>("QtyOfBooks"));
        RawPairsOfBooks.setCellValueFactory(new PropertyValueFactory<>("PairsOfBooks"));
        

         // Load data into the table when initializing
    }
    private void showAlert(AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    private void clearForm() {
        textFieldCategoryID.setText("");
        textFieldBookCategory.setText("");
    }

    @FXML
    void btnDelete(ActionEvent event) {
        try {
                String categoryId = textFieldCategoryID.getText();
                String resp = CategoryController.delete(categoryId);
                showAlert(AlertType.INFORMATION, "Success", resp);
                clearForm();
                CategoryLoadTableData();
        }catch (Exception ex) {
            ex.printStackTrace();
            showAlert(AlertType.ERROR, "Error", "Error delete data: " + ex.getMessage());
        }
    }

    @FXML
    void btnNew(ActionEvent event) {
        try {
            CategoryDTO dto = new CategoryDTO(textFieldCategoryID.getText(), textFieldBookCategory.getText(), null, null);
            String resp = CategoryController.save(dto);
            showAlert(AlertType.INFORMATION, "Success", resp);
            clearForm();
            CategoryLoadTableData();
        } catch (Exception ex) {
            ex.printStackTrace();
            showAlert(AlertType.ERROR, "Error", "Error saving data: " + ex.getMessage());
            
        }

    }

    @FXML
    void btnSearchID(ActionEvent event) throws Exception {
        try {
            ObservableList<CategoryDTO> categoryArrayList = FXCollections.observableArrayList();
        ArrayList <CategoryDTO> categorySet= CategoryController.getAllCategory(textFieldEnterCategoryIDForSearch.getText());
        for (CategoryDTO category:categorySet) {
            CategoryDTO categoryDTO = new CategoryDTO(
                category.getCategoryId(),
                category.getBookCategory(),
                category.getQtyOfBooks(),
                category.getPairsOfBooks()
            );
            categoryArrayList.add(categoryDTO);
        }
        tableCategory.setItems(categoryArrayList);
        } catch (Exception ex) {
            ex.printStackTrace();
            showAlert(AlertType.ERROR, "Error", "Invalid Input " + ex.getMessage());
            CategoryLoadTableData();
            
        }
    }

    @FXML
    void btnUpdate(ActionEvent event) {
        try {
            CategoryDTO dto = new CategoryDTO(textFieldCategoryID.getText(), textFieldBookCategory.getText(), null, null);
            String resp = CategoryController.update(dto);
            showAlert(AlertType.INFORMATION, "Success", resp);
            clearForm();
            CategoryLoadTableData();
            clearForm();
            
        } catch (Exception ex) {
            ex.printStackTrace();
            showAlert(AlertType.ERROR, "Error", "Error update data: " + ex.getMessage());
        }
    }

    @FXML
    void tblCategoryColumClick(MouseEvent event) {
        try {
            // Get the selected item from the TableView
            CategoryDTO selectedUser = tableCategory.getSelectionModel().getSelectedItem();
            
            if (selectedUser != null) {
                // Fill text fields with the selected user's details
                textFieldCategoryID.setText(selectedUser.getCategoryId());
                textFieldBookCategory.setText(selectedUser.getBookCategory());
            } else {
                showAlert(AlertType.INFORMATION, "Item not found", "No user selected.");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            showAlert(AlertType.ERROR, "Error", "Error displaying data: " + ex.getMessage());
        }
    }
    

    private void CategoryLoadTableData() throws Exception {
    ObservableList<CategoryDTO> categoryArrayList = FXCollections.observableArrayList();

    ArrayList<CategoryDTO> categorySet = CategoryController.getAllCategory();
    categoryArrayList.addAll(categorySet);

    tableCategory.setItems(categoryArrayList);
}


}
