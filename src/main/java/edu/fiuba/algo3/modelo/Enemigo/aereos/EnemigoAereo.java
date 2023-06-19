package edu.fiuba.algo3.modelo.Enemigo.aereos;
import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.modelo.Celdas.Coordenada;
import edu.fiuba.algo3.modelo.Enemigo.Enemigo;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Celdas.habitantes.Habitantes;

import java.util.ArrayList;

public abstract class EnemigoAereo extends Enemigo {

    private int vidaCambioMovimiento;
    private EstadoMovimiento estado;

    public EnemigoAereo(int vida, int velocidad) {
        super(vida, velocidad);
    }
    public boolean posicionarEn(Habitantes habitantes){
        return habitantes.guardar(this);
    }

    @Override
    public void recibirAtaque(int danioRecibido) {
        this.vida = this.vida - danioRecibido;
        Logger.info("El daño recibido es: "+danioRecibido);
    }

    public int creditosDados(){
        return 1;
    }

    @Override
    public String toString(){
        return "Enemigo Aereo";
    }
}
