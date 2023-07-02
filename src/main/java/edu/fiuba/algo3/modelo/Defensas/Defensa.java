package edu.fiuba.algo3.modelo.Defensas;
//import edu.fiuba.algo3.modelo.Celdas.habitantes.HabitantesConstruccion;

import java.util.ArrayList;
import edu.fiuba.algo3.Logger;

import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Celdas.Coordenada;
import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Enemigo.Enemigo;
import edu.fiuba.algo3.modelo.descriptors.CeldaDescriptor;
import edu.fiuba.algo3.modelo.descriptors.DefensaDescriptor;

import edu.fiuba.algo3.modelo.Celdas.OnAttackListener;


public abstract class Defensa implements Estructura, Construccion {
    protected EstadoEstructura estadoActual;

    public Defensa(EstadoEstructura estado_inicial){
        estadoActual = estado_inicial;
    }

    public void finalizarConstruccion(){

        this.estadoActual = new EstadoConstruido();
        Logger.info(this,"termino construccion, siguiente turno ataca.");
    }

    public void accionar(Mapa mapa , Coordenada posicion){
        estadoActual.ejecutarMetodo(this, mapa, posicion);
    }

    public boolean estaActiva() {
        return estadoActual.estaActivo();
    }

    public abstract int obtenerRango();

    public abstract int ataque();

    public abstract boolean atacar(ArrayList<Enemigo> enemigo, OnAttackListener listener);

    public boolean posicionarEn(Celda celda){
        return celda.guardar(this);
    }

    public DefensaDescriptor describe(){
        return new DefensaDescriptor(this.toString(), estaActiva());
    }
}
