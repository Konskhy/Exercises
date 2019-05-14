package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.Optional;

public class Controller {
    @FXML
    private TableColumn firstNameField;
    @FXML
    private TableColumn lastNameField;
    @FXML
    private TableColumn phoneNumberField;
    @FXML
    private TableColumn notesField;
    @FXML
    private TableView<Contact> tableView;
    @FXML
    private BorderPane mainBorderPane;

    private ContactData data;

    public void initialize(){
        data = new ContactData();
        data.loadContacts();
        tableView.setItems(data.getContacts());
        tableView.getSortOrder().add(lastNameField);
        tableView.sort();


    }
    @FXML
    public void showNewItemDialog(){
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Add new Contact");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("DialogController.fxml"));
        try{
//            Parent root = FXMLLoader.load(getClass().getResource("todoItemDialog.fxml"));
            dialog.getDialogPane().setContent(fxmlLoader.load());
        }catch (IOException e){
            System.out.println("Could't load dialog");
            e.printStackTrace();
            return;
        }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent()&&result.get()==ButtonType.OK){
            DialogController controller = fxmlLoader.getController();
            Contact newContact = controller.addContact();

//            todoListView.getItems().setAll(TodoData.getInstance().getTodoItems());
            data.addContact(newContact);
            data.saveContacts();

            System.out.println("OK button pressed");
        }else System.out.println("CANCEL button pressed");
    }

    public void handleKeyPressed(KeyEvent keyEvent){
        Contact selectedItem = tableView.getSelectionModel().getSelectedItem();
        if (selectedItem!=null){
            if(keyEvent.getCode().equals(KeyCode.DELETE))
                data.deleteContact(selectedItem);
        }
    }

}
