package edu.fiuba.algo3.controladores.vistas;


import edu.fiuba.algo3.controladores.Controlador;
import edu.fiuba.algo3.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import edu.fiuba.algo3.vistas.popups.BasePopup;
import edu.fiuba.algo3.Resources;
import edu.fiuba.algo3.DatosModelo;
import edu.fiuba.algo3.controladores.ControladorVentana;

//import edu.fiuba.algo3.vistas.Vista;


public class ControladorMenuAcciones extends Controlador {
	@FXML private Button buttonConstruir;
	@FXML private Label turnoActual;

	private ControladorJuego juego;
	private BasePopup menu = null;
	public ControladorMenuAcciones(ControladorJuego controladorJuego){
		juego = controladorJuego;
	}

	public void initialize(){
		Logger.Log("INITIALIZED MENU ACCIONES");
		turnoActual.setText("Texto");

		DatosModelo.setObserverTurno((String turno)->{
			turnoActual.setText("turno: "+turno);
		});
	}

	public void toggleConstruccion(ActionEvent ev){
		juego.toggleConstruyendo();
		if(juego.estaConstruyendo()){
			buttonConstruir.setText("Cancelar");
			menu = new BasePopup(Resources.getVista("menu_construir", new ControladorConstruir()));

			menu.show(buttonConstruir.getScene());
		} else{
			buttonConstruir.setText("Construir");
			if(menu != null){
				menu.hide();
				menu = null;
			}
		}
	}

	public void pasarTurno(ActionEvent ev){
		juego.pasarTurno(buttonConstruir.getScene());
	}


	public void volverInicio(ActionEvent event){
		try{
			//String nombreJugador;
			DatosModelo.reiniciarJuego();
					
			// volve a inicio
			buttonConstruir.getScene().setRoot(ControladorVentana.menuInicio());

		} catch(Exception ex){
			Logger.Log("ERROR Re INICIANDO NUEVO JUEGO "+ex.toString());
			ex.printStackTrace();
			return;
		}

	}
}