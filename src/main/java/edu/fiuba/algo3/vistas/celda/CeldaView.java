package edu.fiuba.algo3.vistas.celda;


import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
//import javafx.beans.NamedArg;
import edu.fiuba.algo3.Logger;
import javafx.scene.control.Label;


import edu.fiuba.algo3.Resources;
import edu.fiuba.algo3.modelo.Celdas.Coordenada;

public class CeldaView extends StackPane{
    public static final int TILE_SIZE = 41;

	public static final String ARG_X = "posX";
	public static final String ARG_Y = "posY";
	public static final String ARG_TERRENO = "terreno";


	private DefensaCeldaView defensa;
	private EnemigosCeldaView enemigos;

	private Coordenada posicion;
	private String terreno = "";

	public int getPosX(){
		return posicion.x();
	}

	public int getPosY(){
		return posicion.y();
	}

	public void setPosX(int x){
		//Logger.info("SETTING X CELDA TO VIEW ",x);
		posicion.setX(x);
	}

	public void setPosY(int y){
		//Logger.info("SETTING Y CELDA TO VIEW ",y);
		posicion.setY(y);
	}


	public String getTerreno(){
		return terreno;
	}

	public void setTerreno(String terreno){
		//Logger.info("SETTING TERRENO CELDA ",terreno);

		if(terreno != this.terreno){
			setBackground(Resources.getBckImage(Resources.getAssetTerreno(terreno), TILE_SIZE,TILE_SIZE));
		}

		this.terreno = terreno;
	}

	public CeldaView(){
		super();
		posicion = new Coordenada(0,0);

		defensa = new DefensaCeldaView();
		enemigos = new EnemigosCeldaView();

		getChildren().add(defensa);
		getChildren().add(enemigos);
	}

	public CeldaView(int x, int y, String terreno){
		this();

		setMinWidth(TILE_SIZE);
		setMinHeight(TILE_SIZE);
		setTerreno(terreno);
		setPosX(x);
		setPosY(y);

        //Resources.loadVista("defensa_celda", this);		
	}

    public Coordenada getCoordenada(){
       return this.posicion;
    }

    public void updateView(String url_imagen, int cantidadEnemigos){

        defensa.updateDefensa(url_imagen, TILE_SIZE, TILE_SIZE);
        enemigos.updateEnemigos(cantidadEnemigos);
    }



}