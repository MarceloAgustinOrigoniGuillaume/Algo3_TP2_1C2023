package edu.fiuba.algo3.vistas;



import edu.fiuba.algo3.Logger;


import edu.fiuba.algo3.modelo.Celdas.Coordenada;

import javafx.scene.layout.VBox;
import javafx.scene.Parent;

import javafx.scene.control.Label;

import javafx.scene.image.ImageView;

import edu.fiuba.algo3.Resources;
import javafx.scene.image.Image;

public class ViewCelda extends VBox {

    public static int TILE_SIZE = 41;
    private Coordenada coordenada;
    private ImageView imagen;
    private Label textoEnemigos;

    private String url_celda;
    private String tipo_celda;
    
    public ViewCelda(String tipo, String url_imagen,int cantidadEnemigos,Coordenada coordenada){
        super();
        this.coordenada = coordenada;
        this.url_celda = url_imagen;
        this.tipo_celda = tipo;
        init(url_imagen, cantidadEnemigos);
    }

    public void resetImage(){
        updateImage(url_celda);
    }

    public String getTipo(){
        return tipo_celda;
    }
    public void setImage(Image img){
        imagen.setImage(img);
    }

    private Image getImage(String url_imagen){
        return Resources.getImg(url_imagen, TILE_SIZE, TILE_SIZE);
    }
    public Image loadImageFor(String url_imagen){
        Image img = getImage(url_imagen);
        setImage(img);
        return img;
    }
    public void updateImage(String url_imagen){
        //Logger.Log("UPDATING VIEW CELDA WITH NEW URL "+url_imagen);
        this.url_celda = url_imagen;
        setImage(getImage(url_imagen));
    }

    public void updateEnemigos(int cantidadEnemigos){
        //Logger.Log("------>UPDATING CELDA :: "+coordenada.toString()+" VIEW CELDA WITH ENEMIES"+String.valueOf(cantidadEnemigos));
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
    }

    public Coordenada getCoordenada(){
       return this.coordenada;
    }
}