package edu.fiuba.algo3.modelo.descriptors;

import java.util.ArrayList;

public class EnemigoDescriptor {
    private String nombre;
    private String tipo;
    private String velocidad;
    private String descripcion;

    public EnemigoDescriptor(String nombre,String tipo,String velocidad,String descripcion){
        this.tipo = tipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.velocidad = velocidad;
    }

    public String rel_image(){
        return "";
    }

    public String tipo(){
        return tipo;
    }

    public String descripcion(){
        return descripcion;
    }

    public String nombre(){
        return nombre;
    }

    public String infoStats(){
        return "velocidad: "+velocidad;
    }

}
