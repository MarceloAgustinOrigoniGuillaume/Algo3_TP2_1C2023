package edu.fiuba.algo3.controladores.vistas;

import edu.fiuba.algo3.modelo.descriptors.CeldaDescriptor;
import edu.fiuba.algo3.modelo.Defensas.Defensa;
import edu.fiuba.algo3.modelo.Celdas.Coordenada;
import edu.fiuba.algo3.DatosModelo;

import edu.fiuba.algo3.controladores.Controlador;
import edu.fiuba.algo3.Logger;
import javafx.event.ActionEvent;
import edu.fiuba.algo3.Ventana;
import javafx.scene.Scene;
import edu.fiuba.algo3.Resources;

//import edu.fiuba.algo3.vistas.Vista;
import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import javafx.scene.input.MouseEvent;

import edu.fiuba.algo3.vistas.ViewCelda;
import edu.fiuba.algo3.vistas.ViewMapa;
import edu.fiuba.algo3.vistas.DefensaDraggeable;

import edu.fiuba.algo3.vistas.popups.MessagePopup;
import edu.fiuba.algo3.vistas.popups.BasePopup;


public class ControladorJuego extends Controlador {
	@FXML private HBox statusBar;
	@FXML private ViewMapa mapaJuego;

	private String nombreJugador;
	public ControladorJuego(String nombreJugador){
		this.nombreJugador = nombreJugador;
	}

	private void showError(String titulo, String mensaje){
		new MessagePopup(titulo,
			mensaje).show(mapaJuego.getScene());

		
	}

	private void showErrorConstruccion(String mensaje){
		showError("Error al construir", mensaje);
	}

	public static ViewCelda instanciarViewCelda(CeldaDescriptor datos, int x , int y){
		return new ViewCelda(datos.tipo(),datos.rel_image(), datos.cantidadEnemigos(), new Coordenada(x,y));
	}



	// estos serian mapa listeners?

	private void handleClickOnCelda(MouseEvent evento){
		evento.consume(); 

		ViewCelda celda = (ViewCelda)evento.getSource();
		if(estaConstruyendo()){


			if(!construyendo.posicionarEnMapa()){
				showErrorConstruccion("No se puede posicionar '"+construyendo.toString()+"' en '"+celda.getTipo()+"'");
				return;
			} 
			construyendo = null;
			return;
		}				

		new BasePopup(Resources.getVista("popup_habitantes", 
			new ControladorHabitantes(DatosModelo.obtenerTerrenoEn(celda.getCoordenada()))))
			.show(celda.getScene());		
	}

	private void handleEnteredOnCelda(MouseEvent evento){
		if(!estaConstruyendo()){
			return;
		}

		evento.consume(); 		
		construyendo.placeOn((ViewCelda)evento.getSource());
		//Logger.Log("Move defensa drageable a celda...");
	}

	private void handleExitedOnCelda(MouseEvent evento){
		if(!estaConstruyendo()){
			return;
		}

		evento.consume(); 

		construyendo.removeFrom((ViewCelda)evento.getSource());
		//Logger.Log("Erase defensa drageable a celda...");
	}



	public void initialize(){

		statusBar.getChildren().add(Resources.getVista("jugador",new ControladorJugador(nombreJugador)));
		statusBar.getChildren().add(Resources.getVista("menu_acciones",new ControladorMenuAcciones(this)));
		


		mapaJuego.loadFromResources(DatosModelo.mapa_width,DatosModelo.mapa_height,
			(int x, int y)->{
				ViewCelda celda = instanciarViewCelda(DatosModelo.obtenerTerrenoEn(x,y), x, y);

				celda.addEventHandler(MouseEvent.MOUSE_CLICKED,this::handleClickOnCelda);
				celda.addEventHandler(MouseEvent.MOUSE_ENTERED,this::handleEnteredOnCelda);
				celda.addEventHandler(MouseEvent.MOUSE_EXITED,this::handleExitedOnCelda);

				return celda;
			});


		DatosModelo.setOnCeldaChangedListener((Coordenada coordenada, CeldaDescriptor descriptor) ->{
				ViewCelda celda = mapaJuego.tileAt(coordenada.x(),coordenada.y());
				if(celda == null){
					Logger.err("at CeldaChanged, CELDA GIVEN TO UPDATE WAS NULL");
					return;
				}
				//Logger.Log("CELDA GIVEN TO UPDATE HAD POSITION "+celda.getCoordenada().toString());
				celda.updateView(descriptor.rel_image(), descriptor.cantidadEnemigos());
			});
	}



	private DefensaDraggeable construyendo = null;
	public boolean empezarConstruccion(DefensaDraggeable nuevaConstruccion){
		if(estaConstruyendo()){
			Logger.err("At empezarConstruccion, intento construir mas de una vez? ");
			return true;
		}
		// verificar que pueda costear y sino retorna false.
		if(!DatosModelo.puedeCostear(nuevaConstruccion.obtenerDefensa())){
			showErrorConstruccion("No se tiene los suficientes creditos para '"+nuevaConstruccion.toString()+"'");
			return false;
		}

		construyendo = nuevaConstruccion;
		return true;
	}

	public void cancelarConstruccion(){
		if(estaConstruyendo()){
			construyendo.reset();
			construyendo = null;
		}
	}

	public boolean estaConstruyendo(){
		return construyendo != null;
	}


	public void pasarTurno(Scene scene){

		if(estaConstruyendo()){
			showError("Error al pasar turno","Se esta construyendo. Termina o cancela la construccion antes.");
			return;
		}
		// pasas turno

		if(!DatosModelo.pasarTurno()){
			//Logger.dbg("----------->HABIA TERMINADO EL JUEGO?");
			

			scene.setRoot(Resources.getVista("menu_final",new ControladorFinal(DatosModelo.ganoJugador())));
			//terminarJuego(ventana);
			//return;
		}
	}

}