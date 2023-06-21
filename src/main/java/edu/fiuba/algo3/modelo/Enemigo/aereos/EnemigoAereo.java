package edu.fiuba.algo3.modelo.Enemigo.aereos;
import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.modelo.Enemigo.SistemaVida;
import edu.fiuba.algo3.modelo.Enemigo.Enemigo;
import edu.fiuba.algo3.modelo.Enemigo.Monetizable;
import edu.fiuba.algo3.modelo.Celdas.habitantes.Habitantes;

public abstract class EnemigoAereo extends Enemigo implements Monetizable, SistemaVida {
    protected int vida;
    private int vidaCambioMovimiento;

    public EnemigoAereo(int vida, int velocidad) {
        super(velocidad);
        this.vida = vida;
    }
    public boolean posicionarEn(Habitantes habitantes){
        return habitantes.guardar(this);
    }
    public boolean estaMuerto(){
        return vida <= 0;
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
}
