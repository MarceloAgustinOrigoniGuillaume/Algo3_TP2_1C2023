package edu.fiuba.algo3.modelo.Enemigo;

public class Topo implements Enemigo{

    private int contadorMovimientos

    private int vida;
    private int velocidad = 1;
    public Hormiga(){
        vida = 1;
    }

    public int velocidad(){
        return 1;
    }

    @Override
    public int creditosDados() {
        return 0;
    }

    public int ataque(){
        return 1;
        //target.recibirAtaque(1); // hace uno de dmg
    }

    @Override
    public void recibirAtaque(int atk) {

    }

    @Override
    public boolean estaMuerto() {
        return false;
    }

    @Override
    public Enemigo copiar() {
        return null;
    }
}
