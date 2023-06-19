package edu.fiuba.algo3.modelo.Lector;

import java.util.Map;
import java.util.ArrayList;

import edu.fiuba.algo3.modelo.Enemigo.terrestres.Arania;
import edu.fiuba.algo3.modelo.Enemigo.instanciacion.Instanciador;
import edu.fiuba.algo3.modelo.Enemigo.subterraneos.Topo;
import edu.fiuba.algo3.modelo.Enemigo.terrestres.Hormiga;

public class ConvertidorOleada implements Convertidor {

	public static final String HORMIGA_LABEL = "hormiga";
	public static final String ARANIA_LABEL = "arana";
	public static final String TOPO_LABEL = "topo";



    private int turno;
    private Map<String, Integer> aInstanciar;

    public ConvertidorOleada(String turno, Map<String,Integer> aInstanciar) throws Exception{
        this.turno = Integer.parseInt(turno);
        this.aInstanciar = aInstanciar;

        // capaz podriamos decir que si no estan, simplemente sera 0..
		if(!aInstanciar.containsKey(HORMIGA_LABEL)){
			throw new Exception("No tenia label Hormiga");
		}
		if (!aInstanciar.containsKey(ARANIA_LABEL)){
			throw new Exception("No tenia label Arania");
		}
		if (!aInstanciar.containsKey(TOPO_LABEL)){
			throw new Exception("No tenia label Topo");
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

		cantidad = aInstanciar.get(TOPO_LABEL);
		if(cantidad > 0){
			enemigosInstanciar.add(new Instanciador(new Topo(turno), cantidad));
		}

		return enemigosInstanciar;

    }

    public int getTurno(){
    	return turno;
    }

    public Object obtener() throws Exception {
        return obtenerInstanciador();// instanciar Oleada
    }
}
