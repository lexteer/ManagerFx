package org.example.managerfx.task;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Category {
    private final StringProperty _name = new SimpleStringProperty();

    public Category(String name) {
        _name.set(name);
    }

    // properties for binding
    public StringProperty nameProperty() { return _name; }

    // getters/setters
    public String getName() { return _name.get(); }
    public void setName(String n) { _name.set(n); }

    @Override
    public String toString() { return getName(); }
}
