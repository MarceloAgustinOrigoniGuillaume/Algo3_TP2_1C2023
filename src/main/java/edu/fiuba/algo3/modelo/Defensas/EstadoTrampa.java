package edu.fiuba.algo3.modelo.Defensas;


import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Celdas.Coordenada;

import java.util.ArrayList;

public class EstadoTrampa implements EstadoEstructura{

	private int restanteDeVida;
	public EstadoTrampa(int tiempoDeVida){
		restanteDeVida= tiempoDeVida;
	}

    @Override
    public void ejecutarMetodo(Defensa defensa, Mapa mapa, Coordenada coordenada){

        if(restanteDeVida<=0){
        	mapa.removerConstruccion(coordenada);
        	return;
        }
        restanteDeVida-=1;
        
        // ataca solo la coordenada en la que esta.
        mapa.atacar(coordenada, defensa);
    }
    public boolean estaActivo(){
        return true;
    }
}

