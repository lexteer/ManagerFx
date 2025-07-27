package org.example.managerfx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.managerfx.controllers.MainController;
import org.example.managerfx.task.Category;
import org.example.managerfx.task.Priority;

import java.io.IOException;

public class Main extends Application{
    // priorities
    public static ObservableList<Priority> priorities = FXCollections.observableArrayList(
            new Priority("Low", 1),
            new Priority("Medium", 2),
            new Priority("High", 3)
    );
    public static Priority low = priorities.getFirst();
    public static Priority medium = priorities.get(1);
    public static Priority high = priorities.get(2);

    // categories
    public static ObservableList<Category> categories = FXCollections.observableArrayList(
            new Category("work"),
            new Category("home"),
            new Category("hobby")
    );
    public static Category work = categories.getFirst();
    public static Category home = categories.get(1);
    public static Category hobby = categories.get(2);



    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/main.fxml"));
        Parent root = loader.load();

        MainController mainController = loader.getController();

        stage.setScene(new Scene(root));
        stage.setTitle("ManagerFx");
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}