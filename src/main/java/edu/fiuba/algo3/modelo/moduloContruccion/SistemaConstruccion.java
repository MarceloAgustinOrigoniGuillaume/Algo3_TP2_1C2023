package edu.fiuba.algo3.modelo.moduloContruccion;

import edu.fiuba.algo3.modelo.moduloDefensas.EstructurasActivas;

import java.util.ArrayList;

public class SistemaConstruccion {
    private ArrayList<ConstruccionTentativa> Construcciones = new ArrayList<>();
    public SistemaConstruccion(){
    }
    public void agregarEnConstruccion(ConstruccionTentativa enContruccion) {
        Construcciones.add(enContruccion);
    }

    public void activarEstructuras(EstructurasActivas activas) {
        for (ConstruccionTentativa enContruccion: Construcciones
             ) {
            enContruccion.reducirCooldown();
            if(enContruccion.finalizoContruccion()){
                activas.agregar(enContruccion.construir());
            }
        }

        Construcciones.removeIf(s -> s.finalizoContruccion());
    }
}
