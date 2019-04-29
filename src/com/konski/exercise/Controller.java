package com.konski.exercise;

import com.konski.exercise.datamodel.TodoItem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<TodoItem> todoItems;
    @FXML
    private ListView<TodoItem> todoListView;

    public void initialize(){
        TodoItem item1 = new TodoItem("Resupply weed", "Ring neighbor to arrange some weed, we're running low",
                LocalDate.of(2019,4,30));
        TodoItem item2 = new TodoItem("Java Project", "Finish the project, cleanup, annotations, documentation",
                LocalDate.of(2019,5,5));
        TodoItem item3 = new TodoItem("Laundry", "Do the bleedin laundry, don't forget the fencing gear",
                LocalDate.of(2019,5,1));
        TodoItem item4 = new TodoItem("Ring mom", "Check what's the story with first communion arrangements",
                LocalDate.of(2019,5,15));
        TodoItem item5 = new TodoItem("Communion", "Travel to Poland for godsdaughter first communion",
                LocalDate.of(2019,5,25));

        todoItems = new ArrayList<>();
        todoItems.add(item1);
        todoItems.add(item2);
        todoItems.add(item3);
        todoItems.add(item4);
        todoItems.add(item5);

        todoListView.getItems().setAll(todoItems);
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }
    @FXML
    public void handleListView(ActionEvent e){
        TodoItem item = todoListView.getSelectionModel().getSelectedItem();
    }

}
