package edu.fiuba.algo3.vistas.celda;

import javafx.scene.control.Label;
import edu.fiuba.algo3.Logger;
import javafx.scene.layout.HBox;
import edu.fiuba.algo3.Resources;
import javafx.fxml.FXML;

public class EnemigosCeldaView extends HBox{

	@FXML private Label labelEnemigos;
	
	public EnemigosCeldaView(){
		super();

		Resources.loadVista("enemigos_celda", this, this);
	}

	public void initialize(){
		setVisible(false);		
		//Logger.info("INITIALIZED WAS NULL ? ", (labelEnemigos == null));
	}

    public void updateEnemigos(int cantidadEnemigos){
    	//Logger.info("CHANGING ENEMIGOS",cantidadEnemigos);
        labelEnemigos.setText(String.valueOf(cantidadEnemigos));
        setVisible(cantidadEnemigos != 0);
    }

}