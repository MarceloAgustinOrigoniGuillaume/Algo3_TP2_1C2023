package edu.fiuba.algo3.modelo.moduloLector;

import org.json.simple.JSONObject;
import java.util.Map;

public class ConvertidorOleada implements Convertidor {

    private String turno;
    private Map<String, Integer> aInstanciar;

    public ConvertidorOleada(String turno, Map<String,Integer> aInstanciar) {
        this.turno = turno;
        this.aInstanciar = aInstanciar;
    }


    public Object obtener(){
        return aInstanciar;// instanciar Oleada
    }
}
