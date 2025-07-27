package org.example.managerfx.task;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Priority {
    private final StringProperty _name = new SimpleStringProperty();
    private final IntegerProperty _level = new SimpleIntegerProperty();

    public Priority(String name, int level) {
        _name.set(name);
        _level.set(level);
    }

    // properties for binding
    public StringProperty nameProperty() { return _name; }
    public IntegerProperty levelProperty() { return _level; }

    // getters/setters
    public String getName() { return _name.get(); }
    public void setName(String n) { _name.set(n); }
    public int getLevel() { return _level.get(); }
    public void setLevel(int l) { _level.set(l); }

    @Override
    public String toString() { return getName(); }
}
