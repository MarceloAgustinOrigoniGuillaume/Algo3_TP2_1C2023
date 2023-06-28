package edu.fiuba.algo3.modelo.Celdas;



import edu.fiuba.algo3.modelo.Defensas.Trampa;
import edu.fiuba.algo3.modelo.Defensas.Construccion;


public class Pasarela extends Celda{

    public final static String PASARELA_TYPE = "Pasarela";

    public Pasarela(){
        super(true);
    }

	// puede guardar Trampas
	public boolean guardar(Trampa trampa){
		return guardaConstruccion(trampa); // por default Habitantes no podria guardar nada... cada implementacion sobreescribira
	}

	// no puede guardar torres
	public boolean guardar(Construccion torre){
		return false; 
	}

	// No recibe ataques de lechuza, trampa no lo hace.
	public boolean recibirAtaqueLechuza(){
		return false;
	}
	
	
    @Override
    public String toString(){
        return PASARELA_TYPE;
    }

}
