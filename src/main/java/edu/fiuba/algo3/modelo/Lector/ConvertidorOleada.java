package edu.fiuba.algo3.modelo.Lector;

import java.util.Map;
import edu.fiuba.algo3.modelo.Enemigo.Oleada;

public class ConvertidorOleada implements Convertidor {

    private String turno;
    private Map<String, Integer> aInstanciar;

    public ConvertidorOleada(String turno, Map<String,Integer> aInstanciar) {
        this.turno = turno;
        this.aInstanciar = aInstanciar;
    }


    public Object obtener() throws Exception {
        return new Oleada(aInstanciar);// instanciar Oleada
    }
}
