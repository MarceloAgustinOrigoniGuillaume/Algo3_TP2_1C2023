package edu.fiuba.algo3.modelo.Lector;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import edu.fiuba.algo3.modelo.excepciones.enemigos.TurnoFaltante;
import edu.fiuba.algo3.modelo.excepciones.enemigos.EnemigoFaltante;



import java.util.Iterator;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

import edu.fiuba.algo3.Logger;

public class LectorEnemigo  implements Lector{
    private JSONArray turnos;
    private Iterator iterador;
    private int turno_anterior;
    public LectorEnemigo(String filePath) throws IOException, ParseException {

        Logger.info("Loading enemigos from ",filePath);
        JSONArray turnos = (JSONArray) new JSONParser().parse(new FileReader(filePath));
        iterador = turnos.iterator();
        turno_anterior= 0;

    }
    private Hashtable<String,Integer> convertToHash(JSONObject enemigos){
        Hashtable<String,Integer> oleada = new Hashtable<String,Integer>();
        
        Iterator keys = enemigos.keySet().iterator();
        String key;
        while(keys.hasNext()){
            key = (keys.next()).toString();
            String value = enemigos.get(key).toString();
            oleada.put(key, (Integer.parseInt((value))) );
        }
        return oleada;        
    }

    @Override
    public Convertidor siguienteElemento() throws TurnoFaltante,EnemigoFaltante {

    	JSONObject parseadoJson = (JSONObject)iterador.next();

    	Hashtable<String,Integer> oleada = convertToHash((JSONObject) parseadoJson.get("enemigos"));
        String turno = parseadoJson.get("turno").toString();

        if(Integer.parseInt(turno) != 1+turno_anterior){
            throw new TurnoFaltante("No se proporciono los turnos en el orden correcto paso de "+String.valueOf(turno_anterior)+" a "+turno);
        }
        turno_anterior++;
        return new ConvertidorOleada(turno, oleada);//new ConvertidorEnemigo((JSONObject) iterador.next());
    }

    @Override
    public boolean haySiguiente(){
        return iterador.hasNext();
    }

}
