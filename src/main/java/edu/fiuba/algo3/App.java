package edu.fiuba.algo3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import javafx.scene.layout.FlowPane;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;

import edu.fiuba.algo3.vistas.MenuInicio;
//import edu.fiuba.algo3.vistas.Ventana;


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
            //Ventana scene = new Ventana(INITIAL_WIDTH, INITIAL_HEIGHT);//new Scene(new MenuInicio(), );
            Parent vista = Resources.getVista("inicioVistas");//FXMLLoader.load(getClass().getResource("/vistas/inicioVistas.fxml"));//Resources.getVista("inicioVistas");
            if(vista == null){
                //Logger.Log(">>NO PUDO INICIAR LA APP");
                throw  new Exception("Vista instanciada fue null");
            }
            Scene scene = new Scene( vista,INITIAL_WIDTH, INITIAL_HEIGHT);

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