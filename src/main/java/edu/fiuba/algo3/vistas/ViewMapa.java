package edu.fiuba.algo3.vistas;



import edu.fiuba.algo3.controladores.ControladorMapa;
import edu.fiuba.algo3.Logger;



import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

import javafx.scene.Node;
import javafx.scene.Parent;

import javafx.collections.ObservableList;
import edu.fiuba.algo3.vistas.celda.CeldaView;


public class ViewMapa extends HBox implements ControladorMapa.TileResources{
    public void loadFromResources(int columns, int rows, ControladorMapa.TileResources resource){
        getChildren().clear();
        
        VBox column;
        String tipo;
        
        for(int x = 1; x<=columns;x++){
            column = new VBox();
            column.setSpacing(1);
            for(int y = rows; y>0;y--){
                column.getChildren().add(resource.tileAt(x,y));
            }
            getChildren().add(column);
        }


    }

    private CeldaView findNode(int x, int y){
        Logger.dbg("Se actualizo la view: ", String.valueOf(x)+","+String.valueOf(y));
        ObservableList<Node> columnas = getChildren();
        ObservableList<Node> fila;
        CeldaView celda;
        int ind_columna = 0;
        int ind_fila = 0;

        while(ind_columna < columnas.size()){
            fila = ((VBox)columnas.get(ind_columna)).getChildren();

            celda = (CeldaView)fila.get(0);
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
                celda = (CeldaView)fila.get(ind_fila);
                if(celda.getCoordenada().y() == y){
                    return celda;
                }

                ind_fila+=1;
            }

            ind_columna+=1;
        }

        Logger.err("NO SE ENCONTRO LA POSICION",String.valueOf(x),",",String.valueOf(y));
        return null;
    }


    public CeldaView tileAt(int x, int y){
        return findNode(x,y);
    }
}