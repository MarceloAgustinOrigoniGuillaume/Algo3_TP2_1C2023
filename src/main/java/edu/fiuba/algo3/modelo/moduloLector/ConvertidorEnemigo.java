package edu.fiuba.algo3.modelo.moduloLector;

public class ConvertidorEnemigo extends Convertidor {
    public ConvertidorEnemigo(String tipo, String turno, String cantidad){
        super();
        this.agregar("tipo", tipo);
        this.agregar("turno",turno);
        this.agregar("cantidad", cantidad);
    }
}
