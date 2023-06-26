package edu.fiuba.algo3.modelo.descriptors;

import java.util.ArrayList;
import edu.fiuba.algo3.modelo.Enemigo.Enemigo;

public class EnemigosDescriptor {
    private ArrayList<EnemigoDescriptor> enemigos;

    public EnemigosDescriptor(){
        enemigos = new ArrayList<>();
    }

    public void agregarEnemigo(Enemigo enemigo){
        enemigos.add(enemigo.describir());
    }

    public ArrayList<EnemigoDescriptor> getEnemigos(){
        return enemigos;
    }
}
