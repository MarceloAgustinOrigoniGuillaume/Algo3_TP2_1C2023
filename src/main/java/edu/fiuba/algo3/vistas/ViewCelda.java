package edu.fiuba.algo3.vistas;



import edu.fiuba.algo3.Logger;

import edu.fiuba.algo3.Ventana;

import edu.fiuba.algo3.modelo.Celdas.Coordenada;
import edu.fiuba.algo3.modelo.Defensas.Defensa;
import edu.fiuba.algo3.modelo.descriptors.DefensaDescriptor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import edu.fiuba.algo3.controladores.ControladorHabitantes;


import javafx.scene.layout.StackPane;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

import javafx.event.ActionEvent;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Parent;

import javafx.scene.image.ImageView;
import edu.fiuba.algo3.Resources;
import javafx.scene.input.MouseEvent;

import java.io.File;

public class ViewCelda extends StackPane {

    public static int TILE_SIZE = 41;
    private OnClickListener clickListener;
    private Coordenada coordenada;
    private ImageView imagen;
    private Label textoEnemigos;
    private String url_celda;
    
	public ViewCelda(String url_imagen, int cantidadEnemigos, Coordenada coordenada){
        super();
        this.coordenada = coordenada;
        init(url_imagen, cantidadEnemigos);
	}

    public void setOnClick(OnClickListener clickListener){
        this.clickListener = clickListener;
    }

    private void handleClick(MouseEvent event){
        Logger.Log("CLICKED ON TILE....");

        if(clickListener == null || !this.clickListener.clickEnCelda(this)){
            Logger.Log("SHOWING HABITANTES!>>");


            new ControladorHabitantes().mostrarHabitantes(((Ventana)(getScene())), coordenada);
        }
        event.consume();
    }

    public void updateImage(String url_imagen){
        //Logger.Log("UPDATING VIEW CELDA WITH NEW URL "+url_imagen);
        if(url_celda != url_imagen){
            url_celda = url_imagen;
            imagen.setImage(Resources.getImg(url_imagen, TILE_SIZE, TILE_SIZE));
        }
    }

    public void updateEnemigos(int cantidadEnemigos){
        Logger.Log("------>UPDATING  :: "+coordenada.toString()+" VIEW CELDA WITH ENEMIES"+String.valueOf(cantidadEnemigos));
        textoEnemigos.setText(String.valueOf(cantidadEnemigos));
        textoEnemigos.setVisible(cantidadEnemigos != 0);
    }


    public void updateView(String url_imagen, int cantidadEnemigos){

        updateImage(url_imagen);
        updateEnemigos(cantidadEnemigos);
    }

	private void init(String url_imagen, int cantidadEnemigos){


        Parent view = Resources.getVista("celda_mapa");
        if(view == null){
            getChildren().add(new Label("ERROR view was null"));
            return;
        }
        getChildren().add(view);


        this.imagen  = (ImageView) view.lookup("#imagenTerreno");
        this.textoEnemigos  = (Label) view.lookup("#textoEnemigos");

        updateView(url_imagen,cantidadEnemigos);

        imagen.addEventHandler(MouseEvent.MOUSE_CLICKED, this::handleClick);
        
	}

    public Coordenada getCoordenada(){
       return this.coordenada;
    }
}