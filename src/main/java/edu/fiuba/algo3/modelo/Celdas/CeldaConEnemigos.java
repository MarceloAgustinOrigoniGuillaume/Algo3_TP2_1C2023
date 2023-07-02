package edu.fiuba.algo3.modelo.Celdas;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.Defensas.Defensa;
import edu.fiuba.algo3.modelo.Jugador.Jugador;

import edu.fiuba.algo3.modelo.Mapa.Mapa;

import edu.fiuba.algo3.modelo.Enemigo.Enemigo;
import edu.fiuba.algo3.modelo.Enemigo.aereos.EnemigoAereo;

import edu.fiuba.algo3.modelo.descriptors.CeldaDescriptor;

// Interfaz para que mapa dependa de una abstraccion
// y poder tambien no romper liskov el usar herencia.
public interface CeldaConEnemigos {

	//Pre: Por default solo se puede guardar Unidades en pasarela. habilitarTodos es false.
	//Post: -
	boolean guardar(Enemigo unidad);
	
	// diferenciamos entre aereo y uno general para posicionar.
	boolean guardar(EnemigoAereo aereo);


	int cantidadUnidades();
    void sacar(Enemigo enemigo);


    // Metodos relacionados a ataques

	boolean recibirAtaque(Defensa ataque, OnAttackListener listener);

	ArrayList<Enemigo> popMuertos();

	void accionarEnemigos(Mapa mapa, Jugador jugador, Coordenada desde);



	// getters, le suma al damage posible y lo devuelve
	int obtenerDamagePosible(int contadorActual);

	// devuelve una descripcion, usada para la ui despues.
    CeldaDescriptor describe();

}
