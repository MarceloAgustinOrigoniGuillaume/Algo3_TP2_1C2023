package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.controladores.vistasControladores.*;

import edu.fiuba.algo3.Resources;
import javafx.scene.Parent;

// queda medio anemica, podriamos hacer 
// todo cambio de view pase por aca. O volar esta clase y poner
// esto en ventana o Scene.
// Para hacer que cosas se ajusten a un width,height especifico
// capaz conviene tenerla, a futuro.  
public class ControladorVentana extends Controlador {
	public ControladorVentana() {
	}

	public static Parent menuInicio(){		
		return Resources.getVista("menu_inicio",new ControladorInicio(new ReproductorSonidos()));
	}

	public static Parent menuInicio(ReproductorSonidos sonidos){		
		return Resources.getVista("menu_inicio",new ControladorInicio(sonidos));
	}
}