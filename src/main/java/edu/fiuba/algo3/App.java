package edu.fiuba.algo3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    public static final int INITIAL_WIDTH = 1124;
    public static final int INITIAL_HEIGHT = 600;


    public static void run(String[] args) {
        launch();
    }

    /*
    @Override
    public void start(Stage stage) {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        var scene = new Scene(new StackPane(label), 640, 480);
        stage.se
        stage.setScene(scene);

        StackPane layout = new StackPane();
        label.setText("Texto de la etiqueta");

        //layout.getChildren().add(label);

        Button button = new Button();
        button.setText("Texto del botón");
        layout.getChildren().add(button);

        stage.show();
    }

     */

    public static void main(String[] args) {
        launch();
    }


    @Override
    public void start(Stage stage) throws Exception {

    }
}