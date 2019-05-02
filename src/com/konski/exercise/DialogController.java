package com.konski.exercise;

import com.konski.exercise.datamodel.TodoData;
import com.konski.exercise.datamodel.TodoItem;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class DialogController {
    @FXML
    private TextField shortDescription;
    @FXML
    private TextArea longDescriptionArea;
    @FXML
    private DatePicker deadlinePicker;

    public TodoItem processResults(){
        String shortDesc = shortDescription.getText().trim();
        String longDesc = longDescriptionArea.getText().trim();
        LocalDate date = deadlinePicker.getValue();
        TodoItem newItem = new TodoItem(shortDesc,longDesc,date);
        TodoData.getInstance().addTodoItem(newItem);
        return newItem;
    }
}
