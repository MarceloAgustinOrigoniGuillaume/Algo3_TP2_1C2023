package edu.fiuba.algo3.modelo.Lector;

import java.util.Iterator;
import org.json.simple.JSONArray;

import edu.fiuba.algo3.modelo.excepciones.mapa.*;

public class ConvertidorFila{

	private int width;
	private int columnaActual;
	private Iterator iteradorFila;
	private int row;
	
	public ConvertidorFila(int width,int row, JSONArray fila) throws Exception {
		this.width = width;
		this.row = row;
        int columnas = 0;
        if(fila != null){
        	columnas = fila.size();
        }

        if(columnas != width){
        	throw new TamanioInvalido("Esperaba '"+String.valueOf(width)+"' columnas obtuvo "+String.valueOf(columnas)+"'");
        }
        iteradorFila = fila.iterator();
        columnaActual = 1;

	}
	public Convertidor obtener(){
		if(!hayMas()){
			return null;
		}
		columnaActual+=1;
		return new ConvertidorParcela(columnaActual-1,row,iteradorFila.next().toString());
	}

	public boolean hayMas(){
		return iteradorFila.hasNext();
	}
}