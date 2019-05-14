package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DialogController {
    @FXML
    private TextField firstNameDialog;
    @FXML
    private TextField lastNameDialog;
    @FXML
    private TextField phoneDialog;
    @FXML
    private TextArea notesDialog;

    public Contact addContact(){
        String fname = firstNameDialog.getText();
        String lname = lastNameDialog.getText();
        String phone = phoneDialog.getText();
        String notes = notesDialog.getText();

        Contact newContact = new Contact(fname,lname,phone,notes);
        return newContact;

    }


}
