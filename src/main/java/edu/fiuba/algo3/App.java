package edu.fiuba.algo3;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {



    public static final int INITIAL_WIDTH = 640;
    public static final int INITIAL_HEIGHT = 640;


    public static void run(String[] args) {
        launch();
    }

    public void setMapScene(){

    }

    @Override
    public void start(Stage stage) {
        try{
            Ventana scene = new Ventana(INITIAL_WIDTH, INITIAL_HEIGHT);//new Scene(new MenuInicio(), );

            stage.setScene(scene);
            stage.show();
        } catch(Exception ex){
            Logger.Log("Error at initing the game... "+ex.toString());
            ex.printStackTrace();
            stage.close();
        }
    }

    public static void main(String[] args) {
        launch();
    }

}