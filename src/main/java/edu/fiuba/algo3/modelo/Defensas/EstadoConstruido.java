package edu.fiuba.algo3.modelo.Defensas;


import edu.fiuba.algo3.modelo.Mapa.Mapa;

public class EstadoConstruido implements EstadoEstructura{

    private Defensa defensa;

    @Override
    public void ejecutarMetodo(Defensa defensa, Mapa mapa) {

        /*
        ArrayList<Coordenada> posiciones = defensa.obtenerRango();
        int rango = defensa.obtenerAtaque();

        for (Coordenada coorde: posiciones) {
            //mapa.atacar(corde);
        }
        */
    }
    public boolean estaActivo(){
        return true;
    }
}

