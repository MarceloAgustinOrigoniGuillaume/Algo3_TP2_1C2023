package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.modelo.Defensas.Defensa;
import edu.fiuba.algo3.modelo.Defensas.torres.TorreBlanca;
import edu.fiuba.algo3.modelo.Defensas.torres.TorrePlateada;
import edu.fiuba.algo3.modelo.Defensas.Trampa;
import edu.fiuba.algo3.modelo.Celdas.Coordenada;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.descriptors.CeldaDescriptor;

import edu.fiuba.algo3.modelo.Mapa.OnHabitantesChangedListener;
import edu.fiuba.algo3.modelo.Celdas.OnAttackListener;

public class AlgoDefense {
	private static final int mapa_width = 15;
	private static final int mapa_height = 15;

	private Juego juego;
	private String nombre;


	private AlgoDefense(Juego juego, String nombreJugador){
		nombre = nombreJugador;
		this.juego = juego;		
	} 

	public AlgoDefense(String jsonMapa, String jsonEnemigos, String nombreJugador) throws Exception{
		this(new Juego(jsonMapa, jsonEnemigos), nombreJugador);
	}

	public String getNombreJugador(){
		return nombre;
	}

	public int width(){
		return mapa_width;
	}

	public int height(){
		return mapa_height;
	}

	//### control estado juego.
	public void empezarJuego(){
		try{
			juego.iniciarJuego();
		} catch(Exception ex){
			Logger.err("----------------Error al iniciar juego",ex);
		}		

	}

	public void terminarJuego(){
		try{
			juego.terminarJuego();
		} catch(Exception ex){
			Logger.err("----------------Error al finalizar juego",ex);
		}		
	}



	public AlgoDefense reiniciarJuego() throws Exception{
		return new AlgoDefense(juego.nuevoJuego(), nombre);
	}

	// pasas un turno y devolves si sigue en juego
	public boolean pasarTurno(){
		juego.pasarTurno();
		
		return juego.estanEnJuego();

	}

	public boolean ganoJugador(){
		return juego.ganoJugador();
	}


	//### posicionamiento defensas
	
	public boolean puedeCostear(Defensa defensa){
		return juego.obtenerJugador().puedeCostear(defensa);
	}
	// Metodo utilitiario para instanciar defensas en controlador menu acciones.
	public static Defensa instanciador(String tipoDeEstructura){

		if(tipoDeEstructura == "TorreBlanca"){
			return new TorreBlanca();
		}

		if(tipoDeEstructura == "TorrePlateada"){
			return new TorrePlateada();
		}
		return new Trampa();
	}


	
	public boolean colocadorDeDefensas(Defensa defensa, Coordenada coordenada){
		Logger.Log("Intento colocar"+defensa.toString()+" En la posicion"+coordenada.x()+"-"+coordenada.y());
		return juego.posicionar(defensa,coordenada);
	}


	//### getters de descriptors.
	public CeldaDescriptor obtenerTerrenoEn(int x,int y){
		return obtenerTerrenoEn(new Coordenada(x,y));
	}

	public CeldaDescriptor obtenerTerrenoEn(Coordenada coord){
		return juego.obtenerMapa().obtenerInformacion(coord);
	}



	




	//### setters listeners de eventos.
	
	public void setOnCeldaChangedListener(OnHabitantesChangedListener listener){
		juego.obtenerMapa().setListenerCambiosCeldas(listener);
	}

	public void setOnAttackListener(OnAttackListener listener){
		juego.obtenerMapa().setListenerAtaques(listener);
	}


	public void setObserverVida(Jugador.modificacion_vida modificacion_vida){
		juego.obtenerJugador().setObsver_vida(modificacion_vida);
	}

	public void setObserverCreditos (Jugador.modificacion_creditos modificacion_creditos){
		juego.obtenerJugador().setObserver_creditos(modificacion_creditos);
	}

	public void setObserverTurno(Juego.ObserverTurno modificacion_turno){
		juego.setObserverTurno(modificacion_turno);
	}

}