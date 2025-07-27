package org.example.managerfx.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.managerfx.Main;
import org.example.managerfx.task.Category;
import org.example.managerfx.task.Priority;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class NewTaskController implements Initializable {

    @FXML private TextField taskNameField;
    @FXML private TextArea descriptionField;
    @FXML private DatePicker deadlinePicker;
    @FXML private ComboBox<Priority> prioField;
    @FXML private ComboBox<Category> cateField;

    @FXML
    private void saveTask() {
        String name = taskNameField.getText();
        String description = descriptionField.getText();
        LocalDate deadline = deadlinePicker.getValue();
        Priority prio = prioField.getValue();
        Category cate = cateField.getValue();
        if (name.isEmpty()) {
           return;
        }
        MainController.addTask(name, description, prio, deadline, cate);

        // Close the popup window
        taskNameField.getScene().getWindow().hide();

        ((Stage) taskNameField.getScene().getWindow()).close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        prioField.setItems(Main.priorities);
        cateField.setItems(Main.categories);

    }
}
