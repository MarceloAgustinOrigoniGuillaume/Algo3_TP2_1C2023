package edu.fiuba.algo3.modelo.moduloLector;

import org.json.simple.JSONObject;

public class ConvertidorMapa extends Convertidor {

    JSONObject datos;
   /* public ConvertidorMapa(String x, String y, String tipo){
        super();
        this.agregar("Coordenada_X",x);
        this.agregar("Coordenada_Y",y);
        this.agregar("tipo",tipo);
    }
*/
    public ConvertidorMapa(JSONObject next) {

        this.datos = next;

    }

    //@Override
    public Object obtener2(String key){



        return datos.get(key);
    }

}
