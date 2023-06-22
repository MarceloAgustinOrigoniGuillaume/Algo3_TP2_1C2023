package edu.fiuba.algo3.vistas;



import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.controladores.ControladorMapa;
import edu.fiuba.algo3.Logger;


import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.Node;
import javafx.scene.Parent;

import javafx.event.ActionEvent;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.collections.ObservableList;


public class ViewMapa extends HBox implements ControladorMapa.TileResources{

    public static int TILE_SIZE = 41;

	public ViewMapa(int columns, int rows,ControladorMapa.TileResources resource){
        super();
        init(columns,rows,resource);
	}


    private ViewCelda findNode(int x, int y){

        ObservableList<Node> columnas = getChildren();
        ObservableList<Node> fila;
        ViewCelda celda;
        int ind_columna = 0;
        int ind_fila = 0;

        while(ind_columna < columnas.size()){
            fila = ((VBox)columnas.get(ind_columna)).getChildren();

            celda = (ViewCelda)fila.get(0);
            if(celda.getCoordenada().x() != x){
                // no era esta columna
                ind_columna+=1;
                continue;
            }

            if(celda.getCoordenada().y() == y){
                return celda;
            }

            ind_fila = 1;
            while(ind_fila < fila.size()){
                celda = (ViewCelda)fila.get(ind_fila);
                if(celda.getCoordenada().y() == y){
                    return celda;
                }

                ind_fila+=1;
            }

            ind_columna+=1;
        }

        Logger.Log("NO SE ENCONTRO LA POSICION "+String.valueOf(x)+","+String.valueOf(y));
        return null;
    }


    public ViewCelda tileAt(int x, int y){
        return findNode(x,y);
    }





	private void init(int columns, int rows,ControladorMapa.TileResources resource){
        VBox column;
        Label lbl;
        String tipo;
        setSpacing(1);
        setBackground(new Background(new BackgroundFill(Color.BLACK,null,null)));
        for(int x = 1; x<=columns;x++){
            column = new VBox();
            column.setSpacing(1);
            //column.setBackground(new Background(new BackgroundFill(Color.BLACK,null,null)));
            for(int y = rows; y>0;y--){
                column.getChildren().add(resource.tileAt(x,y));
            }
            getChildren().add(column);
        }
	}	
}