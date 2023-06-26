package edu.fiuba.algo3.controladores.vistas;


import edu.fiuba.algo3.controladores.Controlador;
import edu.fiuba.algo3.Logger;
import javafx.event.ActionEvent;

//import edu.fiuba.algo3.vistas.Vista;


public class ControladorConstruir extends Controlador {
	public ControladorConstruir(){
		Logger.Log("Construyendo controlador Construir sin params");
	}


	public void empezarConstruccion(ActionEvent ev){
		Logger.Log("EMPEZANDO CONSTRUIR "+ev.toString());
	}
}