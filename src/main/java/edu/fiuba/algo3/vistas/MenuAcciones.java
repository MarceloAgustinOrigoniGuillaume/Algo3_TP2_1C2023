package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.Resources;
import edu.fiuba.algo3.Ventana;
import edu.fiuba.algo3.controladores.ControladorConstruccion;
import edu.fiuba.algo3.controladores.ControladorJuego;
import edu.fiuba.algo3.Logger;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;
import javafx.scene.Parent;

public class MenuAcciones extends AnchorPane {

    private Label turno;
	public MenuAcciones(ViewJugador jugador,Ventana ventana){
        super();
        init(jugador, ventana);
	}

	private void init(ViewJugador jugador, Ventana ventana){

        Logger.Log("Logging bfr load menu_acciones");
        Parent view = Resources.getVista("menu_acciones");
        if(view == null){
            Logger.Log("ERROR LOADING MENU CONSTRUCCIONES ... view was 'menu_construcciones' null");
            return;
        }

        getChildren().add(jugador);
        getChildren().add(view);

        this.setLeftAnchor(jugador, 0.0);
        this.setRightAnchor(view, 0.0);
        this.setTopAnchor(view, 0.0);
        this.setBottomAnchor(view, 0.0);
        Logger.Log("After everything");

        this.turno = (Label) view.lookup("#TurnoActual");

        Button buttonConstruir  = (Button) view.lookup("#buttonConstruir");
        Button buttonPasarTurno  = (Button) view.lookup("#buttonPasarTurno");
        Button buttonAbandonar  = (Button) view.lookup("#buttonAbandonar");



        buttonConstruir.setOnAction( (ActionEvent event)->{
            new ControladorJuego().mostrarOpciones(ventana);
        });

        buttonAbandonar.setOnAction( (ActionEvent event)->{
            new ControladorJuego().terminarJuego(ventana);
        });

        buttonPasarTurno.setOnAction((ActionEvent event)->{
            Logger.Log("------>Pasar turno....");
            new ControladorJuego().pasarTurno(ventana);
        });



    }

    public void setTurno(String turno){
        this.turno.setText("Turno: "+ turno);
    }

    public Parent obtener(){
        return this;
    }
}