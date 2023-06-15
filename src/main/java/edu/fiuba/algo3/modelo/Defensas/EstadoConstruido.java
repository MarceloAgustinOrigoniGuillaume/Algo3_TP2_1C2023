package edu.fiuba.algo3.modelo.Defensas;


import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.modelo.Celdas.Unidad;
import edu.fiuba.algo3.modelo.Mapa.Mapa;

import java.util.ArrayList;

public class EstadoConstruido implements EstadoEstructura{

    private Defensa defensa;

    @Override
    public ArrayList<Unidad> ejecutarMetodo(Defensa defensa, ArrayList<Unidad> enemigos) {
        ArrayList<Unidad> enemigosMuertos = new ArrayList<>();
        for(Unidad enemigo: enemigos){
            Logger.info("Defensa ataca a enemigo en: "+enemigo.toString()+"\n");

            enemigo.recibirAtaque(defensa.ataque());

            if(enemigo.estaMuerto()){
                enemigosMuertos.add(enemigo);
            }
        }

        return enemigosMuertos;

    }
    public boolean estaActivo(){
        return true;
    }
}

