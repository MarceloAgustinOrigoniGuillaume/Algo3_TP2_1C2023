package edu.fiuba.algo3.controladores.vistas;


import edu.fiuba.algo3.controladores.Controlador;
import edu.fiuba.algo3.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import edu.fiuba.algo3.vistas.popups.BasePopup;
import edu.fiuba.algo3.Resources;
import edu.fiuba.algo3.AlgoDefense;
import edu.fiuba.algo3.controladores.ControladorVentana;
import edu.fiuba.algo3.vistas.DefensaDraggeable;

//import edu.fiuba.algo3.vistas.Vista;


public class ControladorMenuAcciones extends Controlador {
	@FXML private Button buttonConstruir;
	@FXML private Label turnoActual;

	private ControladorJuego juego;
	private AlgoDefense mediatorJuego;
	private BasePopup menu = null;
	public ControladorMenuAcciones(ControladorJuego controladorJuego, AlgoDefense mediatorJuego){
		juego = controladorJuego;
		this.mediatorJuego = mediatorJuego;
	}

	public void initialize(){
		//Logger.Log("INITIALIZED MENU ACCIONES, status bar");
		
		mediatorJuego.setObserverTurno((String turno)->{
			turnoActual.setText("Turno: "+turno);
		});
	}


	private void cancelConstruccion(){

		if(!juego.estaConstruyendo()){
			buttonConstruir.setText("Construir");
		}
	}

	private void empezarConstruccion(String construccion){

		DefensaDraggeable construccionTentativa= new DefensaDraggeable(mediatorJuego.instanciador(construccion));

		construccionTentativa.setOnPlaced(()->{
			buttonConstruir.setText("Construir");
		});
		if (juego.empezarConstruccion(construccionTentativa)){
			menu.hide();
			menu = null;
		}
	}

	public void toggleConstruccion(ActionEvent ev){
		if(!juego.estaConstruyendo() && menu == null){


			buttonConstruir.setText("Cancelar");
			menu = new BasePopup(Resources.getVista("menu_construir", new ControladorConstruir(this::empezarConstruccion)));
			menu.setOnHide(this::cancelConstruccion);
			menu.show(buttonConstruir.getScene());			
		} else{
			if(menu != null){
				menu.hide();
			}
			juego.cancelarConstruccion();
			cancelConstruccion();
			menu = null;
		}
	}

	public void pasarTurno(ActionEvent ev){
		juego.pasarTurno(buttonConstruir.getScene());
	}


	public void volverInicio(ActionEvent event){
		try{
			//String nombreJugador;
			mediatorJuego.reiniciarJuego();
					
			// volve a inicio
			buttonConstruir.getScene().setRoot(ControladorVentana.menuInicio());

		} catch(Exception ex){
			Logger.err("At volverInicio ",ex);
			ex.printStackTrace();
			return;
		}

	}
}