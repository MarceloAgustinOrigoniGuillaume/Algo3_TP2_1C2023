package edu.fiuba.algo3.modelo.moduloMapa;

import edu.fiuba.algo3.modelo.moduloEnemigos.Enemigo;
import edu.fiuba.algo3.modelo.moduloLector.Convertidor;
import edu.fiuba.algo3.modelo.moduloLector.Lector;
import edu.fiuba.algo3.modelo.moduloContruccion.ConstruccionTentativa;

import java.util.ArrayList;

public class Mapa {

    private final static String TIPO_TIERRA = "Tierra";
    private final static String TIPO_ROCA = "Rocoso";
    private final static String TIPO_PASARELA = "Pasarela";

    private ArrayList<ArrayList<Parcela>> matriz;
    private ArrayList<Pasarela> camino;

    public Mapa(Lector unLector) {
        matriz = new ArrayList<>();
        ArrayList<Parcela> fila = new ArrayList<>();
        matriz.add(fila);
        int y;
        camino = new ArrayList<>();
        while (unLector.haySiguiente()){
            Convertidor elemento = unLector.siguienteElemento();
            

            y = Integer.parseInt(elemento.obtener("Coordenada_Y"));

            if(y > matriz.size()){
                
                fila = new ArrayList<>();
                matriz.add(fila);
            }



            fila.add(instanciarParcela(elemento.obtener("tipo"),
                              Integer.parseInt(elemento.obtener("Coordenada_X")),
                              y));
        }


        camino = UtilsMapa.ordenarPasarelas(camino);

    }
    private Parcela instanciarParcela(String tipo,int x,int y){

        if (TIPO_TIERRA == tipo){
            return new Terreno(new Posicion(x,y), true);
        }


        if (TIPO_ROCA == tipo){
            return new Terreno(new Posicion(x,y), false);
        }        


        if (TIPO_PASARELA == tipo){
            Pasarela pasarela = new Pasarela(new Posicion(x,y));

            camino.add(pasarela);

            return pasarela;
        }

        // TIRAR ERROR?
        return null;
    }

    private Parcela obtenerParcela(Posicion pos){
        return matriz.get(pos.Y()).get(pos.X());
        //return new Terreno(new Posicion(0,0), true);
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
        return camino.get(0).posicion();
    }


    public Posicion mover(Enemigo unidad, Posicion desde, int unidades){
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

        return pasarela.posicion();

    }



}
