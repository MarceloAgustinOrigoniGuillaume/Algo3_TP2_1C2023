package edu.fiuba.algo3.modelo.moduloLector;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import java.util.Iterator;

//import edu.fiuba.algo3.modelo.moduloMapa.Posicion;
//import edu.fiuba.algo3.modelo.moduloMapa.Parcela;
//import edu.fiuba.algo3.modelo.moduloMapa.Terreno;
//import edu.fiuba.algo3.modelo.moduloMapa.Pasarela;

import edu.fiuba.algo3.modeloNico.Celdas.*;


public class ConvertidorParcela implements Convertidor {

    private final static String TIPO_TIERRA = "Tierra";
    private final static String TIPO_ROCA = "Rocoso";
    private final static String TIPO_PASARELA = "Pasarela";


    private int x;
    private int y;
    private String tipo;

    public ConvertidorParcela(int x, int y, String tipo) {

        this.x = x;
        this.y = y;
        this.tipo = tipo;
    }


    private Celda instanciarParcela(){

        if (TIPO_TIERRA.equals(tipo)){
            return new Tierra(new Coordenada(x, y));
        }


        if (TIPO_ROCA.equals(tipo)){
            return new Rocosa(new Coordenada(x,y));
        }        


        if (TIPO_PASARELA.equals(tipo)){
            return new Pasarela(new Coordenada(x,y));
        }

        System.out.println("TIPO INVALIDO?? '"+tipo+"'");
        // TIRAR ERROR?
        return null;
    }



    public Object obtener(){
        return instanciarParcela();
    }

    public int fila(){
        return y;
    }

    public int columna(){
        return x;
    }

    public boolean esCaminable(){
        return TIPO_PASARELA.equals(tipo);
    }
}
