package edu.fiuba.algo3.vistas;



import edu.fiuba.algo3.Logger;


import edu.fiuba.algo3.modelo.Celdas.Coordenada;
import edu.fiuba.algo3.modelo.Defensas.Defensa;
import edu.fiuba.algo3.modelo.descriptors.DefensaDescriptor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


import javafx.scene.layout.StackPane;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

import javafx.event.ActionEvent;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

import javafx.scene.image.ImageView;
import edu.fiuba.algo3.Resources;
import javafx.scene.input.MouseEvent;

import java.io.File;

public class ViewCelda extends StackPane {

    public static int TILE_SIZE = 41;
    private OnClickListener clickListener;
    private Coordenada coordenada;
    private ImageView imaTorre;
    
	public ViewCelda(String tipo, int cantidadEnemigos, Coordenada coordenada){
        super();
        init(tipo, cantidadEnemigos);
        this.coordenada = coordenada;
	}

    public void setOnClick(OnClickListener clickListener){
        this.clickListener = clickListener;
    }

    private void handleClick(MouseEvent event){
        Logger.Log("CLICKED ON TILE....");

        if(clickListener != null){
            this.clickListener.clickEnCelda(this);
        }
        event.consume();
    }

	private void init(String tipo, int cantidadEnemigos){

        this.imaTorre = new ImageView(Resources.getImg("terrenos/"+tipo+".jpg", TILE_SIZE, TILE_SIZE));

        imaTorre.addEventHandler(MouseEvent.MOUSE_CLICKED, this::handleClick);
        getChildren().add(imaTorre);

	}

    public Coordenada getCoordenada(){
       return this.coordenada;
    }

    public void ponerDefensa(DefensaDescriptor defensa){

        imaTorre.setImage(Resources.getImg("torreeiffel.PNG", TILE_SIZE, TILE_SIZE));
    }
}