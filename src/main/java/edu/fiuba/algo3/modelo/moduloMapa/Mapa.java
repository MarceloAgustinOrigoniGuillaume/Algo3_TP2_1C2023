package edu.fiuba.algo3.modelo.moduloMapa;

import edu.fiuba.algo3.modelo.moduloLector.Elemento;
import edu.fiuba.algo3.modelo.moduloLector.Lector;

import java.util.ArrayList;

public class Mapa {

    private final static String TIPO_TIERRA = "tierra";
    private final static String TIPO_ROCA = "roca";
    private final static String TIPO_PASARELA = "pasarela";

    public Mapa(Lector unLector) {
        ArrayList<ArrayList<Parcela>> filas = new ArrayList<>();
        ArrayList<Parcela> fila = new ArrayList<>();
        filas.add(fila);
        int y;
        while (unLector.haySiguiente()){
            Elemento elemento = unLector.siguienteElemento();
            

            y = Integer.parseInt(elemento.obtener("Coordenada_y"));

            if(y > filas){
                
                fila = new ArrayList<>();
                filas.add(fila);
            }



            fila.add(instanciarParcela(elemento.obtener("tipo"),
                              Integer.parseInt(elemento.obtener("Coordenada_x")),
                              y));
        }
    }
    private Parcela instanciarParcela(String parcela,int x,int y){

        if (TIPO_TIERRA.equals(parcela)){
            return new Terreno(new Posicion(x,y), true);
        }


        if (TIPO_ROCA.equals(parcela)){
            return new Terreno(new Posicion(x,y), false);
        }        


        if (TIPO_PASARELA.equals(parcela)){
            return new Pasarela(new Posicion(x,y));
        }

        // TIRAR ERROR?
    }

    private Parcela obtenerParcela(Posicion pos){

    }

    public boolean posicionar(ConstruccionTentativa construccion){

        Parcela parcela = obtenerParcela(construccion.posicion());

        if(!parcela.puedePoner(construccion)){
            return false;
        }

        // posicionar....
        parcela.poner(construccion);

        return true;
    }
}
