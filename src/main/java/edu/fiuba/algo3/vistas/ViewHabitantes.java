package edu.fiuba.algo3.vistas;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.Parent;
import javafx.geometry.Pos;

import edu.fiuba.algo3.modelo.descriptors.CeldaDescriptor;
import edu.fiuba.algo3.modelo.descriptors.DefensaDescriptor;
import edu.fiuba.algo3.modelo.descriptors.EnemigosDescriptor;
import edu.fiuba.algo3.modelo.descriptors.EnemigoDescriptor;
import edu.fiuba.algo3.Ventana;
import edu.fiuba.algo3.Resources;

public class ViewHabitantes extends VBox {


    public ViewHabitantes(Ventana ventana,CeldaDescriptor descript){
        super();

        init(ventana, descript);
    }



    private void loadConstruccionView(VBox layoutConstrucciones, DefensaDescriptor defensa){


    	//layoutConstrucciones.getChildren().add(new Label("Construccion actual"));

    	layoutConstrucciones.getChildren().add(new Label(defensa.tipo()));
    	if(defensa.existe()){
    		layoutConstrucciones.getChildren().add(new Label("estado: "+defensa.estado()));
    	}
    }

    private void loadEnemigosView(VBox layoutEnemigos, EnemigosDescriptor enemigos){
    	//layoutEnemigos.getChildren().add(new Label("Enemigos"));
    	if(enemigos.getEnemigos().size() == 0){
    		layoutEnemigos.getChildren().add(new Label("Sin enemigos en la celda"));
    		return;
    	}

    	for(EnemigoDescriptor enemigo: enemigos.getEnemigos()){
	    	layoutEnemigos.getChildren().add(new Label(enemigo.tipo()+":"+enemigo.nombre()+"::"+enemigo.infoStats()));
    	}
    }


    private void init(Ventana ventana, CeldaDescriptor descript){
		setAlignment(Pos.CENTER);
		Parent view = Resources.getVista("popup_habitantes");
		if(view == null){
			getChildren().add(new Label("ERROR view was null"));
			return;
		}
		getChildren().add(view);


		Label textoTipo  = (Label) view.lookup("#tipoCelda");

		textoTipo.setText(descript.tipo());

		VBox contenedor  = (VBox) view.lookup("#contenedorDefensa");

		loadConstruccionView(contenedor, descript.defensa());
		contenedor  = (VBox) view.lookup("#contenedorEnemigos");

		loadEnemigosView(contenedor, descript.enemigos());

    }
}