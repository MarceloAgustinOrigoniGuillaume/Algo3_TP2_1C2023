package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.Resources;
import edu.fiuba.algo3.Ventana;
import edu.fiuba.algo3.controladores.ControladorConstruccion;
import edu.fiuba.algo3.Logger;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;
import javafx.scene.Parent;


public class MenuConstrucciones extends HBox {

	public MenuConstrucciones(Ventana ventana){
        super();
        init(ventana);
	}

	private void init(Ventana ventana){

        Parent view = Resources.getVista("menu_construcciones");
        if(view == null){
            Logger.Log("ERROR LOADING MENU CONSTRUCCIONES ... view was 'menu_construcciones' null");
            return;
        }
        getChildren().add(view);

        Button button  = (Button) view.lookup("#buttonConstruir");
        button.setOnAction( (ActionEvent event)->{
            new edu.fiuba.algo3.controladores.ControladorJuego().mostrarOpciones(ventana);
        });
    }

    public Parent obtener(){
        return this;
    }
}