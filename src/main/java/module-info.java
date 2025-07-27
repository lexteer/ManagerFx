module org.example.managerfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens org.example.managerfx to javafx.fxml;
    exports org.example.managerfx;
    exports org.example.managerfx.controllers;
    opens org.example.managerfx.controllers to javafx.fxml;
    exports org.example.managerfx.task;
    opens org.example.managerfx.task to javafx.fxml;
}