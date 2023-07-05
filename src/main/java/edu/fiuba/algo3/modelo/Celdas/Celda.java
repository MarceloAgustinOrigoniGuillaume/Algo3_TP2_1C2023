package edu.fiuba.algo3.modelo.Celdas;

import edu.fiuba.algo3.Logger;

import edu.fiuba.algo3.modelo.Defensas.Trampa;
import edu.fiuba.algo3.modelo.Defensas.Construccion;
import edu.fiuba.algo3.modelo.Defensas.Defensa;

// imports celda enemigo.
import edu.fiuba.algo3.modelo.Enemigo.Enemigo;
import edu.fiuba.algo3.modelo.Enemigo.aereos.EnemigoAereo;
import java.util.ArrayList;

import edu.fiuba.algo3.modelo.Jugador.Jugador;


import edu.fiuba.algo3.modelo.Mapa.Mapa;

import edu.fiuba.algo3.modelo.descriptors.CeldaDescriptor;
import edu.fiuba.algo3.modelo.descriptors.DefensaDescriptor;

//import edu.fiuba.algo3.modelo.Celdas.habitantes.HabitantesConstruccion;

public abstract class Celda implements CeldaConEnemigos{

    private Construccion construccionGuardada;

    // Se usa composicion para evitar romper liskov.
    private CeldaBase celdaEnemigos;
    public Celda(boolean habilitarTodos){
        celdaEnemigos = new CeldaBase(habilitarTodos);

    }

    private boolean estaOcupada(){
        return construccionGuardada != null;
    }

    protected boolean guardaConstruccion(Construccion construccion){
        if(estaOcupada()){
            return false;
        }
        construccionGuardada = construccion;
        return true;
    }

    public void borrarDefensa(){
        Logger.Log("se borro la defensa: ", construccionGuardada);
        construccionGuardada = null;
    }




    // accionar estructuras, acciona a la construccion de tener una.
    public void accionarEstructuras(Mapa mapa, Coordenada desde){
        if(construccionGuardada != null){
            construccionGuardada.accionar(mapa,desde);
        }
    }

    // metodos publicos para el double dispatch
    public abstract boolean guardar(Trampa trampa);
    public abstract boolean guardar(Construccion construccion);
    public abstract boolean recibirAtaqueLechuza(OnAttackListener listener);


    private DefensaDescriptor describirDefensa() {
        if(this.construccionGuardada != null){
            return new DefensaDescriptor(this.construccionGuardada.toString(), this.construccionGuardada.estaActiva());
        }
        return new DefensaDescriptor();
    }



    // Metodos Implementacion de CeldaConEnemigos, que delegan.

    //Pre: Por default solo se puede guardar Unidades en pasarela. habilitarTodos es false.
    //Post: -
    public boolean guardar(Enemigo unidad){
        return celdaEnemigos.guardar(unidad);
    }
    
    // diferenciamos entre aereo y uno general para posicionar.
    public boolean guardar(EnemigoAereo aereo){
        return celdaEnemigos.guardar(aereo);        
    }


    public int cantidadUnidades(){
        return celdaEnemigos.cantidadUnidades();

    }
    public void sacar(Enemigo enemigo){
        celdaEnemigos.sacar(enemigo);        
    }


    // Metodos relacionados a ataques
    public boolean recibirAtaque(Defensa ataque, OnAttackListener listener){
        return celdaEnemigos.recibirAtaque(ataque, listener);        
    }

    public ArrayList<Enemigo> popMuertos(){
        return celdaEnemigos.popMuertos();
    }

    public void accionarEnemigos(Mapa mapa, Jugador jugador, Coordenada desde){
        celdaEnemigos.accionarEnemigos(mapa, jugador, desde);
    }



    // getters, le suma al damage posible y lo devuelve
    public int obtenerDamagePosible(int contadorActual){
        return celdaEnemigos.obtenerDamagePosible(contadorActual);
    }


    public CeldaDescriptor describe(){
        return new CeldaDescriptor( this.toString(),
            describirDefensa(), celdaEnemigos.describirEnemigos());
    }









}
