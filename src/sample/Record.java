package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Record {
    private final StringProperty nameProperty;

    public Record(String name) {
        nameProperty = new SimpleStringProperty(name);
    }

    public String getName() {
        return nameProperty.get();
    }

    public StringProperty getNameProperty() {
        return nameProperty;
    }
}
