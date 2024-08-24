package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import com.jfoenix.controls.JFXButton;

import controllerForLayer.BookController;
import dto.BookDTO;
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

public class BooksController {
    @FXML
    private AnchorPane UserUpdateANDdeleteRoot;

    @FXML
    private JFXButton btnNewUser;

    @FXML
    private JFXButton btnUpdateUser;

    @FXML
    private JFXButton btnUserDelete;

    @FXML
    private TableColumn<BookDTO, String> colomnAuthor;

    @FXML
    private TableColumn<BookDTO, String> colomnAvalability;

    @FXML
    private TableColumn<BookDTO, String> colomnBookId;

    @FXML
    private TableColumn<BookDTO, String> colomnBookName;

    @FXML
    private TableColumn<BookDTO, String> colomnCatagory_ID;

    @FXML
    private TableColumn<BookDTO, String> colomnPublich_Date;

    @FXML
    private TableColumn<BookDTO, String> colomnUser_ID;

    @FXML
    private TableColumn<BookDTO, String> colomnReleadDate;

    @FXML
    private TableColumn<BookDTO, String> colomnFine;

    @FXML
    private TableView<BookDTO> tblBook;

    @FXML
    private TextField textFieldAuthor;

    @FXML
    private TextField textFieldAvailability;

    @FXML
    private TextField textFieldBookID;

    @FXML
    private TextField textFieldBookname;

    @FXML
    private TextField textFieldCatagoryID;

    @FXML
    private TextField textFieldEnterBookIDForSearch;

    @FXML
    private TextField textFieldPublishDate;

    @FXML
    private TextField textFieldUserID;

    @FXML
    private TextField textFieldReleseDate;

    public void initialize() throws Exception {
        BookLoadTableData();
        
        colomnBookId.setCellValueFactory(new PropertyValueFactory<>("BookID"));
        colomnBookName.setCellValueFactory(new PropertyValueFactory<>("BookName"));
        colomnAuthor.setCellValueFactory(new PropertyValueFactory<>("Author"));
        colomnPublich_Date.setCellValueFactory(new PropertyValueFactory<>("PublishDate"));
        colomnAvalability.setCellValueFactory(new PropertyValueFactory<>("Ability"));
        colomnUser_ID.setCellValueFactory(new PropertyValueFactory<>("UserID"));
        colomnCatagory_ID.setCellValueFactory(new PropertyValueFactory<>("CatagoryID"));
        colomnReleadDate.setCellValueFactory(new PropertyValueFactory<>("ReleasedDate"));
        colomnFine.setCellValueFactory(new PropertyValueFactory<>("Fine"));

         // Load data into the table when initializing
    }


    @FXML
    void btnDelete(ActionEvent event) {
        try {
            String bookId = textFieldCatagoryID.getText();
            String resp = BookController.delete(bookId);
            showAlert(AlertType.INFORMATION, "Success", resp);
            clearForm();
            BookLoadTableData();
    }catch (Exception ex) {
        ex.printStackTrace();
        showAlert(AlertType.ERROR, "Error", "Error delete data: " + ex.getMessage());
    }
    }
    @FXML
    void btnUpdate(ActionEvent event){
        try {
            
            BookDTO dto = new BookDTO(textFieldBookID.getText(), textFieldBookname.getText(), textFieldAuthor.getText(), textFieldPublishDate.getText(), textFieldAvailability.getText(),textFieldUserID.getText(),textFieldCatagoryID.getText(),textFieldReleseDate.getText(), FineCalculator(textFieldReleseDate));
            String resp = BookController.update(dto);
            showAlert(AlertType.INFORMATION, "Success", resp);
            clearForm();
            BookLoadTableData();
            clearForm();
            
        } catch (Exception ex) {
            ex.printStackTrace();
            showAlert(AlertType.ERROR, "Error", "Error update data: " + ex.getMessage());
        }
    }

    


    @FXML
    void btnNew(ActionEvent event) {
        try {
            BookDTO dto = new BookDTO(textFieldBookID.getText(), textFieldBookname.getText(), textFieldAuthor.getText(), textFieldPublishDate.getText(), textFieldAvailability.getText(),textFieldUserID.getText(),textFieldCatagoryID.getText(),textFieldReleseDate.getText(), FineCalculator(textFieldReleseDate));
            String resp = BookController.save(dto);
            showAlert(AlertType.INFORMATION, "Success", resp);
            clearForm();
            BookLoadTableData();
        } catch (Exception ex) {
            ex.printStackTrace();
            showAlert(AlertType.ERROR, "Error", "Error saving data: " + ex.getMessage());
            
        }
    }

    @FXML
    void btnSearchID(ActionEvent event) throws Exception {
        if (textFieldEnterBookIDForSearch.equals("")) {
            BookLoadTableData();

        }else{
            try {
                ObservableList<BookDTO> bookArrayList = FXCollections.observableArrayList();
            ArrayList <BookDTO> bookSet= BookController.getAllCategory(textFieldEnterBookIDForSearch.getText());

                if (bookSet!=null) {
                    
                

            for (BookDTO book:bookSet) {
                BookDTO bookDTO = new BookDTO(
                    book.getBookID(),
                    book.getBookName(),
                    book.getAuthor(),
                    book.getPublishDate(),
                    book.getAbility(),
                    book.getUserID(),
                    book.getCatagoryID(),
                    book.getReleasedDate(),
                    book.getFine()
                );
                bookArrayList.add(bookDTO);
            }
        }
            tblBook.setItems(bookArrayList);
            } catch (Exception ex) {
                ex.printStackTrace();
                showAlert(AlertType.ERROR, "Error", "Invalid Input " + ex.getMessage());
                BookLoadTableData();
                
            }

        }
        
    }

    @FXML
    void tblBookRawClick(MouseEvent event) {
        try {
            // Get the selected item from the TableView
            BookDTO selectedBook = tblBook.getSelectionModel().getSelectedItem();
            
            if (selectedBook != null) {
                // Fill text fields with the selected user's details
                textFieldBookID.setText(selectedBook.getBookID());
                textFieldBookname.setText(selectedBook.getBookName());
                textFieldAuthor.setText(selectedBook.getAuthor());
                textFieldPublishDate.setText(selectedBook.getPublishDate());
                textFieldAvailability.setText(selectedBook.getAbility());
                textFieldUserID.setText(selectedBook.getUserID());
                textFieldCatagoryID.setText(selectedBook.getCatagoryID());
                textFieldReleseDate.setText(selectedBook.getReleasedDate()); // Format as needed
            } else {
                showAlert(AlertType.INFORMATION, "Item not found", "No user selected.");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            showAlert(AlertType.ERROR, "Error", "Error displaying data: " + ex.getMessage());
        }

    }

    private void showAlert(AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void BookLoadTableData() throws Exception {
        ObservableList<BookDTO> bookArratList = FXCollections.observableArrayList();

        ArrayList <BookDTO> bookSet= BookController.getAllCategory();
        for (BookDTO book:bookSet) {
            String fine = FinedCalculator(book.getReleasedDate());
            BookDTO bookDTO = new BookDTO(
                book.getBookID(),
                book.getBookName(),
                book.getAuthor(),
                book.getPublishDate(),
                book.getAbility(),
                book.getUserID(),
                book.getCatagoryID(),
                book.getReleasedDate(),
                fine
            );
            bookArratList.add(bookDTO);
        }

        
        tblBook.setItems(bookArratList);
    }

    private String FinedCalculator(String releasedDate) {
        try {
            // Get the date string from the JTextField
            String dateString = releasedDate.trim();
            // Create a DateTimeFormatter to handle the specific date format with optional space
            DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendPattern("uuuu-MM-dd") // Define the date format pattern
                .optionalStart() // Start optional pattern for additional characters
                .appendPattern(" ") // Handle extra space
                .optionalEnd() // End optional pattern
                .toFormatter()
                .withResolverStyle(ResolverStyle.STRICT); // Strict parsing to avoid unexpected inputs

            // Parse the date string into a LocalDate object
            LocalDate releadeDatenew = LocalDate.parse(dateString, formatter);

            // Get the current date
            LocalDate currentDate = LocalDate.now();

            // Calculate the number of days between the released date and the current date
            long daysBetween = ChronoUnit.DAYS.between(releadeDatenew, currentDate);

            // Calculate the fine if the days exceed 14 days
            long fine = 0;
            if (daysBetween > 14) {
                fine = (daysBetween - 14) * 5;
            }

            // Return the fine as a string
            return "Rs" + fine;

        } catch (Exception e) {
            // Return an error message if the date is invalid
            return "Rs 0";
        }
    }


    private void clearForm() {
        textFieldBookID.setText("");
        textFieldBookname.setText("");
        textFieldAuthor.setText("");
        textFieldPublishDate.setText("");
        textFieldAvailability.setText("");
        textFieldUserID.setText("");
        textFieldCatagoryID.setText("");
        textFieldReleseDate.setText("");
    }

    private String FineCalculator(TextField textFieldReleseDate2) {
        try {
            // Get the date string from the JTextField
            String dateString = textFieldReleseDate2.getText().trim();

            // Create a DateTimeFormatter to handle the specific date format with optional space
            DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendPattern("uuuu-MM-dd") // Define the date format pattern
                .optionalStart() // Start optional pattern for additional characters
                .appendPattern(" ") // Handle extra space
                .optionalEnd() // End optional pattern
                .toFormatter()
                .withResolverStyle(ResolverStyle.STRICT); // Strict parsing to avoid unexpected inputs

            // Parse the date string into a LocalDate object
            LocalDate releasedDate = LocalDate.parse(dateString, formatter);

            // Get the current date
            LocalDate currentDate = LocalDate.now();

            // Calculate the number of days between the released date and the current date
            long daysBetween = ChronoUnit.DAYS.between(releasedDate, currentDate);

            // Calculate the fine if the days exceed 14 days
            long fine = 0;
            if (daysBetween > 14) {
                fine = (daysBetween - 14) * 5;
            }

            // Return the fine as a string
            return "Rs" + fine;

        } catch (Exception e) {
            // Return an error message if the date is invalid
            return "Rs 0";
        }
    }

    
}
