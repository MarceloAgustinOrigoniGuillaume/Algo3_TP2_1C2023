package edu.fiuba.algo3.modelo.moduloMapa;

import edu.fiuba.algo3.modelo.moduloLector.Elemento;
import edu.fiuba.algo3.modelo.moduloLector.Lector;

import java.util.ArrayList;

public class Mapa {

    private final static String TIPO_TIERRA = "tierra";
    private final static String TIPO_ROCA = "roca";
    private final static String TIPO_PASARELA = "pasarela";

    private ArrayList<ArrayList<Parcela>> matriz;
    private ArrayList<Pasarela> camino;

    public Mapa(Lector unLector) {
        matriz = new ArrayList<>();
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


        camino = UtilsMapa.ordenarPasarelas(camino);

    }
    private Parcela instanciarParcela(String parcela,int x,int y){

        if (TIPO_TIERRA.equals(parcela)){
            return new Terreno(new Posicion(x,y), true);
        }


        if (TIPO_ROCA.equals(parcela)){
            return new Terreno(new Posicion(x,y), false);
        }        


        if (TIPO_PASARELA.equals(parcela)){
            Pasarela pasarela = new Pasarela(new Posicion(x,y));

            camino.add(pasarela);

            return pasarela;
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

    public boolean posicionar(GameEntity gameEntity, Posicion pos){

        Parcela parcela = obtenerParcela(pos);

        if(!parcela.puedePoner(gameEntity)){
            return false;
        }

        // posicionar....
        parcela.poner(gameEntity);

        return true;
    }

    public Posicion posicionInicio(){
        return camino.get(0);
    }


    public Posicion mover(Unidad unidad, Posicion desde, int unidades){
        Parcela pasarela = obtenerParcela(desde);

        if(!camino.contains(pasarela)){
            // o tirar error....
            return desde;
        }

        int index = camino.indexOf(pasarela);

        index += unidades;

        if( index>= camino.size()){
            index = camino.size()-1;
        }

        pasarela.sacar(unidad);
        pasarela = camino.get(index);
        pasarela.poner(unidad);

        return pasarela;

    }



}
