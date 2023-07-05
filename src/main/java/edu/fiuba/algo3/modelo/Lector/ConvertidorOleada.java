package edu.fiuba.algo3.modelo.Lector;

import java.util.Map;
import java.util.ArrayList;

import edu.fiuba.algo3.modelo.Enemigo.terrestres.Arania;
import edu.fiuba.algo3.modelo.Enemigo.instanciacion.Instanciador;
import edu.fiuba.algo3.modelo.Enemigo.subterraneos.Topo;
import edu.fiuba.algo3.modelo.Enemigo.terrestres.Hormiga;
import edu.fiuba.algo3.modelo.Enemigo.aereos.Lechuza;
import edu.fiuba.algo3.modelo.excepciones.enemigos.EnemigoFaltante;

public class ConvertidorOleada implements Convertidor {

	public static final String HORMIGA_LABEL = "hormiga";
	public static final String ARANIA_LABEL = "arana";
	public static final String TOPO_LABEL = "topo";
	public static final String LECHUZA_LABEL = "lechuza";



    private int turno;
    private Map<String, Integer> aInstanciar;

    public ConvertidorOleada(String turno, Map<String,Integer> aInstanciar) throws EnemigoFaltante{
        this.turno = Integer.parseInt(turno);
        this.aInstanciar = aInstanciar;

        // capaz podriamos decir que si no estan, simplemente sera 0..
		if(!aInstanciar.containsKey(HORMIGA_LABEL)){
			throw new EnemigoFaltante("No tenia label Hormiga");
		}
		if (!aInstanciar.containsKey(ARANIA_LABEL)){
			throw new EnemigoFaltante("No tenia label Arania");
		}
		if (!aInstanciar.containsKey(TOPO_LABEL)){
			aInstanciar.put(TOPO_LABEL, 0);
		}

		if (!aInstanciar.containsKey(LECHUZA_LABEL)){
			aInstanciar.put(LECHUZA_LABEL, 0);
		}
    }


    private ArrayList<Instanciador> obtenerInstanciador(){

		ArrayList<Instanciador> enemigosInstanciar = new ArrayList<>();

		int cantidad = aInstanciar.get(HORMIGA_LABEL);
		if(cantidad > 0){
			enemigosInstanciar.add(new Instanciador(new Hormiga(), cantidad));
		}

		cantidad = aInstanciar.get(ARANIA_LABEL);
		if(cantidad > 0){
			enemigosInstanciar.add(new Instanciador(new Arania(), cantidad));
		}

		cantidad = aInstanciar.get(LECHUZA_LABEL);
		if(cantidad > 0){
			enemigosInstanciar.add(new Instanciador(new Lechuza(), cantidad));
		}

		cantidad = aInstanciar.get(TOPO_LABEL);
		if(cantidad > 0){
			enemigosInstanciar.add(new Instanciador(new Topo(turno), cantidad));
		}
		return enemigosInstanciar;
    }

    public int getTurno(){
    	return turno;
    }

    public <T extends Object> T obtener() throws Exception {
        return (T) obtenerInstanciador();// instanciar Oleada
    }
}
