package com.konski.exercise;

import com.konski.exercise.datamodel.TodoData;
import com.konski.exercise.datamodel.TodoItem;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.util.Callback;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.Predicate;

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
    @FXML
    private ContextMenu listContextMenu;
    @FXML
    private ToggleButton filterToggleButton;

    private FilteredList<TodoItem> filteredList;

    private Predicate<TodoItem> todaysItems = new Predicate<TodoItem>() {
        @Override
        public boolean test(TodoItem todoItem) {
            return (todoItem.getDeadline().equals(LocalDate.now()));
        }
    };
    private Predicate<TodoItem> allItems = new Predicate<TodoItem>() {
        @Override
        public boolean test(TodoItem todoItem) {
            return true;
        }
    };



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
        listContextMenu = new ContextMenu();
        MenuItem deleteListItem = new MenuItem("Delete");
        deleteListItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                TodoItem item = todoListView.getSelectionModel().getSelectedItem();
                deleteItem(item);
            }
        });
        listContextMenu.getItems().addAll(deleteListItem);


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
        filteredList = new FilteredList<>(TodoData.getInstance().getTodoItems(),allItems);
        SortedList <TodoItem> sortedList = new SortedList<>(filteredList,
                new Comparator<TodoItem>() {
                    @Override
                    public int compare(TodoItem o1, TodoItem o2) {
                        return (o1.getDeadline().compareTo(o2.getDeadline()));
                    }
                });
//        todoListView.setItems(TodoData.getInstance().getTodoItems());
        todoListView.setItems(sortedList);
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        todoListView.getSelectionModel().selectFirst();
        todoListView.setCellFactory(new Callback<>() {
            @Override
            public ListCell<TodoItem> call(ListView<TodoItem> todoItemListView) {

                ListCell<TodoItem> cell = new ListCell<>() {
                    @Override
                    protected void updateItem(TodoItem item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setText(null);
                            setTextFill(Color.BLACK);


                        } else {
                            setText(item.getDescription());

                            if (item.getDeadline().isBefore(LocalDate.now().plusDays(1))) {
                                setTextFill(Color.RED);
                            } else if (item.getDeadline().compareTo((LocalDate.now().plusDays(3))) < 0) {
                                setTextFill((Color.ORANGE));

                            }
                        }
                    }
                };
                cell.emptyProperty().addListener(
                        (obs, wasEmpty, isNowEmpty) -> {
                            if (isNowEmpty) {
                                cell.setContextMenu(null);
                            } else
                                cell.setContextMenu(listContextMenu);
                        }
                );
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
    public void handleKeyPressed(KeyEvent keyEvent){
        TodoItem selectedItem = todoListView.getSelectionModel().getSelectedItem();
        if (selectedItem!=null){
            if(keyEvent.getCode().equals(KeyCode.DELETE))
                deleteItem(selectedItem);
        }
    }

//    @FXML
//    public void handleListView(){
//        TodoItem item = todoListView.getSelectionModel().getSelectedItem();
//        detailsTextArea.setText(item.getDetails());
//        deadline.setText(item.getDeadline().toString());
//    }

    public void handleToggleButton(){
        TodoItem selectedItem = todoListView.getSelectionModel().getSelectedItem();
        if (filterToggleButton.isSelected()){
            filteredList.setPredicate(todaysItems);
            if (filteredList.isEmpty()){
                detailsTextArea.clear();
                deadline.setText("");
            }else if (filteredList.contains(selectedItem)){
                todoListView.getSelectionModel().select(selectedItem);
            } else
                todoListView.getSelectionModel().selectFirst();
        }else
            filteredList.setPredicate(allItems);
        todoListView.getSelectionModel().select(selectedItem);

    }

    private void deleteItem(TodoItem item){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Item");
        alert.setHeaderText("Delete item:" + item.getDescription());
        alert.setContentText("Are You sure?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent()&&result.get()==ButtonType.OK)
            TodoData.getInstance().deleteItem(item);

    }
    @FXML
    public void handleExit(){
        Platform.exit();
    }


}
