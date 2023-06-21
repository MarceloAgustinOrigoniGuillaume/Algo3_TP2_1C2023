package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.Resources;
import edu.fiuba.algo3.Ventana;
import edu.fiuba.algo3.controladores.ControladorConstruccion;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;


public class MenuConstruir extends HBox {

    public MenuConstruir(Ventana ventana){
        super();
        init(ventana);
    }
    private void init(Ventana ventana) {

        Parent view = Resources.getVista("menu_construir");
        if(view == null){
        Logger.Log("ERROR LOADING ESTRUCTURAS ... view was 'estructuras' null");
        return;
        }

        getChildren().add(view);

        Button button  = (Button) view.lookup("#buttonTorreBlanca");
        button.setOnAction( (ActionEvent event)->{

        new ControladorConstruccion().seleccionarConstruccion("TorreBlanca");
        });

        Button button2  = (Button) view.lookup("#buttonTorrePlateada");
        button.setOnAction( (ActionEvent event)->{
            new ControladorConstruccion().seleccionarConstruccion("TorrePlateada");
        });

        Button button3  = (Button) view.lookup("#buttonTrampa");
        button.setOnAction( (ActionEvent event)->{
            new ControladorConstruccion().seleccionarConstruccion("Trampa");
        });

    }
    public Parent obtener(){
        return this;
    }
}
