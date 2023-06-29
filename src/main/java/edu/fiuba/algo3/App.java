package edu.fiuba.algo3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    public static final int INITIAL_WIDTH = 630;
    public static final int INITIAL_HEIGHT = 780;

    @Override
    public void start(Stage stage) {
//        try {
//            Parent root = FXMLLoader.load(getClass().getResource("/vistas/menu_inicio.fxml"));
//            Scene scene = new Scene(root);
//            stage.setScene(scene);
//            stage.setResizable(false);
//            Image icon = Resources.getImg("icon.png");
//            stage.getIcons().add(icon);
//            stage.setTitle("AlgoDefence");
//            stage.show();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        try{
            Ventana scene = new Ventana(INITIAL_WIDTH, INITIAL_HEIGHT);//new Scene(new MenuInicio(), );

            stage.getIcons().add(Resources.getImg("icon.png"));
            stage.setTitle("AlgoDefence");
            //stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        } catch(Exception ex){
            Logger.err("At start the app... ",ex);
            ex.printStackTrace();
            stage.close();
        }
    }

    public static void main(String[] args) {
        launch();
    }

}