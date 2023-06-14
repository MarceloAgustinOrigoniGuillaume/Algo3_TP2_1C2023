package edu.fiuba.algo3.vistas;


public class Ventana {

	private Vista vista_actual = null;

	public void setVista(Vista vista){

		if(vista_actual != null){
			System.out.println("QUISO CAMBIAR La Vista, pero no se implemento el cambio de vista");
			return;			
		}
		vista_actual = vista;
	}

	public void show(){
		if(vista_actual == null){
			System.out.println("QUISO CAMBIAR LA Vista");			
			return;
		}

		System.out.println("Mostrar vista"+vista_actual.obtenerDescripcion());			
	}

}