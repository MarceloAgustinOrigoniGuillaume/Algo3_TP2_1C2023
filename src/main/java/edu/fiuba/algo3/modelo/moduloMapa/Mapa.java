package edu.fiuba.algo3.modelo.moduloMapa;

import edu.fiuba.algo3.modelo.moduloLector.Elemento;
import edu.fiuba.algo3.modelo.moduloLector.Lector;

import java.util.ArrayList;

public class Mapa {
    public Mapa(Lector unLector) {
        ArrayList<Parcela> fila = new ArrayList();
        while (unLector.haySiquiente()){
            Elemento elemento = unLector.siguienteElemento();
            instanciarParcela(elemento.obtener("tipo"),
                              Integer.parseInt(elemento.obtener("Coordenada_x")),
                              Integer.parseInt(elemento.obtener("Coordenada_y")));

        }
    }
    private void instanciarParcela(String parcela,int x,int y){

    }

}
