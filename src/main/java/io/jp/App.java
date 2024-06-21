package io.jp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private static Scene mainScene;

    @Override
    public void start(Stage stage) throws IOException {
        ScrollPane scrollPane = new FXMLLoader(getClass().getResource("gui/MainView.fxml")).load();
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);
        mainScene = new Scene(scrollPane);
        stage.setScene(mainScene);
        stage.setTitle("Title");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static Scene getMainScene() {
        return mainScene;
    }

}