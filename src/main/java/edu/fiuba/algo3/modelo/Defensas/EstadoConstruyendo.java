package edu.fiuba.algo3.modelo.Defensas;

import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Celdas.Coordenada;

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
    public void ejecutarMetodo(Defensa defensa, Mapa mapa, Coordenada coordenada){

        this.turnosRestantes = this.turnosRestantes - 1;

        if(hanFinalizadoLosTurnos()){
            defensa.finalizarConstruccion();
            mapa.notificarCeldaCambio(coordenada);
        } else{
            Logger.info("Defensa Estaba construyendose faltan\n"+String.valueOf(this.turnosRestantes)+" turnos para activarse");
        }
    }

    @Override
    public boolean estaActivo() {
        return false;
    }


}
