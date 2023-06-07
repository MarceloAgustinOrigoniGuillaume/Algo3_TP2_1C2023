package edu.fiuba.algo3.modelo.moduloLector;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



import java.util.Iterator;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

public class LectorEnemigo  implements Lector{
    private JSONArray turnos;
    private Iterator iterador;
    public LectorEnemigo(String filePath) throws IOException, ParseException {
        JSONArray turnos = (JSONArray) new JSONParser().parse(new FileReader(filePath));
        iterador = turnos.iterator();

    }

    @Override
    public Convertidor siguienteElemento() {

    	JSONObject obj = (JSONObject)iterador.next();

    	JSONObject enemigos = (JSONObject) obj.get("enemigos");
    	Hashtable<String,Integer> oleada = new Hashtable<String,Integer>();
    	
    	Iterator keys = enemigos.keySet().iterator();
    	String key;
    	while(keys.hasNext()){
    		key = (keys.next()).toString();
    		String value = enemigos.get(key).toString();
    		oleada.put(key, (Integer.parseInt((value))) );
    	}

        return new ConvertidorOleada(obj.get("turno").toString(), oleada);//new ConvertidorEnemigo((JSONObject) iterador.next());
    }

    @Override
    public boolean haySiguiente(){
        return iterador.hasNext();
    }

}
