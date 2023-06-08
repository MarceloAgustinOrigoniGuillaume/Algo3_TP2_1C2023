package edu.fiuba.algo3.modeloNico.Defensas;

import edu.fiuba.algo3.modeloNico.Mapa.Mapa;

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
    public void ejecutarMetodo(Defensa defensa, Mapa mapa){

        this.turnosRestantes = this.turnosRestantes - 1;
        boolean haFinalizado = hanFinalizadoLosTurnos();

        if(haFinalizado == true){
            defensa.finalizarConstruccion();
        }

    }

    @Override
    public boolean estaActivo() {
        return false;
    }


}
