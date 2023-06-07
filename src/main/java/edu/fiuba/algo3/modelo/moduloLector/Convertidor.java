package edu.fiuba.algo3.modelo.moduloLector;

import java.util.Hashtable;

public class Convertidor {
private Hashtable<String,String> Valores;
    public Convertidor(){
        Valores = new Hashtable<>();
    }
    public String obtener(String key){

        return Valores.get(key);
    }
    protected void agregar(String key,String value){
        Valores.put(key,value);
    }
}
