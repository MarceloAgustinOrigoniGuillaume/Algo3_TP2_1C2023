package edu.fiuba.algo3.modelo.descriptors;


public class DefensaDescriptor {

    private String defensa;
    private String url;
    private boolean estaActiva;

    public DefensaDescriptor(String defensa, boolean estaActiva){
        this.defensa = defensa;
        this.estaActiva = estaActiva;
        if(!estaActiva){
            this.url = "construccion.jpg";
            return;
        }
        if(defensa == "Trampa"){
            this.url = "Trampa.jpg";
        } else{
            this.url = defensa+"SinFondo.png";
        }
    }

    public boolean existe(){
        return this.url != null;
    }

    public DefensaDescriptor(){
        this.defensa = "No hay defensa en esta celda";
        this.url = null;
    }
    public String tipo(){
        return defensa;
    }

    public String estado(){
        if(estaActiva){
            return "activa";
        }
        return "construyendose";
    }


    public String rel_image(){
        if(this.url == null){
            return "";
        }
        return "defensas/"+url; // por ahora siempre la misma ja
    }
}
