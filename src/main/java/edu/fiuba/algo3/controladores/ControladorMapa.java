package edu.fiuba.algo3.controladores;


import edu.fiuba.algo3.modelo.Juego;

import edu.fiuba.algo3.vistas.ViewCelda;
import edu.fiuba.algo3.DatosModelo;

import edu.fiuba.algo3.modelo.descriptors.CeldaDescriptor;
import edu.fiuba.algo3.Ventana;
import edu.fiuba.algo3.vistas.OnClickListener;
import edu.fiuba.algo3.modelo.Celdas.Coordenada;

//import edu.fiuba.algo3.vistas.Vista;


public class ControladorMapa extends Controlador {

	public static ViewCelda instanciarViewCelda(OnClickListener listener, CeldaDescriptor datos, int x , int y){
		ViewCelda celda = new ViewCelda(datos.tipo(), datos.cantidadEnemigos(), new Coordenada(x,y));
		celda.setOnClick(listener);
		return celda;

	}

	public interface ViewCeldaChangedListener{
		void cambiarCelda(ViewCelda celda);
	}

	public ControladorMapa(){

	}

	public void setListenerCeldas(ViewCeldaChangedListener listener){

		DatosModelo.setOnCeldaChangedListener(
			(Coordenada coordenada, CeldaDescriptor descriptor) ->{

				listener.cambiarCelda(instanciarViewCelda(null, descriptor, coordenada.x(), coordenada.y()));
			}
			);

	}

	//public boolean seleccionoOpcion(){
		//return false;
	//}

}