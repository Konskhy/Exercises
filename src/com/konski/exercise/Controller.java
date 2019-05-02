package com.konski.exercise;

import com.konski.exercise.datamodel.TodoData;
import com.konski.exercise.datamodel.TodoItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.util.Callback;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class Controller {
//    private List<TodoItem> todoItems;
    @FXML
    private ListView<TodoItem> todoListView;
    @FXML
    private TextArea detailsTextArea;
    @FXML
    private Label deadline;
    @FXML
    private BorderPane mainBorderPane;

    public void initialize(){
//        TodoItem item1 = new TodoItem("Resupply weed", "Ring neighbor to arrange some weed, we're running low",
//                LocalDate.of(2019,4,30));
//        TodoItem item2 = new TodoItem("Java Project", "Finish the project, cleanup, annotations, documentation",
//                LocalDate.of(2019,5,5));
//        TodoItem item3 = new TodoItem("Laundry", "Do the bleedin laundry, don't forget the fencing gear",
//                LocalDate.of(2019,5,1));
//        TodoItem item4 = new TodoItem("Ring mom", "Check what's the story with first communion arrangements",
//                LocalDate.of(2019,5,15));
//        TodoItem item5 = new TodoItem("Communion", "Travel to Poland for godsdaughter first communion",
//                LocalDate.of(2019,5,25));
//
//        todoItems = new ArrayList<>();
//        todoItems.add(item1);
//        todoItems.add(item2);
//        todoItems.add(item3);
//        todoItems.add(item4);
//        todoItems.add(item5);
//        TodoData.getInstance().setTodoItems(todoItems);

            todoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TodoItem>() {
                @Override
                public void changed(ObservableValue<? extends TodoItem> observableValue, TodoItem todoItem, TodoItem newItem) {
                    if (newItem != null) {
                        TodoItem item = todoListView.getSelectionModel().getSelectedItem();
                            detailsTextArea.setText(item.getDetails());
                            DateTimeFormatter df = DateTimeFormatter.ofPattern("MMMM d, yyyy");
                            deadline.setText(item.getDeadline().format(df));
                    }
                }
            });
        todoListView.setItems(TodoData.getInstance().getTodoItems());
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        todoListView.getSelectionModel().selectFirst();
        todoListView.setCellFactory(new Callback<ListView<TodoItem>, ListCell<TodoItem>>() {
            @Override
            public ListCell<TodoItem> call(ListView<TodoItem> todoItemListView) {
                ListCell<TodoItem> cell = new ListCell<>() {
                    @Override
                    protected void updateItem(TodoItem item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) setText(null);
                        else setText(item.getDescription());
                        if (item.getDeadline().equals(LocalDate.now())) {
                            setTextFill(Color.RED);
                        }
//                        else if (item.getDeadline().compareTo((LocalDate.now().plusDays(3)))<0)
//                            setTextFill((Color.ORANGE));
                    }
                };
                return cell;
            }
        });

    }
    @FXML
    public void showNewItemDialog(){
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Add new item");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("todoItemDialog.fxml"));
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
            TodoItem newItem = controller.processResults();
//            todoListView.getItems().setAll(TodoData.getInstance().getTodoItems());
            todoListView.getSelectionModel().select(newItem);
            System.out.println("OK button pressed");
        }else System.out.println("CANCEL button pressed");
    }
    @FXML
    public void handleListView(){
        TodoItem item = todoListView.getSelectionModel().getSelectedItem();
        detailsTextArea.setText(item.getDetails());
        deadline.setText(item.getDeadline().toString());
    }


}
