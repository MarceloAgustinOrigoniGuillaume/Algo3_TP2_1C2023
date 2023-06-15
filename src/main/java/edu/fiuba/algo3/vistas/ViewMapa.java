package edu.fiuba.algo3.vistas;



import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.Logger;


import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

import javafx.event.ActionEvent;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.Insets;



public class ViewMapa extends HBox {

    public static int TILE_SIZE = 41;
    public interface TileResources{
        String tileAt(int x, int y);
    }
	public ViewMapa(int columns, int rows,TileResources resource){
        super();
        init(columns,rows,resource);
	}

	private void init(int columns, int rows,TileResources resource){
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

                tipo = resource.tileAt(x,y);
                lbl = new Label("");
                //lbl.setPadding(new Insets(10,10,10,10));
                lbl.setMinWidth(TILE_SIZE);
                lbl.setMinHeight(TILE_SIZE);
                
                if ("Tierra".equals(tipo)){
                    lbl.setBackground(new Background(new BackgroundFill(Color.DARKGOLDENROD,null,null)));
                } else if("Pasarela".equals(tipo)){
                    lbl.setBackground(new Background(new BackgroundFill(Color.DARKGRAY,null,null)));

                } else{
                    lbl.setBackground(new Background(new BackgroundFill(Color.AQUA,null,null)));
                }

                column.getChildren().add(lbl);
            }

            getChildren().add(column);

        }
	}	
}