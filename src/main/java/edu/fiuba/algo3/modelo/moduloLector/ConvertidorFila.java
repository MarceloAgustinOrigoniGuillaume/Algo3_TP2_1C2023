package edu.fiuba.algo3.modelo.moduloLector;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.util.Iterator;
import org.json.simple.JSONArray;
import java.util.ArrayList;


public class ConvertidorFila{

	private int width;
	private int columnaActual;
	private Iterator iteradorFila;
	private int row;
	
	public ConvertidorFila(int width,int row, JSONArray fila){
		this.width = width;
		this.row = row;
        int columnas = 0;
        if(fila != null){
        	columnas = fila.size();
        }

        if(columnas != width){
        	//throw new ParseException("Esperaba '"+String.valueOf(width)+"' columnas obtuvo "+String.valueOf(columnas)+"'");
            System.out.println(">>Esperaba '"+String.valueOf(width)+"' columnas obtuvo "+String.valueOf(columnas)+"'");
            iteradorFila = null;
            return;
        }

        iteradorFila = fila.iterator();
        columnaActual = 1;

	}
	public Convertidor obtener(){
		/*
		ArrayList<Object> fila = new ArrayList<>();

		while (iteradorFila.hasNext()){
			fila.add(new ConvertidorMapa(columnaActual,row,iteradorFila.next()))
			columnaActual+=1;
		}
		*/

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