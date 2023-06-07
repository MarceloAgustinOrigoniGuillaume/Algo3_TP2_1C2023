package edu.fiuba.algo3.modelo.moduloEnemigos;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.moduloLector.Convertidor;
import edu.fiuba.algo3.modelo.moduloLector.Lector;
import edu.fiuba.algo3.modelo.moduloMapa.Posicion;

import java.util.ArrayList;

public class Enemigos {
    ArrayList<Enemigo> enemigos;

    public Enemigos(Lector unLector, Jugador jugador, Posicion pos){
        enemigos = new ArrayList<Enemigo>();
        while (unLector.haySiguiente()){
            Convertidor elemento = unLector.siguienteElemento();


            int cantidad = Integer.parseInt(elemento.obtener("cantidad"));

            if(cantidad <= 0){
                    continue;
            }
            int turno = Integer.parseInt(elemento.obtener("turno"));

            String enemigo = elemento.obtener("tipo");
            for(int i =0; i< cantidad; i ++ ) {
                if (enemigo == "arana") {
                    enemigos.add(new Spider(pos, jugador));
                } else {
                    enemigos.add(new Hormiga(pos, jugador));
                }
            }



        }
    }

    public boolean puedeMatar(Jugador jugador) {
        if(enemigos.size() >= jugador.obtenerVida()){
            return true;
        }
        return false;
    }
}
