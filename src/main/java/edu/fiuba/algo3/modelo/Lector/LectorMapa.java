package edu.fiuba.algo3.modelo.Lector;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

import org.json.simple.parser.JSONParser;


import java.io.FileReader;
import java.io.IOException;
import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.modelo.excepciones.mapa.*;

public class LectorMapa implements Lector{
    private int width;
    private int height;
    private JSONObject mapa;
    private int filaActual;
    private ConvertidorFila fila;

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public LectorMapa(String filePath, int width, int height) throws Exception {
        JSONObject parsedObject = (JSONObject) new JSONParser().parse(new FileReader(filePath));
        Logger.info("Loading mapa from ",filePath, "with size of ",String.valueOf(width),",",String.valueOf(height));

        mapa = (JSONObject)((parsedObject).get("Mapa")); // Obtenes mapa

        this.width = width;
        this.height = height;

        if(mapa == null){
        	throw new IOException("JSON No tenia el objeto Mapa");
        }
        int maxFila = getMaxFila(mapa);

        if(maxFila != height){
        	throw new TamanioInvalido("Esperaba '"+String.valueOf(height)+"' filas obtuvo "+String.valueOf(maxFila)+"'");
        }
        filaActual = 0;

        replaceFilaNext();
    }
    private int getMaxFila(JSONObject mapa){
    	int i = 0;
    	while(mapa.containsKey(String.valueOf(i+1))){
    		i+=1;
    	}

    	return i;
    }


    private void replaceFilaNext() throws Exception {
        if((filaActual+1) > height){
            fila = null;
        	return;
        }
        filaActual+= 1;
        fila = new ConvertidorFila(width,filaActual,(JSONArray)mapa.get(String.valueOf(filaActual)));
    }


    @Override
    public Convertidor siguienteElemento() throws Exception {
    	if(!haySiguiente()){
    		return null;
    	}
    	if(!fila.hayMas()){
    		replaceFilaNext();
    	}
    	return fila.obtener();
    }

    @Override
    public boolean haySiguiente(){
        return filaActual < height || fila.hayMas();
    }
}
