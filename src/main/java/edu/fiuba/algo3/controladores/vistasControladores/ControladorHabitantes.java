package edu.fiuba.algo3.controladores.vistasControladores;


import edu.fiuba.algo3.controladores.Controlador;
import javafx.fxml.FXML;

//import edu.fiuba.algo3.vistas.Vista;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import edu.fiuba.algo3.modelo.descriptors.CeldaDescriptor;
import edu.fiuba.algo3.modelo.descriptors.DefensaDescriptor;
import edu.fiuba.algo3.modelo.descriptors.EnemigosDescriptor;
import edu.fiuba.algo3.modelo.descriptors.EnemigoDescriptor;


public class ControladorHabitantes extends Controlador {

	@FXML private Label tipoCelda;
	@FXML private VBox contenedorDefensa;
	@FXML private VBox contenedorEnemigos;

	private CeldaDescriptor description;
	public ControladorHabitantes(CeldaDescriptor description){
		this.description = description;
	}


    private void loadConstruccionView(VBox layoutConstrucciones, DefensaDescriptor defensa){

    	layoutConstrucciones.getChildren().add(new Label(defensa.tipo()));
    	if(defensa.existe()){
    		layoutConstrucciones.getChildren().add(new Label("estado: "+defensa.estado()));
    	}
    }

    private void loadEnemigosView(VBox layoutEnemigos, EnemigosDescriptor enemigos){
    	if(enemigos.getEnemigos().size() == 0){
    		layoutEnemigos.getChildren().add(new Label("Sin enemigos en la celda"));
    		return;
    	}

    	for(EnemigoDescriptor enemigo: enemigos.getEnemigos()){
	    	layoutEnemigos.getChildren().add(new Label(enemigo.tipo()+":"+enemigo.nombre()+"::"+enemigo.infoStats()));
    	}
    }


    public void initialize(){
		tipoCelda.setText(description.tipo());

		loadConstruccionView(contenedorDefensa, description.defensa());
		loadEnemigosView(contenedorEnemigos, description.enemigos());

    }

}