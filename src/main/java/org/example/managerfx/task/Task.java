package org.example.managerfx.task;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class Task {
    private StringProperty _name = new SimpleStringProperty();
    private StringProperty _description = new SimpleStringProperty();
    private ObjectProperty<Priority> _priority = new SimpleObjectProperty<>();
    private ObjectProperty<LocalDate> _deadLine = new SimpleObjectProperty<>();
    private ObjectProperty<Category> _category = new SimpleObjectProperty<>();

    public Task (String name, String description, Priority prio, LocalDate deadLine, Category category) {
        _name.set(name);
        _description.set(description);
        _priority.set(prio);
        _deadLine.set(deadLine);
        _category.set(category);
    }

    public StringProperty taskNameProperty() { return _name; }
    public StringProperty taskDescriptionProperty() { return _description; }
    public ObjectProperty<LocalDate> taskDeadLineProperty() { return _deadLine; }
    public ObjectProperty<Priority> taskPriorityProperty() { return _priority; }
    public ObjectProperty<Category> taskCategoryProperty() { return _category; }
}
