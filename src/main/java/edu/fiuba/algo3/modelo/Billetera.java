package edu.fiuba.algo3.modelo;

public final class Billetera {
    private static Billetera billetera;

    private int hormigasMatadas;
    private int creditos;
    private Billetera(){
        this.creditos = 0;
        this.hormigasMatadas = 0;
    }

    public void agregarCreditos(int creditosAgregados){
        creditos += creditosAgregados;
    }

    public int agregarHormigaMatada() {
        hormigasMatadas++;
        return hormigasMatadas;
    }

    public void reducirCreditos(int creidosReducidos){
        creditos -= creidosReducidos;
    }

    public int obtenerCreditos(){
        return creditos;
    }

    public void restablecerCreditos(){
        creditos = 0;
    }
    public static Billetera getInstance(){
        if(billetera == null){
            billetera = new Billetera();
        }
        return billetera;
    }
}