package edu.fiuba.algo3.modelo.descriptors;

import java.util.ArrayList;

public class TopoDescriptor extends EnemigoDescriptor{
    private String cantidadMovimientos;
    private String turnos;

    public TopoDescriptor(String cantidadMovimientos, String turnos,String velocidad){
        super("Topo","subterraneo",velocidad,"ataca a jugador dependiendo de la paridad del turno");

        this.turnos = turnos;
        this.cantidadMovimientos = cantidadMovimientos;
    }

    @Override
    public String infoStats(){
        String res =super.infoStats();

        res+= "\n"+"movimientos: "+cantidadMovimientos;
        res+= "\n"+"turnos: "+turnos;
        return res;
    }
}
