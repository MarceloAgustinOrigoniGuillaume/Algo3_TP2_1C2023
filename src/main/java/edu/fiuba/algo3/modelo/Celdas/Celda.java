package edu.fiuba.algo3.modelo.Celdas;

import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.modelo.Defensas.Trampa;
import edu.fiuba.algo3.modelo.Defensas.Construccion;

import edu.fiuba.algo3.modelo.Mapa.Mapa;

import edu.fiuba.algo3.modelo.descriptors.CeldaDescriptor;
import edu.fiuba.algo3.modelo.descriptors.DefensaDescriptor;

//import edu.fiuba.algo3.modelo.Celdas.habitantes.HabitantesConstruccion;

public abstract class Celda extends CeldaConEnemigos{

    private Construccion construccionGuardada;

    public Celda(boolean habilitarTodos){
        super(habilitarTodos);
    }

    private boolean estaOcupada(){
        return construccionGuardada != null;
    }

    protected boolean guardaConstruccion(Construccion construccion){
        if(estaOcupada()){
            return false;
        }
        construccionGuardada = construccion;
        return true;
    }

    public void borrarDefensa(){
        Logger.Log("se borro la defensa: ", construccionGuardada);
        construccionGuardada = null;
    }




    // accionar estructuras, acciona a la construccion de tener una.
    public void accionarEstructuras(Mapa mapa, Coordenada desde){
        if(construccionGuardada != null){
            construccionGuardada.accionar(mapa,desde);
        }
    }

    // metodos publicos para el double dispatch
    public abstract boolean guardar(Trampa trampa);
    public abstract boolean guardar(Construccion construccion);
    public abstract boolean recibirAtaqueLechuza(OnAttackListener listener);


    private DefensaDescriptor describirDefensa() {
        if(this.construccionGuardada != null){
            return new DefensaDescriptor(this.construccionGuardada.toString(), this.construccionGuardada.estaActiva());
        }
        return new DefensaDescriptor();
    }

    public CeldaDescriptor describe(){
        return new CeldaDescriptor( this.toString(),
            describirDefensa(), describirEnemigos());
    }
}
