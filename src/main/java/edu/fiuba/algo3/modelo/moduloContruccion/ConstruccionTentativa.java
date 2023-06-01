package edu.fiuba.algo3.modelo.moduloContruccion;

import edu.fiuba.algo3.modelo.moduloDefensas.Defensa;
import edu.fiuba.algo3.modelo.moduloMapa.GameEntity;
import edu.fiuba.algo3.modelo.moduloMapa.Posicion;

public class ConstruccionTentativa implements GameEntity {
    private Defensa unaDefensa;
    private int contador;

    public ConstruccionTentativa(Defensa unaDefensa) {
        this.unaDefensa = unaDefensa;
        this.contador = unaDefensa.turnoParaContruir();
    }

    public boolean finalizoContruccion() {
        return (this.contador <= 0);
    }

    public void reducirCooldown() {
        if(this.finalizoContruccion()){
            return;
        }
        this.contador--;
    }

    public Defensa construir() {
        return this.unaDefensa;
    }

    public int costo() {
        return unaDefensa.costoConstruccion();
    }

    public Posicion posicion() {
        return new Posicion(0,0);
    }
}
