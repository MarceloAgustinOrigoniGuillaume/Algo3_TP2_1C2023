package edu.fiuba.algo3.modelo.Enemigo;
import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.modelo.Celdas.Coordenada;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Celdas.habitantes.Habitantes;

import java.util.ArrayList;

public abstract class EnemigoAereo extends Enemigo {

    private int vidaCambioMovimiento;
    public EnemigoAereo(int vida, int velocidad){
        super(vida, velocidad);
        this.vidaCambioMovimiento= vida/2;
    }

    public boolean posicionarEn(Habitantes habitantes){
        return habitantes.guardar(this);
    }
    
    protected Coordenada movimientoAereo(Coordenada desde, Coordenada hasta){
        int x_nuevo = desde.x();
        int y_nuevo = desde.y();

        int x_final = hasta.x();
        int y_final = hasta.y();

        int restantePorMover = this.velocidad;

        if(vida <= vidaCambioMovimiento){
            while(restantePorMover>=2 && x_nuevo <= x_final && y_nuevo <= y_final){
                restantePorMover-=2;
                x_nuevo+=1;
                y_nuevo+=1;
            }
        }

        while(restantePorMover>0 && x_nuevo<=x_final){
            restantePorMover-=1;
            x_nuevo+=1;
        }

        while(restantePorMover>0 && y_nuevo<=y_final){
            restantePorMover-=1;
            y_nuevo+=1;
        }


        return new Coordenada(x_nuevo,y_nuevo);

    }

    @Override
    public void reducirVelocidad() {
        this.velocidad = (int)Math.floor(this.velocidad / 2);
    }

    @Override
    public void recibirAtaque(int danioRecibido) {
        this.vida = this.vida - danioRecibido;
        Logger.info("El daño recibido es: "+danioRecibido);
    }

    public int creditosDados(){
        return 1;
    }

    @Override
    public String toString(){
        return "Enemigo Aereo";
    }


    protected void moverse(Mapa mapa, Coordenada posicion){
        Coordenada meta = mapa.posicionFinal();
        mapa.mover(this,posicion,movimientoAereo(posicion, meta));
    }
}
