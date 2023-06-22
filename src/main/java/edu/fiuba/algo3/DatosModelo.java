package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Defensas.Defensa;
import edu.fiuba.algo3.modelo.Defensas.torres.TorreBlanca;
import edu.fiuba.algo3.modelo.Defensas.torres.TorrePlateada;
import edu.fiuba.algo3.modelo.Defensas.Trampa;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Celdas.Coordenada;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.descriptors.CeldaDescriptor;
import edu.fiuba.algo3.modelo.Mapa.Mapa;

public class DatosModelo{
	private static final DatosModelo unicaInstancia = new DatosModelo();
	private Juego juego;

	public static final int mapa_width = 15;
	public static final int mapa_height = 15;


	private DatosModelo(){
	}

	public static void terminarJuego(){

		if(unicaInstancia.juego != null){
			unicaInstancia.juego.terminarJuego();
			unicaInstancia.juego = null;
			// opcional, la verdad... pero haras algun cleanup
		}

		//nuevoJuego(jsonMapa,jsonEnemigos);
	}



	// pasas un turno y devolves si sigue en juego
	public static boolean pasarTurno(){

		if(unicaInstancia.juego != null){

			Logger.Log("--------------------PASANDO TURNO !!!!");
			unicaInstancia.juego.pasarTurno();
			return unicaInstancia.juego.estanEnJuego();
		}

		return false;

		//nuevoJuego(jsonMapa,jsonEnemigos);
	}


	public static void nuevoJuego(String jsonMapa, String jsonEnemigos) throws Exception{
		if(unicaInstancia.juego != null){
			throw new Exception("Por el momento no se permite mas de una instancia del juego");
		}

		unicaInstancia.juego = new Juego(jsonMapa, jsonEnemigos);
	}

	public static Defensa instanciador(String tipoDeEstructura){

		if(tipoDeEstructura == "TorreBlanca"){
			return new TorreBlanca();
		}

		if(tipoDeEstructura == "TorrePlateada"){
			return new TorrePlateada();
		}

		if(tipoDeEstructura == "Trampa"){
			return new Trampa();
		}

		return null;
	}

	public static void empezarJuegoActual(){
		if(unicaInstancia.juego == null){
			//throw new Exception("Por el momento no se permite mas de una instancia del juego");
			Logger.Log("ERROR Quiso empezar juego sin un juego iniciado.");
			return;
		}

		unicaInstancia.juego.iniciarJuego();
	}

	public static CeldaDescriptor obtenerTerrenoEn(int x,int y){
		return unicaInstancia.juego.obtenerMapa().obtenerInformacion(new Coordenada(x,y));
	}

	public static boolean colocadorDeDefensas(Defensa defensa, Coordenada coordenada){
		Logger.info("Intento colocar"+defensa.toString()+" En la posicion"+coordenada.x()+"-"+coordenada.y());
		return unicaInstancia.juego.posicionar(defensa,coordenada);
	}


	public static void setOnCeldaChangedListener(Mapa.OnHabitantesChangedListener listener){
		if(unicaInstancia.juego == null){
			Logger.Log("ERROR Set on celda changed listener sin juego.");			
			return;
		}
		unicaInstancia.juego.obtenerMapa().setListenerCambiosCeldas(listener);
	}
	public static void setObserverVida(Jugador.modificacion_vida modificacion_vida){
		unicaInstancia.juego.obtenerJugador().setObsver_vida(modificacion_vida);
	}

	public static void setObserverCreditos (Jugador.modificacion_creditos modificacion_creditos){
		unicaInstancia.juego.obtenerJugador().setObserver_creditos(modificacion_creditos);
	}

	public  static void setObserverTurno(Juego.ObserverTurno modificacion_turno){
		unicaInstancia.juego.setObserverTurno(modificacion_turno);
	}

}