package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.Ventana;
import edu.fiuba.algo3.modelo.Celdas.Coordenada;
import edu.fiuba.algo3.vistas.*;
import edu.fiuba.algo3.controladores.vistas.*;
import edu.fiuba.algo3.modelo.descriptors.CeldaDescriptor;

import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.Resources;
import javafx.scene.Scene;
import javafx.scene.Parent;
import edu.fiuba.algo3.vistas.popups.BasePopup;

// queda medio anemica, podriamos hacer 
// todo cambio de view pase por aca. O volar esta clase y poner
// esto en ventana o Scene.
// Para hacer que cosas se ajusten a un width,height especifico
// capaz conviene tenerla, a futuro.  
public class ControladorVentana extends Controlador {
	public ControladorVentana() {
	}

	public static Parent menuInicio(){
		return Resources.getVista("menu_inicio",new ControladorInicio());
	}
}