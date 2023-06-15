package edu.fiuba.algo3.modelo.Defensas;

import edu.fiuba.algo3.modelo.Celdas.Unidad;
import edu.fiuba.algo3.modelo.Mapa.Mapa;

import java.util.ArrayList;

public class EstadoConstruyendo implements EstadoEstructura{
    private int turnosRestantes;

    public EstadoConstruyendo(int turnosNecesarios){
        this.turnosRestantes = turnosNecesarios;
    }

    public boolean hanFinalizadoLosTurnos(){
        if(turnosRestantes == 0) {
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<Unidad> ejecutarMetodo(Defensa defensa, ArrayList<Unidad> enemigos){

        this.turnosRestantes = this.turnosRestantes - 1;

        if(hanFinalizadoLosTurnos()){
            defensa.finalizarConstruccion();
        }

        return null;
    }

    @Override
    public boolean estaActivo() {
        return false;
    }


}
