package com.konski.exercise.datamodel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

public class TodoData {
    private static TodoData instance = new TodoData();
    private static String filename = "todoData.txt";
    private ObservableList<TodoItem> todoItems;
    private DateTimeFormatter formatter;

    private TodoData() {
        formatter=DateTimeFormatter.ofPattern("MMMM d, yyyy");
    }

    public static TodoData getInstance(){
        return instance;
    }

    public ObservableList<TodoItem> getTodoItems() {
        return todoItems;
    }
    public void addTodoItem(TodoItem item){
        todoItems.add(item);
    }

//    public void setTodoItems(List<TodoItem> todoItems) {
//        this.todoItems = todoItems;
//    }

    public void loadTodoItems() throws IOException{
        todoItems = FXCollections.observableArrayList();
        Path path = Paths.get(filename);
        BufferedReader br = Files.newBufferedReader(path);
        String input;

        try{
            while((input=br.readLine())!=null){
                String [] itemPieces = input.split("\t");
                String shortDescription = itemPieces[0];
                String longDescription = itemPieces[1];
                String dateString = itemPieces[2];
                LocalDate date = LocalDate.parse(dateString,formatter);
                TodoItem item = new TodoItem(shortDescription,longDescription,date);
                todoItems.add(item);
            }
        } finally{
            if (br!=null)
                br.close();
        }
    }

    public void saveTodoItems() throws IOException{
        Path path = Paths.get(filename);
        BufferedWriter bw = Files.newBufferedWriter(path);
        try{
            Iterator<TodoItem> iter = todoItems.iterator();
            while(iter.hasNext()){
                TodoItem item = iter.next();
                bw.write(String.format("%s\t%s\t%s",item.getDescription(),item.getDetails(),item.getDeadline().format(formatter)));
                bw.newLine();
            }
        }finally{
            if (bw!=null)
                bw.close();
        }
    }
    public void deleteItem(TodoItem item){
        todoItems.remove(item);
    }
}
