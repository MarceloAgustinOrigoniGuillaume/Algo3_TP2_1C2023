package edu.fiuba.algo3.controladores;


import edu.fiuba.algo3.modelo.Juego;

import edu.fiuba.algo3.vistas.ViewCelda;
import edu.fiuba.algo3.DatosModelo;

import edu.fiuba.algo3.modelo.descriptors.CeldaDescriptor;
import edu.fiuba.algo3.Ventana;
import edu.fiuba.algo3.vistas.OnClickListener;
import edu.fiuba.algo3.modelo.Celdas.Coordenada;
import edu.fiuba.algo3.Logger;

//import edu.fiuba.algo3.vistas.Vista;


public class ControladorMapa extends Controlador {

    public interface TileResources{
        ViewCelda tileAt(int x, int y);
    }


	public static ViewCelda instanciarViewCelda(OnClickListener listener, CeldaDescriptor datos, int x , int y){
		ViewCelda celda = new ViewCelda(datos.rel_image(), datos.cantidadEnemigos(), new Coordenada(x,y));
		celda.setOnClick(listener);
		return celda;

	}

	public ControladorMapa(){

	}

	public void setListenerCeldas(TileResources resources){

		DatosModelo.setOnCeldaChangedListener(
			(Coordenada coordenada, CeldaDescriptor descriptor) ->{
				ViewCelda celda = resources.tileAt(coordenada.x(),coordenada.y());
				if(celda == null){
					Logger.Log("CELDA GIVEN TO UPDATE WAS NULL");
					return;
				}
				Logger.Log("CELDA GIVEN TO UPDATE HAD POSITION "+celda.getCoordenada().toString());
				celda.updateView(descriptor.rel_image(), descriptor.cantidadEnemigos());
			});

	}

	//public boolean seleccionoOpcion(){
		//return false;
	//}

}