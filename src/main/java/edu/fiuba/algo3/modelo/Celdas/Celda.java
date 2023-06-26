package edu.fiuba.algo3.modelo.Celdas;

import edu.fiuba.algo3.modelo.Defensas.Defensa;
import edu.fiuba.algo3.modelo.Enemigo.Enemigo;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.descriptors.CeldaDescriptor;

import edu.fiuba.algo3.modelo.Celdas.habitantes.Habitantes;
import edu.fiuba.algo3.modelo.Celdas.habitantes.HabitantesConstruccion;

import java.util.ArrayList;

public abstract class Celda {

    //private Coordenada coordenada;
    protected Habitantes habitantes;
    protected HabitantesConstruccion construcciones;

    public Celda(Coordenada pos, Habitantes habitantes,HabitantesConstruccion construcciones){
        this.habitantes = habitantes;
        this.construcciones = construcciones;
    }

    public Habitantes enemigos(){
        return habitantes;
    }

    public HabitantesConstruccion defensas(){
        return construcciones;
    }

    public void accionarEstructuras(Mapa mapa, Coordenada posicion){
        construcciones.accionarEstructuras(mapa, posicion);
    }

    public  void accionarEnemigos(Mapa mapa, Jugador jugador, Coordenada posicion){
        habitantes.accionarEnemigos(mapa, jugador, posicion);
    }

    //Pre: -
    //Post: Describe a la celda para la ui... pone todos los datos necesarios
    public CeldaDescriptor describe(){
        return new CeldaDescriptor( this.toString() , habitantes.cantidadUnidades(), construcciones.describir(), habitantes.describir());
    }

    public int obtenerDamagePosible(int damageTotal) {
        return habitantes.obtenerDamagePosible(damageTotal);
    }

    public void sacar(Enemigo unidad) {
        habitantes.sacar(unidad);
    }

    public boolean defensaRecibirAtaqueAereo() {
        return  construcciones.recibirAtaqueLechuza();
    }

    public void limpiarDefensas() {
        construcciones.clear();
    }

    public boolean recibirAtaqueEnemigo(Defensa defensa) {
        return habitantes.recibirAtaque(defensa);
    }

    public ArrayList<Enemigo> retirarEnemigosMuertos() {
        return habitantes.popMuertos();
    }

    public boolean guardar(Defensa defensa) {
        return defensas().guardar(defensa);
    }
}
