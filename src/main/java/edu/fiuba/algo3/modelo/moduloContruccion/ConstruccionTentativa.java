package edu.fiuba.algo3.modelo.moduloContruccion;

import edu.fiuba.algo3.modelo.moduloDefensas.Defensa;

public class ConstruccionTentativa {
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
}
