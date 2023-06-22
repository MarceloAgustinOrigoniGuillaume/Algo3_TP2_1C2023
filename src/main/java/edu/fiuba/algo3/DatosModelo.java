package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Defensas.Defensa;
import edu.fiuba.algo3.modelo.Defensas.torres.TorreBlanca;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Celdas.Coordenada;
import edu.fiuba.algo3.modelo.descriptors.CeldaDescriptor;

public class DatosModelo{
	private static final DatosModelo unicaInstancia = new DatosModelo();
	private static Juego juego;

	public static final int mapa_width = 15;
	public static final int mapa_height = 15;


	private DatosModelo(){
	}

	public static void nuevoJuego(String jsonMapa, String jsonEnemigos) throws Exception{
		if(unicaInstancia.juego != null){
			throw new Exception("Por el momento no se permite mas de una instancia del juego");
		}
		unicaInstancia.juego = new Juego(jsonMapa, jsonEnemigos);
	}

	public static Defensa instanciador(String tipoDeEstructura){

		if(tipoDeEstructura == "TorreBlanca"){
			//Defensa defensa = new TorreBlanca();
		}
		return new TorreBlanca();
	}

	public static void empezarJuegoActual(){
		if(unicaInstancia.juego == null){
			//throw new Exception("Por el momento no se permite mas de una instancia del juego");
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

}