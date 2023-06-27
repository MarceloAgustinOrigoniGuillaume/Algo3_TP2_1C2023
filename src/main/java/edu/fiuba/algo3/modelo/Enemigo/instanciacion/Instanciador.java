package edu.fiuba.algo3.modelo.Enemigo.instanciacion;

import edu.fiuba.algo3.modelo.Enemigo.Enemigo;
import java.util.ArrayList;
import edu.fiuba.algo3.Logger;

public class Instanciador{
	private int cantidad;
	private Enemigo enemigoBase;
	public Instanciador(Enemigo enemigo, int cantidad){
		this.enemigoBase = enemigo;
		this.cantidad = cantidad;
	}
	public void agregarInstanciasA(ArrayList<Enemigo> enemigos){
		Logger.info("Instanciando ",enemigoBase,cantidad,"veces");
		for(int i = 0; i< cantidad; i++){
			enemigos.add(enemigoBase.copiar());
		}
	}
}