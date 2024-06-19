package io.jp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Parent parent = new FXMLLoader(getClass().getResource("gui/MainView.fxml")).load();
        Scene mainScene = new Scene(parent);
        stage.setScene(mainScene);
        stage.setTitle("Title");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}