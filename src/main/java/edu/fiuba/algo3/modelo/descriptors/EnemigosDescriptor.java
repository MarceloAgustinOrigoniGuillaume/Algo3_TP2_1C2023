package edu.fiuba.algo3.modelo.descriptors;

import java.util.ArrayList;
import edu.fiuba.algo3.modelo.Enemigo.Enemigo;

public class EnemigosDescriptor {
    private ArrayList<EnemigoDescriptor> enemigos = new ArrayList<>();

    public EnemigosDescriptor(){
    }

    public EnemigosDescriptor(ArrayList<Enemigo> enemigos){

        for(Enemigo enemigo: enemigos){
            agregarEnemigo(enemigo);
        }

    }


    public int cantidadEnemigos(){
        return enemigos.size();
    }

    public void agregarEnemigo(Enemigo enemigo){
        enemigos.add(enemigo.describir());
    }

    public ArrayList<EnemigoDescriptor> getEnemigos(){
        return enemigos;
    }
}
