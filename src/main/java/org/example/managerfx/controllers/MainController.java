package org.example.managerfx.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.managerfx.task.Category;
import javafx.scene.Parent;
import org.example.managerfx.task.Priority;
import org.example.managerfx.task.Task;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML private TableView<Task> taskTable;
    @FXML private TableColumn<Task,String> nameColumn;
    @FXML private TableColumn<Task, Priority> priorityColumn;
    @FXML private TableColumn<Task,LocalDate> deadlineColumn;
    @FXML private TableColumn<Task, Category> categoryColumn;

    @FXML private Button newTaskBtn;
    @FXML private Button deleteTaskBtn;
    // tasks
    private final static ObservableList<Task> tasks = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        taskTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        nameColumn.setCellValueFactory(c -> c.getValue().taskNameProperty());
        priorityColumn.setCellValueFactory(c -> c.getValue().taskPriorityProperty());
        deadlineColumn.setCellValueFactory(c -> c.getValue().taskDeadLineProperty());
        categoryColumn.setCellValueFactory(c -> c.getValue().taskCategoryProperty());
        taskTable.setItems(tasks);
    }

    public static Task addTask(String name, String description, Priority prio, LocalDate deadLine, Category category) {
        Task task = new Task(name, description, prio, deadLine, category);

        tasks.add(task);

        return task;
    }
    @FXML
    public void deleteTasks(ActionEvent event) {
        ObservableList<Task> seletedItems = taskTable.getSelectionModel().getSelectedItems();
        
        if (seletedItems.isEmpty()) {
            return;
        }
        
        // Create a copy of the deleted tasks for later undo or archive or whatnot
       ObservableList<Task> copiedItems = FXCollections.observableArrayList(seletedItems);
       taskTable.getSelectionModel().clearSelection();
       taskTable.getItems().removeAll(copiedItems);
    }
    @FXML
    public void newTaskInit(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/newTaskForm.fxml"));
            Parent root = loader.load();

            Stage popupStage = new Stage();
            popupStage.setTitle("New Task");
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setScene(new Scene(root));
            popupStage.showAndWait();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

