package edu.fiuba.algo3.modelo.Celdas;

import edu.fiuba.algo3.modelo.Defensas.Defensa;
import edu.fiuba.algo3.modelo.Enemigo.Enemigo;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.descriptors.CeldaDescriptor;

//import edu.fiuba.algo3.modelo.Celdas.habitantes.Habitantes;
import edu.fiuba.algo3.modelo.Celdas.habitantes.HabitantesConstruccion;

public abstract class Celda extends CeldaConEnemigos{

    protected HabitantesConstruccion construcciones;

    public Celda(boolean habilitarTodos,HabitantesConstruccion construcciones){
        super(habilitarTodos);
        this.construcciones = construcciones;
    }

    public HabitantesConstruccion defensas(){
        return construcciones;
    }

    public void accionarEstructuras(Mapa mapa, Coordenada posicion){
        construcciones.accionarEstructuras(mapa, posicion);
    }

    //Pre: -
    //Post: Describe a la celda para la ui... pone todos los datos necesarios
    public boolean defensaRecibirAtaqueAereo() {
        return  construcciones.recibirAtaqueLechuza();
    }

    public void limpiarDefensas() {
        construcciones.clear();
    }

    public boolean guardar(Defensa defensa) {
        return defensas().guardar(defensa);
    }

    public CeldaDescriptor describe(){
        return new CeldaDescriptor( this.toString() , cantidadUnidades(),
            construcciones.describir(), describirEnemigos());
    }
}
