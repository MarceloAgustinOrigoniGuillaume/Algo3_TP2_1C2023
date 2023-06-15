package edu.fiuba.algo3.modelo.Celdas;

import java.util.ArrayList;

public interface Construccion extends Ataque{
	int obtenerRango();
	boolean estaActiva();
	ArrayList<Unidad> accionar(ArrayList<Unidad> enemigos);

}